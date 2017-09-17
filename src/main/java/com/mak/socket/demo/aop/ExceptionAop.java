package com.mak.socket.demo.aop;

import com.mak.socket.demo.exception.ServiceException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * 异常处理切面
 * Created by Administrator on 2017/9/17 0017.
 */
@Aspect
public class ExceptionAop {
    /**
     * 捕获ServiceException，打印堆栈信息
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "execution(* com.mak.socket.demo.web..*(..))")
    public Object serverExceptionAop(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = null;
        try {
            obj = pjp.proceed();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return obj;
    }
}

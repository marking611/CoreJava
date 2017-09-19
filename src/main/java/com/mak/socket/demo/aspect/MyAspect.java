package com.mak.socket.demo.aspect;

import com.mak.socket.demo.exception.ServiceException;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 切面
 * Created by Administrator on 2017/9/17 0017.
 */
@Aspect
@Component
public final class MyAspect {
    private Logger logger = LoggerFactory.getLogger(MyAspect.class);

    /**
     * 切点
     */
    @Pointcut(value = "execution(* com.mak.socket.demo.web..*(..))")
    public void cut() {
    }

    /**
     * 调用接口信息
     *
     * @param jp
     */
    @Before(value = "cut()")
    public void interfaceInfo(JoinPoint jp) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String methorType = request.getMethod();
//        Object object = jp.getThis(); //代理对象
        Object target = jp.getTarget(); //对象本身
        String className = target.getClass().getName();
        Signature signature = jp.getSignature();
        String methodName = signature.getName();
        Object[] args = jp.getArgs();
        List<String> argArray = new ArrayList<>();
        for (Object o : args) {
            String argType = o.getClass().getName();
            String argValue = o.toString();
            String arg = argType + " " + argValue;
            argArray.add(arg);
        }
        String arg = StringUtils.join(argArray,",");
        logger.info(methorType + "调用：" + className + "." + methodName + "(" + arg + ")");

    }


    /**
     * 捕获ServiceException，打印堆栈信息
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "cut()")
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

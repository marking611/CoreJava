package com.mak.socket.demo.exception;

/**
 * 业务代码异常
 * Created by Administrator on 2017/9/14 0014.
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -3911894802863290855L;
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

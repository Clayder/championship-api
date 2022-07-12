package com.clayder.championship.core.exceptions.type;


import org.slf4j.Logger;

public class BusinessException extends RuntimeException {

    public BusinessException(String s, Logger logger) {
        super(s);
        logger.error(s);
    }

    public BusinessException(String s) {
        super(s);
    }

    public BusinessException(String msg, Throwable cause, Logger logger) {
        super(msg, cause);
        logger.error(msg);
    }
}

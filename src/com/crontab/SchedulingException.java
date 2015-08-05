package com.crontab;

/**
 * scheduling exception
 */
public class SchedulingException extends RuntimeException {

    public SchedulingException() {
    }

    public SchedulingException(String message) {
        super(message);
    }

    public SchedulingException(String message, Throwable cause) {
        super(message, cause);
    }

    public SchedulingException(Throwable cause) {
        super(cause);
    }
}

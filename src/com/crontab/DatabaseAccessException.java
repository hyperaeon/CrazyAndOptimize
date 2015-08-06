package com.crontab;

/**
 * Database access exception for DAO layer
 */
public class DatabaseAccessException extends RuntimeException {
    public DatabaseAccessException() {
    }

    public DatabaseAccessException(String message) {
        super(message);
    }

    public DatabaseAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseAccessException(Throwable cause) {
        super(cause);
    }
}

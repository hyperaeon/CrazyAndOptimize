package com.crontab;

public class ObjectNotFoundException extends RuntimeException {
    /**
     * The default serial version UID.
     */
    private static final long serialVersionUID = 2944399906357420546L;

    /**
     * Constructs a new exception with the specified detail message.
     * 
     * @param message
     *            Cause of this Exception
     */
    public ObjectNotFoundException(final String message) {
        // Constructor that takes an error message
        // as an argument. Invokes the superclass
        // constructor with the same arguments.
        // Sets the error code to default.
        super(message);
    }
    
    public ObjectNotFoundException(final String message, Throwable rootException) {
    	super(message, rootException);
    }
}

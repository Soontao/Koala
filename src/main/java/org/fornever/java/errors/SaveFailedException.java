package org.fornever.java.errors;

public class SaveFailedException extends Exception {

    private static final long serialVersionUID = 6436304646433970994L;

    public SaveFailedException(String message) {
        super(message);
    }

}

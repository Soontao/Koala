package org.fornever.java.errors;

public class DeleteFailedException extends Exception {

    private static final long serialVersionUID = -1975009529910546366L;

    public DeleteFailedException(String msg) {
        super(msg);
    }

}

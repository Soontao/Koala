package org.fornever.java.exceptions;

public class ReadFailedException extends KoalaBaseException {

    protected Object searchParam;

    public ReadFailedException(Object searchParam) {
        super();
        this.searchParam = searchParam;
    }

}

package org.fornever.koala.exceptions;

public class ReadFailedException extends KoalaBaseException {

    protected Object searchParam;

    public ReadFailedException(Object searchParam) {
        super();
        this.searchParam = searchParam;
    }

}

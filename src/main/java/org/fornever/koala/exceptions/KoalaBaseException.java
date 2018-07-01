package org.fornever.koala.exceptions;

public class KoalaBaseException extends Exception {

    private String transactionUser = "unknown";

    public KoalaBaseException(){
        
    }

    public KoalaBaseException(String msg) {
        super(msg);
    }

}

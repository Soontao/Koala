package org.fornever.koala.exceptions;

public class KoalaBaseException extends Exception {

    private String transactionUser = "unknown";

    public String getTransactionUser() {
        return transactionUser;
    }

    public KoalaBaseException setTransactionUser(String transactionUser) {
        this.transactionUser = transactionUser;
        return this;
    }

    public KoalaBaseException() {

    }

    public KoalaBaseException(String msg) {
        super(msg);
    }

}

package org.fornever.koala.entities.enums;

public enum EIDValidationLevel {

    /**
     * Dont check whether id existing, wait error happened on local or remote db
     */
    NONE,
    /**
     * Check ID in local DB before create
     */
    LOCAL,
    /**
     * check ID in remote system before create
     */
    REMOTE,

}

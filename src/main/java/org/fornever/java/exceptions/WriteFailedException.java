package org.fornever.java.exceptions;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.entities.WriteType;

public class WriteFailedException extends KoalaBaseException {

    private KoalaEntity entity;

    private WriteType type;

    public WriteFailedException(KoalaEntity entity, WriteType type) {
        super();
        this.entity = entity;
        this.type = type;
    }

    public KoalaEntity getEntity() {
        return entity;
    }

    public WriteFailedException setEntity(KoalaEntity entity) {
        this.entity = entity;
        return this;
    }

}

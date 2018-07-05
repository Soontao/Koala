package org.fornever.koala.exceptions;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.entities.enums.EWriteType;

public class WriteFailedException extends KoalaBaseException {

    private KoalaEntity entity;

    private EWriteType type;

    public WriteFailedException(KoalaEntity entity, EWriteType type) {
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

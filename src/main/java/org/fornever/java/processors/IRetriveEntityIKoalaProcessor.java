package org.fornever.java.processors;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.exceptions.NotFoundException;

public interface IRetriveEntityIKoalaProcessor<E extends KoalaEntity> extends IKoalaProcessor {

    E retrive(Long key) throws NotFoundException;

}

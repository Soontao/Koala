package org.fornever.koala.processors;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.NotFoundException;

public interface IRetriveEntityIKoalaProcessor<E extends KoalaEntity> extends IKoalaProcessor {

    E retrive(Long key) throws NotFoundException;

}

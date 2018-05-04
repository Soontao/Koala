package org.fornever.java.processor;

import org.fornever.java.entity.KoalaBaseEntity;

public interface IRetriveEntityProcessor<E extends KoalaBaseEntity> {

    E retrive(Long key);

}

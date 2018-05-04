package org.fornever.java.processor;

import org.fornever.java.entity.KoalaBaseEntity;

public interface IFinallySaveFailedToRemoteProcessor<T extends KoalaBaseEntity> {
    void notify(T entity);
}

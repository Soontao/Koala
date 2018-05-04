package org.fornever.java.processor;

import org.fornever.java.entity.KoalaBaseEntity;
import org.fornever.java.errors.NotImplementationException;
import org.fornever.java.errors.UpdateFailedException;

public interface IUpdateEntityProcessor<T extends KoalaBaseEntity> {
    T update(Long koalaId, T entity) throws UpdateFailedException, NotImplementationException;
}

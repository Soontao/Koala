package org.fornever.java.processors;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.exceptions.NotImplementationException;
import org.fornever.java.exceptions.WriteFailedException;

/**
 * update record to local database
 *
 * @param <T>
 */
public interface IUpdateEntityIKoalaProcessor<T extends KoalaEntity> extends IKoalaProcessor {
    T update(Long koalaId, T entity) throws WriteFailedException, NotImplementationException;
}

package org.fornever.koala.processors;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.WriteFailedException;

/**
 * update record to local database
 *
 * @param <T>
 */
public interface IUpdateEntityIKoalaProcessor<T extends KoalaEntity> extends IKoalaProcessor {
    T update(Long koalaId, T entity) throws WriteFailedException, NotImplementationException;
}

package org.fornever.koala.processors;

import org.fornever.koala.exceptions.WriteFailedException;

/**
 * Save new record to local database
 *
 * @param <T>
 */
public interface ISaveEntityIKoalaProcessor<T> extends IKoalaProcessor {
    T save(T entity) throws WriteFailedException;
}

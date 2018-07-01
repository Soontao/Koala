package org.fornever.java.processors;

import org.fornever.java.exceptions.WriteFailedException;

/**
 * Save new record to local database
 *
 * @param <T>
 */
public interface ISaveEntityIKoalaProcessor<T> extends IKoalaProcessor {
    T save(T entity) throws WriteFailedException;
}

package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.IKoalaProcessor;

/**
 * Save new record to local database
 *
 * @param <T>
 */
public interface ISaveEntityProcessor<T> extends IKoalaProcessor {

    T save(T entity) throws WriteFailedException, NotImplementationException, ValidationException;

}

package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.IKoalaProcessor;

/**
 * update record to local database
 *
 * @param <T>
 */
public interface IUpdateEntityProcessor<T> extends IKoalaProcessor {

    T update(T entity) throws WriteFailedException, NotImplementationException, ValidationException;

}

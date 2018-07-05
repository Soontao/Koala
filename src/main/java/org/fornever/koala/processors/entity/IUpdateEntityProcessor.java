package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;

/**
 * update record to local database
 *
 * @param <T>
 */
public interface IUpdateEntityProcessor<T> {

    T update(T entity) throws WriteFailedException, NotImplementationException, ValidationException;

}

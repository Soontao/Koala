package org.fornever.koala.processors.internal;

import org.fornever.koala.entities.ValidationError;
import org.fornever.koala.exceptions.NotImplementationException;

public interface IEntityValidator<T> {

    ValidationError validation(T entity) throws NotImplementationException;

}

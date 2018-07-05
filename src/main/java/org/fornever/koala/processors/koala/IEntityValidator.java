package org.fornever.koala.processors.koala;

import org.fornever.koala.entities.ValidationError;
import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.processors.IKoalaProcessor;

public interface IEntityValidator<T> extends IKoalaProcessor {

    ValidationError validation(T entity) throws NotImplementationException;

}

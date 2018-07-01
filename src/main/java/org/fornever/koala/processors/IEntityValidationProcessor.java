package org.fornever.koala.processors;

import org.fornever.koala.entities.ValidationError;

public interface IEntityValidationProcessor<T> extends IKoalaProcessor {

    ValidationError validation(T entity);

}

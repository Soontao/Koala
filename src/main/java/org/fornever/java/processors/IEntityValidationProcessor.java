package org.fornever.java.processors;

import org.fornever.java.entities.ValidationError;

public interface IEntityValidationProcessor<T> extends IKoalaProcessor {

    ValidationError validation(T entity);

}

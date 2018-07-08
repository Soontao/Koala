package org.fornever.koala.processors.internal;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.types.internal.ValidationError;

public interface IEntityValidator<T> {

	default ValidationError validate(Object key, T entity) throws NotImplementationException {
		return new ValidationError();
	}

}

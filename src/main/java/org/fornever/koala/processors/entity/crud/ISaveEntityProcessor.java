package org.fornever.koala.processors.entity.crud;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;

public interface ISaveEntityProcessor<T> {

	/**
	 * <p>For local save, please must generated key, and return generated instance.<p/>
	 *
	 * <p>For remote save, you can choose whether generate a key, depends on your remote system</p>
	 *
	 * @param entity
	 * @return
	 * @throws WriteFailedException
	 * @throws NotImplementationException
	 * @throws ValidationException
	 */
	default T save(T entity) throws WriteFailedException, NotImplementationException, ValidationException {
		throw new NotImplementationException();
	}

}

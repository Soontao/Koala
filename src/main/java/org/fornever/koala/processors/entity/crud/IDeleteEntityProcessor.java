package org.fornever.koala.processors.entity.crud;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.WriteFailedException;

public interface IDeleteEntityProcessor<K> {

	Boolean delete(K key) throws WriteFailedException, NotImplementationException;

}

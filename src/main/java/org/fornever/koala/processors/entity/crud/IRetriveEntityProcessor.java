package org.fornever.koala.processors.entity.crud;

import org.fornever.koala.exceptions.NotFoundException;

public interface IRetriveEntityProcessor<T> {

	T retrive(String key) throws NotFoundException;

}

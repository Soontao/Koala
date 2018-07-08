package org.fornever.koala.processors.entity.processors;

import org.fornever.koala.processors.entity.crud.*;
import org.fornever.koala.processors.internal.abs.AEntityValidator;

public interface IKoalaLocalProcessors<T, K, S> {

	IRetriveEntityProcessor<T> getLocalRetrieveProcessor();

	IReadEntityProcessor<T, S> getLocalReadProcessor();

	ISaveEntityProcessor<T> getLocalSaveProcessor();

	IUpdateEntityProcessor<T, K> getLocalUpdateProcessor();

	IDeleteEntityProcessor<K> getLocalDeleteProcessor();

	AEntityValidator<T> getLocalValidator();

}

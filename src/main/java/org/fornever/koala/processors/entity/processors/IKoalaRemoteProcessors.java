package org.fornever.koala.processors.entity.processors;

import org.fornever.koala.processors.entity.crud.*;
import org.fornever.koala.processors.internal.IEntityValidator;

public interface IKoalaRemoteProcessors<T, K, S> {

	IRetriveEntityProcessor<T> getRemoteRetrieveProcessor();

	IReadEntityProcessor<T, S> getRemoteReadProcessor();

	ISaveEntityProcessor<T> getRemoteSaveProcessor();

	IUpdateEntityProcessor<T, K> getRemoteUpdateProcessor();

	IDeleteEntityProcessor<K> getRemoteDeleteProcessor();

	IEntityValidator<T> getRemoteValidator();

}

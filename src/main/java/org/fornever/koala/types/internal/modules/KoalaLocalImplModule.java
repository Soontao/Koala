package org.fornever.koala.types.internal.modules;

import org.fornever.koala.processors.entity.crud.*;
import org.fornever.koala.types.annotations.LocalProcessor;

public abstract class KoalaLocalImplModule<T, K, S> extends KoalaBaseModule<T, K, S> {

	@Override
	protected void configure() {

		bind(IRetriveEntityProcessor.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalRetrieveProcessor());

		bind(IReadEntityProcessor.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalReadProcessor());

		bind(IDeleteEntityProcessor.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalDeleteProcessor());

		bind(IUpdateEntityProcessor.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalUpdateProcessor());

		bind(ISaveEntityProcessor.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalSaveProcessor());

	}

	public abstract IRetriveEntityProcessor<T> provideLocalRetrieveProcessor();

	public abstract IReadEntityProcessor<T, S> provideLocalReadProcessor();

	public abstract ISaveEntityProcessor<T> provideLocalSaveProcessor();

	public abstract IUpdateEntityProcessor<T, K> provideLocalUpdateProcessor();

	public abstract IDeleteEntityProcessor<K> provideLocalDeleteProcessor();

}

package org.fornever.koala.types.internal.modules;

import org.fornever.koala.processors.entity.crud.*;
import org.fornever.koala.types.annotations.RemoteProcessor;

public abstract class KoalaRemoteImplModule<T, K, S> extends KoalaBaseModule<T, K, S> {

	@Override
	protected void configure() {

		bind(IRetriveEntityProcessor.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteRetrieveProcessor());

		bind(IReadEntityProcessor.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteReadProcessor());

		bind(IDeleteEntityProcessor.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteDeleteProcessor());

		bind(IUpdateEntityProcessor.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteUpdateProcessor());

		bind(ISaveEntityProcessor.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteSaveProcessor());

	}

	public abstract IRetriveEntityProcessor<T> provideRemoteRetrieveProcessor();

	public abstract IReadEntityProcessor<T, S> provideRemoteReadProcessor();

	public abstract ISaveEntityProcessor<T> provideRemoteSaveProcessor();

	public abstract IUpdateEntityProcessor<T, K> provideRemoteUpdateProcessor();

	public abstract IDeleteEntityProcessor<K> provideRemoteDeleteProcessor();


}

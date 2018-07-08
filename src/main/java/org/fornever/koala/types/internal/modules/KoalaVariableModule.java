package org.fornever.koala.types.internal.modules;

import org.fornever.koala.processors.entity.helper.IKoalaKeyAccessor;
import org.fornever.koala.processors.internal.abs.AEntityValidator;
import org.fornever.koala.types.annotations.LocalProcessor;
import org.fornever.koala.types.annotations.RemoteProcessor;

public abstract class KoalaVariableModule<T, K, S> extends KoalaBaseModule<T, K, S> {

	@Override
	protected void configure() {

		bind(AEntityValidator.class)
				.annotatedWith(LocalProcessor.class)
				.toInstance(provideLocalValidator());

		bind(AEntityValidator.class)
				.annotatedWith(RemoteProcessor.class)
				.toInstance(provideRemoteValidator());

		bind(IKoalaKeyAccessor.class)
				.toInstance(provideKeyAccessor());

	}

	public AEntityValidator<T> provideLocalValidator() {
		return new AEntityValidator<T>() {
		};
	}


	public AEntityValidator<T> provideRemoteValidator() {
		return new AEntityValidator<T>() {
		};
	}

	public abstract IKoalaKeyAccessor<T, K> provideKeyAccessor();


}

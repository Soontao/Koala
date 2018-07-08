package org.fornever.koala.types.internal.modules;

import com.google.inject.AbstractModule;

public abstract class KoalaBaseModule<T, K, S> extends AbstractModule {

	@Override
	protected abstract void configure();

}

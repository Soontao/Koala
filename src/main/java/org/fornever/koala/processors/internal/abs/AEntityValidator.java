package org.fornever.koala.processors.internal.abs;

import com.google.inject.Inject;
import org.fornever.koala.processors.entity.crud.IRetriveEntityProcessor;
import org.fornever.koala.processors.internal.IEntityValidator;
import org.fornever.koala.types.annotations.LocalProcessor;
import org.fornever.koala.types.annotations.RemoteProcessor;

public abstract class AEntityValidator<T> implements IEntityValidator<T> {

	protected IRetriveEntityProcessor<T> local;

	protected IRetriveEntityProcessor<T> remote;

	@Inject
	public AEntityValidator<T> setLocal(@LocalProcessor IRetriveEntityProcessor<T> local) {
		this.local = local;
		return this;
	}

	@Inject
	public AEntityValidator<T> setRemote(@RemoteProcessor IRetriveEntityProcessor<T> remote) {
		this.remote = remote;
		return this;
	}

}

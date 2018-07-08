package org.fornever.koala.processors.internal.abs;

import com.google.inject.Inject;
import org.fornever.koala.processors.entity.crud.ISaveEntityProcessor;
import org.fornever.koala.processors.entity.crud.IUpdateEntityProcessor;
import org.fornever.koala.processors.internal.IKoalaReferenceUpdater;
import org.fornever.koala.schedule.ITaskQueue;
import org.fornever.koala.types.annotations.LocalProcessor;
import org.fornever.koala.types.enums.EKoalaInstanceState;
import org.fornever.koala.types.internal.KoalaConfig;
import org.fornever.koala.types.internal.KoalaReferenceEntity;

public abstract class AKoalaReferenceUpdater<T> implements IKoalaReferenceUpdater<T> {

	protected ITaskQueue queue;

	protected KoalaConfig config;

	protected ISaveEntityProcessor saver;

	protected IUpdateEntityProcessor updater;

	@Inject
	public AKoalaReferenceUpdater<T> setSaver(@LocalProcessor ISaveEntityProcessor saver) {
		this.saver = saver;
		return this;
	}

	@Inject
	public AKoalaReferenceUpdater<T> setUpdater(@LocalProcessor IUpdateEntityProcessor updater) {
		this.updater = updater;
		return this;
	}

	@Inject
	public AKoalaReferenceUpdater setQueue(ITaskQueue queue) {
		this.queue = queue;
		return this;
	}

	@Inject
	public AKoalaReferenceUpdater<T> setConfig(KoalaConfig config) {
		this.config = config;
		return this;
	}

}

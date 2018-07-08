package org.fornever.koala.types.internal.modules;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.fornever.koala.processors.IKoalaProcessors;
import org.fornever.koala.processors.internal.IFinallyFailedNotifier;
import org.fornever.koala.processors.internal.IKoalaInstanceSelector;
import org.fornever.koala.processors.internal.abs.AKoalaReferenceUpdater;
import org.fornever.koala.schedule.ITaskQueue;
import org.fornever.koala.schedule.abs.AScheduleRunner;
import org.fornever.koala.schedule.impl.DefaultScheduleRunner;
import org.fornever.koala.schedule.impl.DefaultTaskQueue;

public abstract class KoalaInternalImplModule<T, K, S> extends KoalaBaseModule<T, K, S> {

	@Override
	protected void configure() {

		bind(IKoalaInstanceSelector.class)
				.toInstance(provideInstanceSelector());

		bind(IFinallyFailedNotifier.class)
				.toInstance(provideFinallyFailedNotifier());

		bind(AKoalaReferenceUpdater.class)
				.toInstance(provideReferenceUpdater());

	}

	public abstract AKoalaReferenceUpdater<T> provideReferenceUpdater();

	public abstract IKoalaInstanceSelector<T> provideInstanceSelector();

	public abstract IFinallyFailedNotifier<T> provideFinallyFailedNotifier();


	@Singleton
	@Provides
	public AScheduleRunner provideScheduleRunner(IKoalaProcessors processors, ITaskQueue queue) {
		return new DefaultScheduleRunner().setProcessors(processors).setTaskQueue(queue);
	}

	@Singleton
	@Provides
	public ITaskQueue<T> provideTaskQueue() {
		return new DefaultTaskQueue<T>();
	}

}

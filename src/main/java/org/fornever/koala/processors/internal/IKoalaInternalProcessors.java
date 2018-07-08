package org.fornever.koala.processors.internal;

import org.fornever.koala.processors.internal.abs.AKoalaReferenceUpdater;

public interface IKoalaInternalProcessors<T, K> {

	IKoalaInstanceSelector<T> getPersistSelector();

	IFinallyFailedNotifier<T> getFinallyFailedNotifier();

	AKoalaReferenceUpdater<K> getReferenceUpdator();

}

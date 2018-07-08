package org.fornever.koala.processors.internal;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.ValidationException;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.types.enums.EKoalaInstanceState;
import org.fornever.koala.types.internal.KoalaReferenceEntity;

public interface IKoalaReferenceUpdater<K> {

	/**
	 * <p>update koala reference </p>
	 * <p>if necessary, arrange a KoalaSyncTask</p>
	 *
	 * @param key
	 * @param nextState
	 * @return
	 */
	KoalaReferenceEntity updateKoalaReference(K key, EKoalaInstanceState nextState) throws ValidationException, WriteFailedException, NotImplementationException;

}

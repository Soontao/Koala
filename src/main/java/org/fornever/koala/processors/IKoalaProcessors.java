package org.fornever.koala.processors;

import org.fornever.koala.processors.entity.helper.IKoalaKeyAccessor;
import org.fornever.koala.processors.entity.processors.IKoalaLocalProcessors;
import org.fornever.koala.processors.entity.processors.IKoalaRemoteProcessors;
import org.fornever.koala.processors.internal.IKoalaInternalProcessors;

public interface IKoalaProcessors<T, K, S>
		extends IKoalaInternalProcessors<T, K>, IKoalaRemoteProcessors<T, K, S>, IKoalaLocalProcessors<T, K, S> {

	IKoalaKeyAccessor<T, K> getKeyAccessor();

}

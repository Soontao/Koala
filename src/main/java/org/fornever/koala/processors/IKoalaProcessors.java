package org.fornever.koala.processors;

import org.fornever.koala.processors.entity.IKoalaLocalProcessors;
import org.fornever.koala.processors.entity.IKoalaRemoteProcessors;
import org.fornever.koala.processors.internal.IKoalaInternalProcessors;

public interface IKoalaProcessors<T, S> extends IKoalaInternalProcessors<T>, IKoalaRemoteProcessors<T, S>, IKoalaLocalProcessors<T, S> {
}

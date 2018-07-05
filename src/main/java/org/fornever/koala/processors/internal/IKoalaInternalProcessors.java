package org.fornever.koala.processors.internal;

import org.fornever.koala.processors.internal.IKoalaInstanceSelector;
import org.fornever.koala.processors.internal.IKoalaReferenceUpdator;

public interface IKoalaInternalProcessors<T> {

    IKoalaInstanceSelector<T> getPersistSelector();

    IKoalaReferenceUpdator<T> getReferenceUpdator();


}

package org.fornever.koala.processors.koala;

import org.fornever.koala.processors.IKoalaProcessor;

public interface IKoalaInstanceSelector<E> extends IKoalaProcessor {

    E select(Integer maxRetryCount);

}

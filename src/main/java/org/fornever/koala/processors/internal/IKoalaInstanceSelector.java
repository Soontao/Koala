package org.fornever.koala.processors.internal;

public interface IKoalaInstanceSelector<E> {

    E select(Integer maxRetryCount);

}

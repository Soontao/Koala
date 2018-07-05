package org.fornever.koala.processors.koala;

public interface IKoalaKeyAccessor<T> {

    String getKey(T instance);

}

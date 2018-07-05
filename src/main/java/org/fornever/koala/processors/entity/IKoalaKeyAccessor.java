package org.fornever.koala.processors.entity;

public interface IKoalaKeyAccessor<T> {

    String getKey(T instance);

}

package org.fornever.koala.processors.entity.helper;

public interface IKoalaKeyAccessor<T, K> {

	K getKey(T instance);

}

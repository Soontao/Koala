package org.fornever.java.processor;

public interface IUpdateEntityProcessor<T, K> {
	T update(K key, T entity) throws Exception;
}

package org.fornever.java.processor;

public interface ISaveEntityProcessor<T> {
	T save(T entity) throws Exception;
}

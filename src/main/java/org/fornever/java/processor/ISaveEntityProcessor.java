package org.fornever.java.processor;

import org.fornever.java.errors.SaveFailedException;

public interface ISaveEntityProcessor<T> {
    T save(T entity) throws SaveFailedException;
}

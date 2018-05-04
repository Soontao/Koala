package org.fornever.java.processor;

import org.fornever.java.errors.DeleteFailedException;
import org.fornever.java.errors.NotImplementationException;

import java.awt.RenderingHints.Key;

public interface IDeleteEntityProcessor<K> {
    Boolean delete(Key key) throws DeleteFailedException, NotImplementationException;
}

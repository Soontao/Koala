package org.fornever.java.processor;

import java.awt.RenderingHints.Key;

public interface IDeleteEntityProcessor<K> {
	Boolean delete(Key key) throws Exception;
}

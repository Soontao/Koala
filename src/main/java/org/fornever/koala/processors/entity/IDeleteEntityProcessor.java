package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.WriteFailedException;

public interface IDeleteEntityProcessor {

    Boolean delete(String key) throws WriteFailedException, NotImplementationException;

}

package org.fornever.koala.processors.entity;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.IKoalaProcessor;

public interface IDeleteEntityProcessor extends IKoalaProcessor {

    Boolean delete(String key) throws WriteFailedException, NotImplementationException;

}

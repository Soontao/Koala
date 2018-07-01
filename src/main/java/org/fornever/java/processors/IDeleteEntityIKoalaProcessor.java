package org.fornever.java.processors;

import org.fornever.java.exceptions.NotImplementationException;
import org.fornever.java.exceptions.WriteFailedException;

public interface IDeleteEntityIKoalaProcessor extends IKoalaProcessor {
    Boolean delete(Long key) throws WriteFailedException, NotImplementationException;
}

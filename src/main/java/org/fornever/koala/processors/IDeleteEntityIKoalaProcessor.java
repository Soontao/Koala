package org.fornever.koala.processors;

import org.fornever.koala.exceptions.NotImplementationException;
import org.fornever.koala.exceptions.WriteFailedException;

public interface IDeleteEntityIKoalaProcessor extends IKoalaProcessor {
    Boolean delete(Long key) throws WriteFailedException, NotImplementationException;
}

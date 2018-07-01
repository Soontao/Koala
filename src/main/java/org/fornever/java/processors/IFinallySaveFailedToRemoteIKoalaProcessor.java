package org.fornever.java.processors;

import org.fornever.java.entities.KoalaEntity;
import org.fornever.java.exceptions.WriteFailedException;

/**
 * sync data failed after retry, maybe write/update/delete failed from remote
 *
 * @param <T>
 */
public interface IFinallySaveFailedToRemoteIKoalaProcessor<T extends KoalaEntity> extends IKoalaProcessor {
    void notify(WriteFailedException exception);
}

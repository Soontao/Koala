package org.fornever.koala.processors;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.WriteFailedException;

/**
 * sync data failed after retry, maybe write/update/delete failed from remote
 *
 * @param <T>
 */
public interface IFinallySaveFailedToRemoteIKoalaProcessor<T extends KoalaEntity> extends IKoalaProcessor {
    void notify(WriteFailedException exception);
}

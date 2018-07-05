package org.fornever.koala.processors.koala;

import org.fornever.koala.entities.KoalaEntity;
import org.fornever.koala.exceptions.WriteFailedException;
import org.fornever.koala.processors.IKoalaProcessor;

/**
 * sync data failed after retry, maybe write/update/delete failed from remote
 *
 * @param <T>
 */
public interface IFinallyFailedNotifier<T> extends IKoalaProcessor {

    void notify(WriteFailedException exception);

}

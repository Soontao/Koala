package org.fornever.koala.processors.internal;

import org.fornever.koala.exceptions.WriteFailedException;

/**
 * sync data failed after retry, maybe write/update/delete failed from remote
 *
 * @param <T>
 */
public interface IFinallyFailedNotifier<T> {

    void notify(WriteFailedException exception);

}

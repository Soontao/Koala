package org.fornever.java.processors;

import org.fornever.java.entities.KoalaEntity;

public interface IKoalaPersistSelector<E extends KoalaEntity> extends IKoalaProcessor {

    /**
     * select one record from persistence
     * <p>
     * the record should be:
     * <p>
     * 1. entities.remotePersisted == false
     * <p>
     * 2. entities.createdDate farthest one from current time
     * <p>
     * 3. entities.koalaPersistRetryCount field should be less than maxRetryCount
     *
     * @return
     */
    E select(Integer maxRetryCount);

}

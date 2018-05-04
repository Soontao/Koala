package org.fornever.java.processor;

import org.fornever.java.entity.KoalaBaseEntity;

public interface IPesistSelector<E extends KoalaBaseEntity> {

    /**
     * select one record from persistence
     * <p>
     * the record should be:
     * <p>
     * 1. entity.remotePersisted == false
     * <p>
     * 2. entity.createdDate farthest one from current time
     * <p>
     * 3. entity.koalaPersistRetryCount field should be less than maxRetryCount
     *
     * @return
     */
    E select(Integer maxRetryCount);

}

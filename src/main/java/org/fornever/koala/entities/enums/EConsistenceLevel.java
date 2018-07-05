package org.fornever.koala.entities.enums;

public enum EConsistenceLevel {

    /**
     * WRITE/READ directly, read old data and write out-of-date data.
     * <p></p>
     * without any check will be decrease some read requests and increase system performance, and for low consistency requirement
     * <p></p>
     * remote data change callback will works but only for schedule data update, when save data to local, OUT_OF_DATE state entities will not throw exceptions.
     */
    WITHOUT_ANY_CHECK,

    /**
     * <p>without any data R/W check defaultly</p>
     * <p>
     * if you set remote data change callback, access changed data will invoke remote processors.
     * if entity state in OUT_OF_DATE, READ will invoke remote processor to refresh date immediately, WRITE will throw DataOutOfDateException
     * </p>
     * <P>sync data to remote will without check and just override data</p>
     */
    DEFAULT,

    /**
     * when sync data to remote, throw error if remote data changed before
     * <p></p>
     * remote data change callback will works, if entity state in OUT_OF_DATE, READ will invoke remote processor, WRITE will throw exception
     */
    CHECK_REMOTE_ON_SYNC,

    /**
     * when update/save data to local, throw error if remote data changed/existed before
     * <p></p>
     * in this level, when sync data to remote, also will have checks and throws
     * <p></p>
     * remote data change callback will works, if entity state in OUT_OF_DATE, READ will invoke remote processor, WRITE will throw exception
     */
    CHECK_REMOTE_ON_SAVE_AND_SYNC,

    /**
     * write api will directly invoke remote processor and save it to local & remote
     * <p></p>
     * but read api will use local cache directly.
     * <p></p>
     * remote data change callback will works, if entity state in OUT_OF_DATE, READ will invoke remote processor, WRITE will throw exception
     */
    ONLY_READ_CACHE,

    /**
     * only use remote processors, any Koala optimizes will off.
     */
    ONLY_PROXY,

}

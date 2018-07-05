package org.fornever.koala.entities;

import org.fornever.koala.entities.enums.EConsistenceLevel;

public class KoalaConfig {

    /**
     * Transaction (basic write records) per second of remote system
     * <p>
     * this number will be used to control write requests rate
     */
    private Integer remoteTPS = 5;

    /**
     * Query (basic query records) per second of remote system
     * <p>
     * this numebr will be used to control read requests rate
     */
    private Integer remoteQPS = 30;

    /**
     * When sync data to remote, data has changed, still write
     * <p>
     * if false, will throw sync error
     */
    private Boolean syncEvenDataChanged = true;

    /**
     * Even sync failed, internal server will retry later
     * <p>
     * if data equal zero, failed data will throw sync error direct
     */
    private Integer maxRetry = 0;

    private EConsistenceLevel consistenceLevel = EConsistenceLevel.DEFAULT;

    public EConsistenceLevel getConsistenceLevel() {
        return consistenceLevel;
    }

    public KoalaConfig setConsistenceLevel(EConsistenceLevel consistenceLevel) {
        this.consistenceLevel = consistenceLevel;
        return this;
    }

    public Integer getRemoteTPS() {
        return remoteTPS;
    }

    public KoalaConfig setRemoteTPS(Integer remoteTPS) {
        this.remoteTPS = remoteTPS;
        return this;
    }

    public Integer getRemoteQPS() {
        return remoteQPS;
    }

    public KoalaConfig setRemoteQPS(Integer remoteQPS) {
        this.remoteQPS = remoteQPS;
        return this;
    }

    public Boolean getSyncEvenDataChanged() {
        return syncEvenDataChanged;
    }

    public KoalaConfig setSyncEvenDataChanged(Boolean syncEvenDataChanged) {
        this.syncEvenDataChanged = syncEvenDataChanged;
        return this;
    }

    public Integer getMaxRetry() {
        return maxRetry;
    }

    public KoalaConfig setMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
        return this;
    }
}

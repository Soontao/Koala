package org.fornever.java.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class KoalaEntity {

    /**
     * The primary key
     */
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long KoalaID;

    /**
     * instance created date
     * <p>
     * 创建时间
     */
    @Column
    private Date koalaCreateDate;
    /**
     * instance updated date
     * <p>
     * 更新时间
     */
    @Column
    private Date koalaUpdateDate;
    /**
     * <p>
     * 重试次数
     */
    @Column
    private Integer koalaPersistRetryCount;

    /**
     * wether this entities persisted to remote system
     * <p>
     * <p>
     * when update, check this flag firstly
     */
    @Column
    private Boolean remotePersisted = false;

    public Long getKoalaID() {
        return KoalaID;
    }

    public KoalaEntity setKoalaID(Long koalaID) {
        KoalaID = koalaID;
        return this;
    }

    public Integer getKoalaPersistRetryCount() {
        return koalaPersistRetryCount;
    }

    public KoalaEntity setKoalaPersistRetryCount(Integer koalaPersistRetryCount) {
        this.koalaPersistRetryCount = koalaPersistRetryCount;
        return this;
    }

    public Boolean getRemotePersisted() {
        return remotePersisted;
    }

    public KoalaEntity setRemotePersisted(Boolean remotePersisted) {
        this.remotePersisted = remotePersisted;
        return this;
    }

    /**
     * @return the koalaCreateDate
     */
    public Date getKoalaCreateDate() {
        return koalaCreateDate;
    }

    /**
     * @param koalaCreateDate the koalaCreateDate to set
     */
    public void setKoalaCreateDate(Date koalaCreateDate) {
        this.koalaCreateDate = koalaCreateDate;
    }

    /**
     * @return the koalaUpdateDate
     */
    public Date getKoalaUpdateDate() {
        return koalaUpdateDate;
    }

    /**
     * @param koalaUpdateDate the koalaUpdateDate to set
     */
    public void setKoalaUpdateDate(Date koalaUpdateDate) {
        this.koalaUpdateDate = koalaUpdateDate;
    }

    /**
     * @return the koalaRetryCount
     */
    public Integer getKoalaRetryCount() {
        return koalaPersistRetryCount;
    }

    /**
     * @param koalaRetryCount the koalaRetryCount to set
     */
    public void setKoalaRetryCount(Integer koalaRetryCount) {
        this.koalaPersistRetryCount = koalaRetryCount;
    }

    @PrePersist
    protected void onCreate() {
        this.koalaCreateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.koalaUpdateDate = new Date();
    }

}

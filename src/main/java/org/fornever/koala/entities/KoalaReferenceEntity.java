package org.fornever.koala.entities;

import org.fornever.koala.entities.enums.EKoalaInstanceState;

import javax.persistence.*;
import java.util.Date;


@Entity
public class KoalaReferenceEntity {

    @Id
    private String refID;

    private String refEntityName;

    private EKoalaInstanceState state;

    private Date createAt;

    private String createBy;

    private Date updateAt;

    private String updateBy;

    public String getRefID() {
        return refID;
    }

    public KoalaReferenceEntity setRefID(String refID) {
        this.refID = refID;
        return this;
    }

    public String getRefEntityName() {
        return refEntityName;
    }

    public KoalaReferenceEntity setRefEntityName(String refEntityName) {
        this.refEntityName = refEntityName;
        return this;
    }

    public EKoalaInstanceState getState() {
        return state;
    }

    public KoalaReferenceEntity setState(EKoalaInstanceState state) {
        this.state = state;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public KoalaReferenceEntity setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

    public String getCreateBy() {
        return createBy;
    }

    public KoalaReferenceEntity setCreateBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public KoalaReferenceEntity setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
        return this;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public KoalaReferenceEntity setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
        return this;
    }

}

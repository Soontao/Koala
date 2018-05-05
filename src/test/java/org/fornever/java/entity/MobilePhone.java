package org.fornever.java.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MobilePhone extends KoalaBaseEntity {


    @Column
    private String phoneNumber;

    @Column
    private String phoneOwnerName;


}

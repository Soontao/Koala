package org.fornever.java.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class MobilePhone extends KoalaEntity {


    @Column
    private String phoneNumber;

    @Column
    private String phoneOwnerName;


}

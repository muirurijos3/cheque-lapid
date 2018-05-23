package com.ke.chequelapid.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company extends AbstractAuditableEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "phone_number", column = @Column(name = "phone_number")))
    private PhoneNumber phoneNumber;

    protected Company() {
    }

    public Company(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package com.ke.chequelapid.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="bank")
public class Bank extends AbstractAuditableEntity implements Serializable {
    @Column(name = "name")
    private String name;

    @Column(name = "bank_code")
    private String bankCode;

    protected Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
}

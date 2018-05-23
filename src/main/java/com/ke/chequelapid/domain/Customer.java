package com.ke.chequelapid.domain;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractAuditableEntity implements Serializable {
    @Column(name= "string")
    private Company company;

    @Embedded
    @AttributeOverrides(@AttributeOverride(name = "phone_number", column = @Column(name = "phone_number")))
    private PhoneNumber phoneNumber;

//    @OneToMany(mappedBy = "customer", orphanRemoval = true)
//    private List<User> user = new ArrayList<>();

    protected Customer() {
    }

    public Customer(Company company, PhoneNumber phoneNumber/*, List<User> user*/) {
        this.company = company;
        this.phoneNumber = phoneNumber;
//        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
/*
    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }*/

  /*  public void merge(Customer updatedCustomer) {
        company = updatedCustomer.company;
        phoneNumber = updatedCustomer.phoneNumber;
    }*/
}

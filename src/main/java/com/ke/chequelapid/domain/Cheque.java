package com.ke.chequelapid.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cheque")
public class Cheque extends AbstractAuditableEntity implements Serializable {
    @Column(name = "cheque_no")
    private String chequeNo;

    @Column(name = "drawee")
    private String drawee;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "amount")
    private BigInteger amount;

    @Column(name = "date_of_deposit")
    private LocalDateTime dateOfDeposit;

    @Column(name = "status")
    private ChequeStatus status;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    protected Cheque() {
    }

    public Cheque(String chequeNo, String drawee, BigInteger amount, LocalDateTime dateOfDeposit) {
        this.chequeNo = chequeNo;
        this.drawee = drawee;
        this.amount = amount;
        this.dateOfDeposit = dateOfDeposit;
        this.status =  ChequeStatus.OPEN;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getDrawee() {
        return drawee;
    }

    public void setDrawee(String drawee) {
        this.drawee = drawee;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateOfDeposit() {
        return dateOfDeposit;
    }

    public void setDateOfDeposit(LocalDateTime dateOfDeposit) {
        this.dateOfDeposit = dateOfDeposit;
    }

    public ChequeStatus getStatus() {
        return status;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void banked(){
        if(getStatus() != ChequeStatus.OPEN){
            throw new IllegalStateException("Sorry, this is not allowed");
        }
        this.status = ChequeStatus.BANKED;
    }

    public void overDue(){
        if(getStatus() != ChequeStatus.OPEN){
            throw new IllegalStateException("Sorry, this is not allowed");
        }
        this.status = ChequeStatus.OVERDUE;
    }
}

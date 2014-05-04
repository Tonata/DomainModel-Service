/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Tonata
 */
@Entity
public class Invoice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int invoiceNum;
    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Cashier cashier;
    
    private Invoice(Builder b){
        invoiceNum = b.invoiceNum;
        cashier = b.cashier;
        id = b.id;
    }
    
    
    public static class Builder{
       private int invoiceNum;
       private Cashier cashier;
       private Long id;

        public Builder(int invoiceNum) {
            this.invoiceNum = invoiceNum;
        }
        public Builder(){
            
        }
       
        public Builder cashier(Cashier c){
           cashier = c;
           return this;
        }
        public Builder invoiceNum(int i){
            invoiceNum = i;
            return this;
        }
        public Builder invoice(Invoice in){
            cashier = in.getCashier();
            invoiceNum = in.getInvoiceNum();
            id = in.getId();
            return this;
        }
        public Invoice build(){
            return new Invoice(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public Cashier getCashier() {
        return cashier;
    }

    public void setCashier(Cashier cashier) {
        this.cashier = cashier;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invoice)) {
            return false;
        }
        Invoice other = (Invoice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.Invoice[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Tonata
 */
@Entity
public class Cash implements Serializable, Payment{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    
    private Cash(Builder b){
        id = b.id;
        amount = b.amount;
    }
    
    public static class Builder{
        private Long id;
        private double amount;
        
        public Builder(){
            
        }
        
        public Builder amount(double amt){
            amount =  amt;
            return this;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        
        public Builder cash(Cash c){
            amount = c.getAmount();
            id = c.getId();
            return this;
        }
        public Cash build(){
            return new Cash(this);
        }
    }
           
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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
        if (!(object instanceof Cash)) {
            return false;
        }
        Cash other = (Cash) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.paymentPackage.Cash[ id=" + id + " ]";
    }
    
     @Override
    public String paymentType() {
        return "Cash";
    }

    @Override
    public double costAccumulated() {
       return amount;
    }
    
}

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
public class Laybye implements Serializable, Payment {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amount;
    private String name;
    
    private Laybye(Builder b){
       id = b.id;
       name = b.name;
       amount = b.amount;
    }
    
    public static class Builder{
         private Long id;
         private double amount;
         private String name;
         
        public Builder(String name) {
            this.name = name;
        }
        
        public Builder amount(double a){
            amount = a;
            return this;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
            
        }
        public Builder laybye(Laybye lay){
            amount = lay.getAmount();
            name = lay.getName();
            id = lay.getId();
            return this;
        }
        public Laybye build(){
            return new Laybye(this);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Laybye)) {
            return false;
        }
        Laybye other = (Laybye) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.paymentPackage.Laybye[ id=" + id + " ]";
    }

    @Override
    public String paymentType() {
        return "Lay-Bye";
    }

    @Override
    public double costAccumulated() {
        return amount;
    }
    
}

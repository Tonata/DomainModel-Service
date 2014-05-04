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
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String idNum;
    
    private Customer(Builder b){
        id = b.id;
        firstName = b.firstName;
        lastName = b.lastName;
        idNum = b.idNum; 
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String idNum;
        
        public Builder(String idNum) {
            this.idNum = idNum;
        }
        
        public Builder firstName(String name){
            firstName = name;
            return this;
        }
        
        public Builder lastName(String surname){
            lastName = surname;
            return this;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        public Builder customer(Customer cust){
            firstName = cust.getFirstName();
            lastName = cust.getLastName();
            id = cust.getId();
            idNum = cust.getIdNum();
            return this;
        }
        public Customer build(){
            return new Customer(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
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
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.usersPackage.Customer[ id=" + id + " ]";
    }
    
   
    
}

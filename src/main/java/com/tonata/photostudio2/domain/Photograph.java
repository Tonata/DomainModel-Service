/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author 211145904
 */
@Embeddable
public class Photograph implements Serializable, Work{
    private Photographer photographer;
    private String description;
   // @OneToMany
   // @JoinColumn(name = "photograph_workID")
    private Customer customer;
    private Long workID;
    private double cost;
    
    public Photograph() {
    }
    
    private Photograph(Builder b){
        photographer = b.photographer;
        description = b.description;
        workID = b.workID;
        customer = b.customer;
        cost = b.cost;
    }
    
    public static class Builder{
        private Photographer photographer;
        private String description;
        private Long workID;
        private Customer customer;
        private double cost;
        
        public Builder() {
           
        }
        public Builder photographer(Photographer p){
            photographer = p;
            return this;
        }
        public Builder description(String d){
            description = d;
            return this;
        }
        public Builder workID (Long id){
            workID = id;
            return this;
        }
        public Builder customer(Customer cust){
            customer = cust;
            return this;
        }
        public Builder cost(double c){
            cost = c;
            return this;
        }
        public Builder photograph(Photograph photo){
            photographer = photo.getPhotographer();
            description = photo.getDescription();
            workID = photo.getWorkID();
            customer = photo.getCustomer();
            cost = photo.getCost();
            return this;
        }
        public Photograph build(){
            return new Photograph(this);
        }
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWorkID() {
        return workID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    

    public void setWorkID(Long workID) {
        this.workID = workID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Photograph other = (Photograph) obj;
        if ((this.description == null) ? (other.description != null) : !this.description.equals(other.description)) {
            return false;
        }
        return true;
    }
    
    @Override
    public double cost(int unitPrice, double labour) {
        return unitPrice * labour;
    }
    
    public String customerIdentity(Customer c) {
       return c.getFirstName() + " " + c.getLastName();
    }
    
}

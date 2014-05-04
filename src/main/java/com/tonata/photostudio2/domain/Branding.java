/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;
import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.domain.Editor;
import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author 211145904
 */
@Embeddable
public class Branding implements Serializable, Work{
    private Editor editor;
    private String description;
    private Long workID;
    /// @OneToMany
    //@JoinColumn(name = "branding_workID")
    private Customer customer; 
    
     @JoinColumn( name="branding_id" ,insertable=false, updatable=false)
     private double cost;
    
    private Branding(Builder b){
        editor = b.editor;
        description = b.description;
        workID = b.workID;
        customer = b.customer;
        cost = b.cost;
    }

    public static class Builder{
        private Editor editor;
        private String description;
        private Long workID;
        private Customer customer;
        private double cost;
        public Builder() {
            
        }
       
        public Builder editor(Editor e){
            editor = e;
            return this;
        }
        public Builder description(String d){
            description = d;
            return this;
        }
        public Builder workID(Long id){
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
        public Builder branding(Branding brand){
            editor = brand.getEditor();
            description = brand.getDescription();
            workID = brand.getWorkID();
            customer = brand.getCustomer();
            cost  = brand.getCost();
            return this;
        }
        public Branding build(){
            return new Branding(this);
        }
        
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
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
        hash = 71 * hash + (this.description != null ? this.description.hashCode() : 0);
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
        final Branding other = (Branding) obj;
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

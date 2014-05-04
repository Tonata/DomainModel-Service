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
 * @author 211145904
 */
@Entity
public class DesktopPC implements Serializable, Equipment {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private double costPrice;
    
    private DesktopPC(Builder b){
        id = b.id;
        code = b.code;
        name = b.name;
        costPrice = b.costPrice;
    }

    @Override
    public double cost() {
        return costPrice;
    }
    
    public static class Builder{
        private Long id;
        private String name;
        private String code;
        private double costPrice;
        
        public Builder(){
            
        }
        
        public Builder code(String c){
            code = c;
            return this;
        }
        
        public Builder name(String n){
            name = n;
            return this;
        }
        
        public Builder id(Long i){
            id = i;
            return this;
        }
        public Builder costPrice(double cost){
            costPrice  = cost;
            return this;
        }
        public Builder desktopPC(DesktopPC ds){
            id = ds.getId();
            name = ds.getName();
            code = ds.getCode();
            costPrice = ds.getCostPrice();
            return this;
        }
        
        public DesktopPC build(){
            return new DesktopPC(this);
        }
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
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
        if (!(object instanceof DesktopPC)) {
            return false;
        }
        DesktopPC other = (DesktopPC) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DesktopPC{" + "id=" + id + ", name=" + name + ", code=" + code + '}';
    }
    
    
    
}

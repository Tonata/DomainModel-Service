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
public class Smartboard implements Serializable, Equipment  {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    private double costPrice;
    
    private Smartboard(Builder b){
        id = b.id;
        name = b.name;
        code = b.code;
        costPrice = b.costPrice;
    }

    @Override
    public double cost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            costPrice = cost;
            return this;
        }
        public Builder smartboard(Smartboard sb){
            id = sb.getId();
            name = sb.getName();
            code = sb.getCode();
            costPrice = sb.getCostPrice();
            return this;
        }
        public Smartboard build(){
            return new Smartboard(this);
        }
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
   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Smartboard)) {
            return false;
        }
        Smartboard other = (Smartboard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Smartboard{" + "id=" + id + ", name=" + name + ", code=" + code + '}';
    }

    
    
}

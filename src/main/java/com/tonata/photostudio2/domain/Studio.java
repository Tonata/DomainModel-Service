/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Tonata
 */
@Entity
public class Studio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double squareMeters;
    private String address;
   /* @OneToMany
    @JoinColumn(name = "studio_id")  */    
    List<Equipment> equipment;
    
    private Studio(Builder b){
        squareMeters = b.squareMeters;
        address = b.address;
        equipment = b.equipment;
        id = b.id;
    }
    public static class Builder{
        private double squareMeters;
        private String address;
        private List<Equipment> equipment;
        private Long id;
                
        public Builder(String add) {
            this.address = add;
        }
        
        public Builder squareMeters(double sq){
            squareMeters = sq;
            return this;
        }
        public Builder equipment(List<Equipment> e){
            equipment = e;
            return this;
        }
        public Builder id(Long i){
            id = i;
            return this;
        }
        public Builder studio(Studio studio){
            id = studio.getId();
            address = studio.getAddress();
            squareMeters = studio.getSquareMeters();
            equipment = studio.getEquipment();
            return this;
        }
        public Studio build(){
            return new Studio(this);
        }
        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(double squareMeters) {
        this.squareMeters = squareMeters;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
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
        if (!(object instanceof Studio)) {
            return false;
        }
        Studio other = (Studio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.Studio[ id=" + id + " ]";
    }
    
}

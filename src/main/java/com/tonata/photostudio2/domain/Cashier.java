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

/**
 *
 * @author Tonata
 */
@Entity
public class Cashier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String workerID;
    private DesktopPC pc;
    
    private Cashier(Builder b){
        firstName = b.firstName;
        lastName = b.lastName;
        workerID = b.workerID;
        id = b.id;
        pc = b.pc;
     }
    public static class Builder{
        private String firstName;
        private String lastName;
        private String workerID;
        private Long id;
        private DesktopPC pc;

        public Builder(String ID) {
            workerID = ID;
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
        public Builder desktopPc(DesktopPC p){
            pc = p;
            return this;
        }
        public Builder cashier(Cashier cashier){
            firstName = cashier.getFirstName();
            lastName = cashier.getLastName();
            workerID = cashier.getWorkerID();
            id = cashier.getId();
            pc = cashier.getPc();
            return this;
        }
        public Cashier build(){
            return new Cashier(this);
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

    public DesktopPC getPc() {
        return pc;
    }

    public void setPc(DesktopPC pc) {
        this.pc = pc;
    }
    

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
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
        if (!(object instanceof Cashier)) {
            return false;
        }
        Cashier other = (Cashier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.Cashier[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;

import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author 211145904
 */
@Entity
public class Editor implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String workerID;
    
    @Embedded
    private Flyer flyer;
    @Embedded
    private Branding branding;
    
    @OneToOne
    @JoinColumn(name= "editor_id")
    private Tablet tablet;
    
    @OneToOne
    @JoinColumn(name= "editor_id")
    private DesktopPC pc;
    
    private Editor(Builder b){
        firstName = b.firstName;
        lastName = b.lastName;
        workerID = b.workerID;
        id = b.id;
        flyer = b.flyer;
        branding = b.branding;
        tablet = b.tablet;
        pc = b.pc;
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String workerID;
        private Flyer flyer;
        private Branding branding;
        private Tablet tablet;
        private DesktopPC pc;
        
         public Builder(String workerID) {
            this.workerID = workerID;
        }
        public Builder firstName(String name){
            this.firstName = name;
            return this;
        }
        
         public Builder id(Long i){
            this.id = i;
            return this;
        }
        public Builder lastName(String surname){
            this.lastName = surname;
            return this;
        } 
        public Builder tablet(Tablet t){
            tablet = t;
            return this;
        }
        public Builder desktopPc(DesktopPC d){
            pc = d;
            return this;
        }
        public Builder branding(Branding brand){
            branding = brand;
            return this;
        }
        public Builder flyer(Flyer f){
            flyer = f;
            return this;
        }
        
        public Builder editor(Editor editor){
            id = editor.getId();
            firstName = editor.getFirstName();
            lastName = editor.getLastName();
            workerID = editor.getWorkerID();
            flyer = editor.getFlyer();
            branding = editor.getBranding();
            pc = editor.getPc();
            tablet = editor.getTablet();
            return this;
        }
        public Editor build(){
            return new Editor(this);
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

    public String getWorkerID() {
        return workerID;
    }

    public void setWorkerID(String workerID) {
        this.workerID = workerID;
    }

    public Flyer getFlyer() {
        return flyer;
    }

    public void setFlyer(Flyer flyer) {
        this.flyer = flyer;
    }

    public Branding getBranding() {
        return branding;
    }

    public void setBranding(Branding branding) {
        this.branding = branding;
    }

    public Tablet getTablet() {
        return tablet;
    }

    public void setTablet(Tablet tablet) {
        this.tablet = tablet;
    }

    public DesktopPC getPc() {
        return pc;
    }

    public void setPc(DesktopPC pc) {
        this.pc = pc;
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
        if (!(object instanceof Editor)) {
            return false;
        }
        Editor other = (Editor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Editor{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", workerID=" + workerID + '}';
    }

    
    
}

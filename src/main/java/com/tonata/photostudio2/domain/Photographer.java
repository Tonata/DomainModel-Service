/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author 211145904
 */
@Entity
public class Photographer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String workerID;
   
    @Embedded
    private Photograph photo;
    
   // @OneToMany
   // @JoinColumn(name= "photographer_id")
    private Tablet tablet;
    
   // @OneToMany
  //  @JoinColumn(name= "photographer_id")
    private DesktopPC pc;
    
    @OneToMany
    @JoinColumn(name="photographer_id")
    List <Camera> cameras;
    
    private Photographer(Builder b){
        id = b.id;
        firstName = b.firstName;
        lastName = b.lastName;
        workerID = b.workerID;
        photo = b.photo;
        tablet = b.tablet;
        pc = b.pc;
        cameras = b.cameras;
    }
    
    private Photographer(){
        
    }
    
    public static class Builder{
        private Long id;
        private String firstName;
        private String lastName;
        private String workerID;
        private Photograph photo;
        private Tablet tablet;
        private DesktopPC pc;
        List <Camera> cameras;
        
        public Builder(String workerID) {
            this.workerID = workerID;
        }
        public Builder(){
            
        }

        public Builder firstName(String name){
            firstName = name;
            return this;
        }
        public Builder lastName(String surname){
            lastName = surname;
            return this;
        }
        public Builder photo(Photograph p){
            photo = p;
            return this;
        }
        public Builder tablet(Tablet t){
            tablet = t;
            return this;
        }
        public Builder desktopPc(DesktopPC dp){
            pc = dp;
            return this;
        }
        public Builder cameras(List<Camera> value){
            cameras = value;
            return this;
        }
        public Builder photographer(Photographer ph){
            id = ph.getId();
            firstName = ph.getFirstName();
            lastName = ph.getLastName();
            workerID = ph.getWorkerID();
            photo = ph.getPhoto();
            tablet = ph.getTablet();
            pc = ph.getPc();
            cameras = ph.getCameras();
            return this;
        }
        public Photographer build(){
            return new Photographer(this);
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

    public Photograph getPhoto() {
        return photo;
    }

    public void setPhoto(Photograph photo) {
        this.photo = photo;
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

    public List<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(List<Camera> cameras) {
        this.cameras = cameras;
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
        if (!(object instanceof Photographer)) {
            return false;
        }
        Photographer other = (Photographer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Photographer{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", workerID=" + workerID + '}';
    }

   
    
}

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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Tonata
 */
@Entity
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String workerID;
   // @OneToMany
    //@JoinColumn(name = "manager_id")
    private Work validWork;
    //@OneToOne
    //@JoinColumn(name = "manager_id")
    private Smartboard board;
    private DesktopPC pc;
     
    private Manager(Builder b){
        firstName = b.firstName;
        lastName = b.lastName;
        workerID  = b.workerID;
        validWork = b.validWork;
        id = b.id;
        board = b.board;
        pc = b.pc;
    }

   
    public static class Builder{
        private String firstName;
        private String lastName;
        private String workerID;
        private Work validWork;
        private Long id;
        private Smartboard board;
        private DesktopPC pc;
        
        public Builder(String workerID) {
            this.workerID = workerID;
        }
        
        public Builder firstName(String name){
            firstName = name;
            return this;
        }
        public Builder lastName(String surname){
            lastName = surname;
            return this;
        }
        
        public Builder validWork(Work valid){
            validWork = valid;
            return this;
        }
        public Builder id(Long i){
            id = i;
            return this;
        }
        public Builder board(Smartboard s){
            board = s;
            return this;
        }
        public Builder desktopPc(DesktopPC p){
            pc = p;
            return this;
        }
        public Builder manager(Manager m){
            id = m.getId();
            board = m.getBoard();
            firstName = m.getFirstName();
            lastName = m.getLastName();
            workerID = m.getWorkerID();
            validWork = m.getValidWork();
            pc = m.getPc();
            return this;
        }
        public Manager build(){
            return new Manager(this);
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

    public DesktopPC getPc() {
        return pc;
    }

    public void setPc(DesktopPC pc) {
        this.pc = pc;
    }
    
    public Work getValidWork() {
        return validWork;
    }

    public void setValidWork(Work validWork) {
        this.validWork = validWork;
    }

    public Smartboard getBoard() {
        return board;
    }

    public void setBoard(Smartboard board) {
        this.board = board;
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
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tonata.photostudio2.domain.Manager[ id=" + id + " ]";
    }
    
}

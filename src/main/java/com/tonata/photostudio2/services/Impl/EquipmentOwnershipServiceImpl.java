/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.EditorRepository;
import com.tonata.photostudio2.repository.PhotographerRepository;
import com.tonata.photostudio2.services.EquipmentOwnershipService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class EquipmentOwnershipServiceImpl implements EquipmentOwnershipService {
    public String ownerName = "";
    
    @Autowired
    public PhotographerRepository photographerRepo;
    
    @Override
    public String getOwner(DesktopPC pc) {
        List<Photographer> p = photographerRepo.findAll();
        
        for(int x=0 ; x<p.size(); x++){
            if( pc.getCode().equals(p.get(x).getPc().getCode())){
               ownerName =  p.get(x).getFirstName() + " " +  p.get(x).getLastName();
               
            }
           
        }
        return ownerName;
       
    }
    
}

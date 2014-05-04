/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Photograph;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.PhotographRepository;
import com.tonata.photostudio2.repository.PhotographerRepository;
import com.tonata.photostudio2.services.PhotographsByPhotographer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class PhotographsByPhotographerImpl implements PhotographsByPhotographer {
    public int count = 0;
    @Autowired
    public PhotographRepository photographRepo;
    
    @Override
    public int getPhotos(Photographer p) {
        List<Photograph> photos = photographRepo.findAll();
        
        for(Photograph ph: photos){
            if(ph.getPhotographer()== p)
            {
                count++;
            }
        }
        
        return count;
    }
    
}

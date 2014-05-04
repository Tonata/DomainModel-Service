/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.repository.FlyerRepository;
import com.tonata.photostudio2.services.TotalFlyersByEditor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class TotalFlyersByEditorImpl implements TotalFlyersByEditor{
    public int count = 0;
    
    @Autowired
    public FlyerRepository flyerRepo;
    
    @Override
    public int getFlyers(Editor editor) {
        List<Flyer> flyers = flyerRepo.findAll();
        
        for(Flyer f: flyers){
            if(f.getEditor() == editor){
                count++;
            }
        }
        return count;
    }
    
    
}

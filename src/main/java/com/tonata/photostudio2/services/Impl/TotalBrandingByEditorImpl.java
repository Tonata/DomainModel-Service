/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.repository.BrandingRepository;
import com.tonata.photostudio2.services.TotalBrandingByEditor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class TotalBrandingByEditorImpl implements TotalBrandingByEditor{
    public int count = 0;
    
    @Autowired
    public BrandingRepository brandingRepo;
    
    @Override
    public int getBranding(Editor editor) {
       List<Branding> brand = brandingRepo.findAll();
        
        for(Branding b: brand){
            if(b.getEditor() == editor){
                count++;
            }
        }
        return count;
    }
    
}

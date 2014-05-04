/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.repository.EditorRepository;
import com.tonata.photostudio2.services.TotalEditorGadgetsService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class TotalEditorGadgetsServiceImpl implements  TotalEditorGadgetsService{
    
    @Autowired
    public EditorRepository editorRepo;
    
    @Override
    public double totalCost(Editor editor) {
       return editor.getPc().getCostPrice() +  editor.getTablet().getCostPrice();
        
        
    }
    
}

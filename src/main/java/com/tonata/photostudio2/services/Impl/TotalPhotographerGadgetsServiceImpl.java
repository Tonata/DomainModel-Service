/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.services.TotalPhotographerGadgetsService;

/**
 *
 * @author Tonata
 */
public class TotalPhotographerGadgetsServiceImpl implements TotalPhotographerGadgetsService {

    @Override
    public double totalCost(Photographer photographer) {
        return photographer.getTablet().getCostPrice() + photographer.getCameras().get(0).getCostPrice();
    }
    
}

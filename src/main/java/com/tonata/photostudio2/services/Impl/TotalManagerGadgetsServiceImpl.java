/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Manager;
import com.tonata.photostudio2.services.TotalManagerGadgetsService;

/**
 *
 * @author Tonata
 */
public class TotalManagerGadgetsServiceImpl implements TotalManagerGadgetsService{

    @Override
    public double totalCost(Manager manager) {
        return manager.getBoard().getCostPrice() + manager.getPc().getCostPrice();
    }
    
}

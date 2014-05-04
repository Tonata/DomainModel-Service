/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Cashier;
import com.tonata.photostudio2.services.TotalCashierGadgetService;

/**
 *
 * @author Tonata
 */
public class TotalCashierGadgetServiceImpl implements TotalCashierGadgetService {

    @Override
    public double totalCost(Cashier cashier) {
        return cashier.getPc().getCostPrice();
    }
    
}

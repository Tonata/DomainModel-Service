/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Work;
import com.tonata.photostudio2.services.HighestBrandingCostService;
import java.util.List;

/**
 *
 * @author Tonata
 */
public class HighestBrandingCostServiceImpl implements HighestBrandingCostService  {

    public int count;
    @Override
    public Branding highestCost(List<Branding> b) {
        double highest = b.get(0).getCost();
        
        for(int x = 1; x < b.size(); x++){
             if(b.get(x).getCost() < highest){
                 highest = b.get(x).getCost();
                 count = x;
             }
        }
       return b.get(count);
    }
    
}

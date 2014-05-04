/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.services.HighestFlyerCostService;
import java.util.List;

/**
 *
 * @author Tonata
 */
public class HighestFlyerCostServiceImpl implements HighestFlyerCostService {
    public int count;
    
    @Override
    public Flyer highestCost(List<Flyer> works) {
        double highest = works.get(0).getCost();
        
        for(int x = 1; x < works.size(); x++){
             if(works.get(x).getCost() < highest){
                 highest = works.get(x).getCost();
                 count = x;
             }
        }
       return works.get(count);
    }
    
}

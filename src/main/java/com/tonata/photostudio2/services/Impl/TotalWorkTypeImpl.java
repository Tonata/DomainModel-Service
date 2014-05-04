/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Work;
import com.tonata.photostudio2.services.TotalWorkType;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tonata
 */
public class TotalWorkTypeImpl implements TotalWorkType{
    
    @Override
    public int getTotalWork(List<Work> w) {
       return  w.size();
    }
    
}

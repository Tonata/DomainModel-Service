/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services;

import com.tonata.photostudio2.domain.Work;
import java.util.List;

/**
 *
 * @author Tonata
 */
public interface TotalWorkType {
    public int getTotalWork(List<Work> workDone);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.repository;

import com.tonata.photostudio2.domain.Tablet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Tonata
 */
public interface TabletRepository extends JpaRepository<Tablet, Long>{
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.*;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author 211145904
 */
@Embeddable
public interface Payment extends Serializable {
    String paymentType();
    double costAccumulated();
}

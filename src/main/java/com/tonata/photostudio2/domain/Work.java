/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.domain;

import com.tonata.photostudio2.domain.Customer;
import java.io.Serializable;


/**
 *
 * @author 211145904
 */
public interface Work extends Serializable {
     double cost(int unitPrice , double labour);
     String customerIdentity(Customer c);
}

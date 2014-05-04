/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.repository.CustomerRepository;
import com.tonata.photostudio2.services.TotalCustomerCost;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class TotalCustomerCostImpl implements TotalCustomerCost {

    @Autowired
    public CustomerRepository customerRepo;
    
    @Override
    public double getTotalCost(Customer customer) {
        return 0.0;
    }
    
}

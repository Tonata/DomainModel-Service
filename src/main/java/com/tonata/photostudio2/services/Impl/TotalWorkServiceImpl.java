/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tonata.photostudio2.services.Impl;

import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.domain.Work;
import com.tonata.photostudio2.repository.CustomerRepository;
import com.tonata.photostudio2.services.TotalWorkService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Tonata
 */
public class TotalWorkServiceImpl implements TotalWorkService {

    @Autowired
    public CustomerRepository customerRepo;
    
    @Override
    public String findCustomerExistence(Customer customer) {
        String id = customer.getIdNum();
        String existence = "";
        List<Customer> allCust = customerRepo.findAll();
        
        for(int x = 0; x < allCust.size(); x++)
        {
           if(allCust.get(x).getIdNum().equals(id)){
               existence = "Does exist";
            } 
           else{
               existence = "Doesn't exist";
           }
        }
       
        return existence;
    }
    
}

    
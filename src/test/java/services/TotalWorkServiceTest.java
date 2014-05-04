/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.repository.CustomerRepository;
import com.tonata.photostudio2.services.TotalWorkService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Tonata
 */
public class TotalWorkServiceTest {
    private static ApplicationContext ctx;
    private TotalWorkService totalWorkService;
    private CustomerRepository customerRepo;
    
    public TotalWorkServiceTest() {
    }

    @Test
    public void TotalWorkServiceTest(){
        customerRepo = ctx.getBean(CustomerRepository.class);
        totalWorkService = ctx.getBean(TotalWorkService.class);
        
        Customer c1 = new Customer.Builder("89010934224").firstName("Mathew").build();
        Customer c2  = new Customer.Builder("93031094224").firstName("Max").build(); 
        
        customerRepo.save(c1);
        customerRepo.save(c2);
        
        String a = totalWorkService.findCustomerExistence(c2);
        
        Assert.assertEquals(a,"Does exist");
        
    }
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
    
}

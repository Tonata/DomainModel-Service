/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Cash;
import com.tonata.photostudio2.repository.CashRepository;
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
public class CashRepositoryTest {
    private static ApplicationContext ctx;
    private CashRepository repo;
    private Long id;
    
    public CashRepositoryTest() {
    }
    
    @Test 
    public void createCash(){
        repo = ctx.getBean(CashRepository.class);
        Cash cash = new Cash.Builder()
                .amount(3000.00)
                .build();
        
        repo.save(cash);
        id = cash.getId();
        Assert.assertNotNull(cash);
    }
    
    @Test (dependsOnMethods = "createCash")
    public void readCash(){
        repo = ctx.getBean(CashRepository.class);
        Cash cash = repo.findOne(id);
        Assert.assertEquals(cash.getAmount(), 300.00);
    }
    
    @Test (dependsOnMethods = "readCash")
    public void updateCash(){
       repo = ctx.getBean(CashRepository.class);
       Cash cash = repo.findOne(id);
       Cash updatedCash = new Cash.Builder()
               .cash(cash)
               .amount(694.00)
               .build();
       
       repo.save(updatedCash);
        Cash newCash = repo.findOne(id);
        Assert.assertEquals(newCash.getAmount() , 694.00);
        
    }
    
    @Test (dependsOnMethods = "updateCash")
    public void deleteCash(){
       repo = ctx.getBean(CashRepository.class); 
       Cash cash = repo.findOne(id);
        
       repo.delete(cash);
       Cash deletedCash = repo.findOne(id); 
       Assert.assertNull(deletedCash);
        
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

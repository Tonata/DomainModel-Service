/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Credit;
import com.tonata.photostudio2.repository.CreditRepository;
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
public class CreditRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private CreditRepository repo;
    
    public CreditRepositoryTest() {
    }

    @Test 
    public void createCredit(){
        repo = ctx.getBean(CreditRepository.class);
        Credit cr = new Credit.Builder("John- FNB")
                .amount(2000.00)
                .build();
        
        repo.save(cr);
        id = cr.getId();
        Assert.assertNotNull(cr);
    }
    
    @Test (dependsOnMethods = "createCredit")
    public void readCredit(){
        repo = ctx.getBean(CreditRepository.class);
        Credit cr = repo.findOne(id);
        Assert.assertEquals(cr.getAccName(), "John- FNB");
    }
    
    @Test (dependsOnMethods = "readCredit")
    public void updateCredit(){
        repo = ctx.getBean(CreditRepository.class);
        Credit cr = repo.findOne(id);
        Credit updatedCredit = new Credit.Builder( "John- FNB")
                .credit(cr)
                .amount(1000.00)
                .build();
        
        repo.save(updatedCredit);
        Credit newCredit = repo.findOne(id);
        Assert.assertEquals(newCredit.getAmount() , 1000.00);
    }
    
    @Test (dependsOnMethods = "updateCredit")
    public void deleteCredit(){
        repo = ctx.getBean(CreditRepository.class);
        Credit cr = repo.findOne(id);
        
        repo.delete(cr);
        Credit deletedCredit = repo.findOne(id);
        Assert.assertNull(deletedCredit);
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

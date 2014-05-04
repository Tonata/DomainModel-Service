/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Laybye;
import com.tonata.photostudio2.repository.LaybyeRepository;
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
public class LaybyeRepositoryTest {
    private static ApplicationContext ctx;
    private Long id;
    private LaybyeRepository repo;
    
    public LaybyeRepositoryTest() {
    }
    
    @Test
    public void createLaybye(){
        repo = ctx.getBean(LaybyeRepository.class);
        Laybye lb = new Laybye.Builder("Tonata")
                .amount(200.00)
                .build();
        
        repo.save(lb);
        id = lb.getId();
        Assert.assertNotNull(lb);
    }
    
    @Test (dependsOnMethods = "createLaybye")
    public void readLaybye(){
        repo = ctx.getBean(LaybyeRepository.class);
        Laybye lb = repo.findOne(id);
        Assert.assertEquals(lb.getAmount(), 200.00);
        
    }
    
    @Test (dependsOnMethods = "readLaybye")
    public void updateLaybye(){
        repo = ctx.getBean(LaybyeRepository.class);
        Laybye lb = repo.findOne(id);
        Laybye updatedLaybye = new Laybye.Builder("Tonata")
                .laybye(lb)
                .amount(250.00)
                .build();
        
        repo.save(updatedLaybye);
        Laybye newLaybye = repo.findOne(id);
        Assert.assertEquals(newLaybye.getAmount() , 250.00);
    }
    
    @Test (dependsOnMethods = "updateLaybye")
    public void deleteLaybye(){
        repo = ctx.getBean(LaybyeRepository.class);
        Laybye lb = repo.findOne(id);
        
        repo.delete(lb);
        Laybye deletedLaybye = repo.findOne(id);
        Assert.assertNull(deletedLaybye);
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

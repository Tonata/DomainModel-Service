/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.repository.BrandingRepository;
import com.tonata.photostudio2.repository.FlyerRepository;
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
public class FlyerRepositoryTest {
    private static ApplicationContext ctx;
    private FlyerRepository repo;
    private Long id;
    public FlyerRepositoryTest() {
    }

    @Test
    public void createFlyer(){
        repo = ctx.getBean(FlyerRepository.class);
        
        Editor editor = new Editor.Builder("120").firstName("Mike").lastName("Jones").build();
        Customer cust = new Customer.Builder("89122300201").firstName("Graham").build();
        
        Flyer f = new Flyer.Builder()
                .description("V-day event")
                .editor(editor)
                .customer(cust)
                .build();
        
        repo.save(f);
        id = f.getWorkID();
        Assert.assertNotNull(f);
    }
    
    @Test (dependsOnMethods = "createFlyer")
    public void readFlyer(){
        repo = ctx.getBean(FlyerRepository.class);
        Flyer f = repo.findOne(id);
        Assert.assertEquals(f.getDescription(),"V-day event");
    
    }
    
    @Test (dependsOnMethods = "readFlyer")
    private void updateFlyer(){
        repo = ctx.getBean(FlyerRepository.class);
        Editor editor = new Editor.Builder("121").firstName("Cale").lastName("Smith").build();
       
        Flyer f = repo.findOne(id);
        Flyer updatedF = new Flyer.Builder()
                .flyer(f)
                .editor(editor)
                .build();
        
        repo.save(updatedF);
        Flyer newF = repo.findOne(id);
        Assert.assertEquals(newF.getEditor(), editor);
    }
    
    @Test (dependsOnMethods = "updateFlyer")
    private void deleteFlyer(){
        repo = ctx.getBean(FlyerRepository.class);
        Flyer f= repo.findOne(id);
        
        repo.delete(f);
        Flyer deletedF= repo.findOne(id);
        Assert.assertNull(deletedF);
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

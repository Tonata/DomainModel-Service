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
import com.tonata.photostudio2.repository.BrandingRepository;
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
public class BrandingRepositoryTest {
    private static ApplicationContext ctx;
    private BrandingRepository repo;
    private Long id;
    public BrandingRepositoryTest() {
    }

     @Test
        public void createBranding(){
        repo = ctx.getBean(BrandingRepository.class);
        
        Editor editor = new Editor.Builder("120").firstName("Mike").lastName("Jones").build();
        Customer cust = new Customer.Builder("7809230020").firstName("John").build();
        
        Branding b = new Branding.Builder()
                .description("Gourmet Boerie Logo")
                .editor(editor)
                .customer(cust)
                .build();
        
        repo.save(b);
        id = b.getWorkID();
        Assert.assertNotNull(b);
    }
    
    @Test (dependsOnMethods = "createBranding")
    public void readBranding(){
        repo = ctx.getBean(BrandingRepository.class);
        Branding b = repo.findOne(id);
        Assert.assertEquals(b.getDescription(),"Gourmet Boerie Logo");
    
    }
    
    @Test (dependsOnMethods = "readBranding")
    private void updateBranding(){
        repo = ctx.getBean(BrandingRepository.class);
        Editor editor = new Editor.Builder("121").firstName("Cale").lastName("Smith").build();
       
        Branding b= repo.findOne(id);
        Branding updatedB = new Branding.Builder()
                .branding(b)
                .editor(editor)
                .build();
        
        repo.save(updatedB);
        Branding newB = repo.findOne(id);
        Assert.assertEquals(newB.getEditor(), editor);
    }
    
    @Test (dependsOnMethods = "updateBranding")
    private void deleteBranding(){
        repo = ctx.getBean(BrandingRepository.class);
        Branding b = repo.findOne(id);
        
        repo.delete(b);
        Branding deletedB= repo.findOne(id);
        Assert.assertNull(deletedB);
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

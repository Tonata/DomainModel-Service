/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Customer;
import com.tonata.photostudio2.domain.Photograph;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.PhotographRepository;
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
public class PhotographRepositoryTest {
    private static ApplicationContext ctx;
    private PhotographRepository repo;
    private Long id;
    
    public PhotographRepositoryTest() {
    }
    
    @Test 
    public void createPhotograph(){
        repo = ctx.getBean(PhotographRepository.class);
        
        Photographer photographer = new Photographer.Builder().firstName("Mike").lastName("Jones").build();
        Customer cust = new Customer.Builder("8803160020").firstName("Mary-ann").build();
        
        Photograph photo = new Photograph.Builder()
                .description("Sunset seas")
                .photographer(photographer)
                .customer(cust)
                .build();
        
        repo.save(photo);
        id = photo.getWorkID();
        Assert.assertNotNull(photo);
    }
    
    @Test (dependsOnMethods = "createPhotograph")
    public void readPhotograph(){
        repo = ctx.getBean(PhotographRepository.class);
        Photograph photo = repo.findOne(id);
        Assert.assertEquals(photo.getDescription(),"Sunset seas");
    
    }
    
    @Test (dependsOnMethods = "readPhotograph")
    private void updatePhotograph(){
        repo = ctx.getBean(PhotographRepository.class);
        Photograph photo = repo.findOne(id);
        Photograph updatedPhoto = new Photograph.Builder()
                .photograph(photo)
                .description("Wedding Portait")
                .build();
        
        repo.save(updatedPhoto);
        Photograph newPhoto = repo.findOne(id);
        Assert.assertEquals(newPhoto.getDescription(), "Wedding Portait");
    }
    
    @Test (dependsOnMethods = "updatePhotograph")
    private void deletePhotograph(){
        repo = ctx.getBean(PhotographRepository.class);
        Photograph photo = repo.findOne(id);
        
        repo.delete(photo);
        Photograph deletedPhoto = repo.findOne(id);
        Assert.assertNull(deletedPhoto);
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

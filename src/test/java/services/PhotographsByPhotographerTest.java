/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Photograph;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.PhotographRepository;
import com.tonata.photostudio2.services.PhotographsByPhotographer;
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
public class PhotographsByPhotographerTest {
    public static ApplicationContext ctx;
    public PhotographRepository photoRepo;
    public PhotographsByPhotographer p;
    public static Photographer photographer1;
     public static Photographer photographer2;
    public PhotographsByPhotographerTest() {
    }
    
    @Test
    public void testPhotographer(){
        photoRepo = ctx.getBean(PhotographRepository.class);
        p = ctx.getBean(PhotographsByPhotographer.class);
        
        
        Photograph p1 = new Photograph.Builder().description("club launch").photographer(photographer1).build();
        Photograph p2= new Photograph.Builder().description("dj vigi- album launch").photographer(photographer1).build();
        Photograph p3 = new Photograph.Builder().description("mark & liz wedding").photographer(photographer2).build();
        Photograph p4 = new Photograph.Builder().description("magazine shoot").photographer(photographer1).build();
        
        photoRepo.save(p1);
        photoRepo.save(p2);
        photoRepo.save(p3);
        photoRepo.save(p4);
        
        Assert.assertEquals(p.getPhotos(photographer1), 3);
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx= new AnnotationConfigApplicationContext(ConnectionConfig.class);
        photographer1 = new Photographer.Builder().firstName("Max").lastName("Smith").build();
        photographer2= new Photographer.Builder().firstName("Jon").lastName("Cane").build();
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

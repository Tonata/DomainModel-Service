/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Speaker;
import com.tonata.photostudio2.repository.SpeakerRepository;
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
public class SpeakerRepositoryTest {
    private static ApplicationContext ctx;
    private SpeakerRepository repo;
    private Long id;
    
    public SpeakerRepositoryTest() {
    }
    
    @Test
    public void createSpeaker(){
        repo = ctx.getBean(SpeakerRepository.class);
        Speaker speaker = new Speaker.Builder()
                .code("23424")
                .name("Compact 100")
                .costPrice(700.00)
                .build();
        
        repo.save(speaker);
        id = speaker.getId();
        Assert.assertNotNull(speaker);
    }
    
    @Test (dependsOnMethods = "createSpeaker")
    public void readSpeaker(){
        repo = ctx.getBean(SpeakerRepository.class);
        Speaker speaker = repo.findOne(id);
        Assert.assertEquals(speaker.getName() , "Compact 100");
    }
    
    @Test (dependsOnMethods = "readSpeaker")
    private void updateSpeaker(){
        repo = ctx.getBean(SpeakerRepository.class);
        Speaker s = repo.findOne(id);
        Speaker updatedS = new Speaker.Builder()
                .speaker(s)
                .costPrice(800.00)
                .build();
        
        repo.save(updatedS);
        Speaker newSpeaker = repo.findOne(id);
        Assert.assertEquals(newSpeaker.getCostPrice() , 800.00);
    }
    
    @Test (dependsOnMethods = "updateSpeaker")
    private void deletepeaker(){
       repo = ctx.getBean(SpeakerRepository.class);
       Speaker speaker = repo.findOne(id); 
       
       repo.delete(speaker);
       Speaker deletedSpeaker = repo.findOne(id); 
       Assert.assertNull(deletedSpeaker);
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

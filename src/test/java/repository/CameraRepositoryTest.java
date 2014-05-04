/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Camera;
import com.tonata.photostudio2.repository.CameraRepository;
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
public class CameraRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private CameraRepository repo;
    
    public CameraRepositoryTest() {
    }
    
    @Test 
    public void createCamera(){
        repo = ctx.getBean(CameraRepository.class);
        Camera cam = new Camera.Builder()
                .code("C-1202")
                .name("Canon D900")
                .costPrice(7000.00)
                .build();
        
        repo.save(cam);
        id = cam.getId();
        Assert.assertNotNull(cam);
                
    }
    
    @Test (dependsOnMethods = "createCamera")
    public void readCamera(){
         repo = ctx.getBean(CameraRepository.class);
         Camera c = repo.findOne(id);
         Assert.assertEquals(c.getCode() ,"C-1202" );
    }
    
    @Test (dependsOnMethods = "readCamera")
    private void updateCamera(){
         repo = ctx.getBean(CameraRepository.class);
         Camera cam = repo.findOne(id);
         Camera updatedCam = new Camera.Builder()
                 .camera(cam)
                 .code("C-1302")
                 .build();
         repo.save(updatedCam);
         
         Camera newCam = repo.findOne(id);
         Assert.assertEquals(newCam.getCode(), "C-1302");
        
    }
    
    @Test (dependsOnMethods = "updateCamera")
    private void deleteCamera(){
         repo = ctx.getBean(CameraRepository.class);
         
         Camera camera = repo.findOne(id);
         repo.delete(camera);
         
         Camera deletedCam = repo.findOne(id);
         Assert.assertNull(deletedCam);
        
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

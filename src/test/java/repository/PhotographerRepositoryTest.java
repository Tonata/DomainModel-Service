/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Camera;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Tablet;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.PhotographerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Tonata
 */
public class PhotographerRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;
    private static List<Camera> c;
    private static DesktopPC pc;
    private static Camera cam;
    private static Tablet tablet;
    private PhotographerRepository repo;
    public PhotographerRepositoryTest() {
    }
    
    @Test
    public void createPhotographer(){
        repo = ctx.getBean(PhotographerRepository.class);
        Photographer p= new Photographer.Builder("E1004")
                        .firstName("Tonata")
                        .lastName("Nakashololo")
                        .cameras(c)
                        .desktopPc(pc)
                        .tablet(tablet)
                        .build();
        repo.save(p);
        id = p.getId();
        Assert.assertNull(p);
       
    }
    
    @Test (dependsOnMethods = "createPhotographer")
    public void readPhotographer(){
        repo = ctx.getBean(PhotographerRepository.class);
        Photographer photographer = repo.findOne(id);
        Assert.assertEquals(photographer.getWorkerID(),"E1004");
        
    }
    
    @Test (dependsOnMethods = "readPhotographer")
    private void updatePhotographer(){
        repo = ctx.getBean(PhotographerRepository.class);
        Photographer ph = repo.findOne(id);
        Photographer updatedP = new Photographer.Builder("E1004")
                             .photographer(ph)
                             .firstName("Maggie")
                             .build();
                             
         repo.save(updatedP);
         
         Photographer newPhotographer = repo.findOne(id);
         Assert.assertEquals(newPhotographer.getFirstName() , "Maggie");
    }
    
    @Test (dependsOnMethods = "updatePhotographer")
    private void deletePhotographer(){
        repo = ctx.getBean(PhotographerRepository.class);
        Photographer photographer = repo.findOne(id);
        repo.delete(photographer);
        
        Photographer deletedPhotographer = repo.findOne(id);
        
        Assert.assertNull(deletedPhotographer);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        c = new ArrayList<Camera>();
        cam = new Camera.Builder().name("Canon D900").build();
        pc = new DesktopPC.Builder().code("Acer 12-W3").build();
        tablet = new Tablet.Builder().code("Lenovo 11-E2").build();
        c.add(cam);
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

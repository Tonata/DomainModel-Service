/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Equipment;
import com.tonata.photostudio2.domain.Smartboard;
import com.tonata.photostudio2.domain.Studio;
import com.tonata.photostudio2.domain.Tablet;
import com.tonata.photostudio2.repository.StudioRepository;
import java.util.ArrayList;
import java.util.List;
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
public class StudioRepositoryTest {
    private static ApplicationContext ctx;
    private StudioRepository repo;
    private Long id;
    private static Equipment e;
    private static List<Equipment> eList;
    public StudioRepositoryTest() {
    }
    
    @Test 
    public void createStudio(){
        repo = ctx.getBean(StudioRepository.class);
        Studio studio = new Studio.Builder("Suite 20A, Buitenkloof Studios")
                .squareMeters(348.90)
                .equipment(eList)
                .build();
        
        repo.save(studio);
        id = studio.getId();
        Assert.assertNotNull(studio);
    }
    
    @Test (dependsOnMethods = "createStudio")
    public void readStudio(){
       repo = ctx.getBean(StudioRepository.class);
       Studio studio = repo.findOne(id);
       Assert.assertEquals(studio.getAddress() ,"Suite 20A, Buitenkloof Studios");
        
    }
    
    @Test (dependsOnMethods = "readStudio")
    private void updateStudio(){
        repo = ctx.getBean(StudioRepository.class);
        Studio studio = repo.findOne(id);
        Studio updatedStudio = new Studio.Builder("Suite 20A, Buitenkloof Studios")
                .studio(studio)
                .squareMeters(400.56)
                .build();
        
        repo.save(updatedStudio);
        Studio newStudio = repo.findOne(id);
        Assert.assertEquals(newStudio.getSquareMeters(), 400.56);
    }
    
    @Test (dependsOnMethods = "updateStudio")
    private void deleteStudio(){
        repo = ctx.getBean(StudioRepository.class);
        Studio studio = repo.findOne(id);
        
        repo.delete(studio);
        Studio deletedStudio = repo.findOne(id);
        Assert.assertNull(deletedStudio);
    }
    

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        eList = new ArrayList<Equipment>();
        
        eList.add(new Tablet.Builder().name("Lenovo").build());
        eList.add(new Smartboard.Builder().code("Smart A12330").build());
        eList.add(new DesktopPC.Builder().code("Mac-3435-34").build());
        
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

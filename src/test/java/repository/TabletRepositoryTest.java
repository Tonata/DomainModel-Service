/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Tablet;
import com.tonata.photostudio2.repository.TabletRepository;
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
public class TabletRepositoryTest {
    private static ApplicationContext ctx;
    private TabletRepository repo;
    private Long id;
    public TabletRepositoryTest() {
    }
    
    @Test
    public void createTablet(){
        repo = ctx.getBean(TabletRepository.class);
        Tablet tablet = new Tablet.Builder()
                .name("Lenovo Miix 2.8")
                .costPrice(7000)
                .build();
        
        repo.save(tablet);
        id = tablet.getId();
        Assert.assertNotNull(tablet);
        
    }
    @Test (dependsOnMethods = "createTablet")
    public void readTablet(){
        repo = ctx.getBean(TabletRepository.class);
        Tablet tablet = repo.findOne(id);
        Assert.assertEquals(tablet.getName() , "Lenovo Miix 2.8");
        
    }
    @Test (dependsOnMethods = "readTablet")
    private void updateTablet(){
        repo = ctx.getBean(TabletRepository.class);
        Tablet tablet = repo.findOne(id);
        Tablet updatedTablet = new Tablet.Builder()
                .tablet(tablet)
                .name("L")
                .build();
        
        repo.save(updatedTablet);
        Tablet newTablet = repo.findOne(id);
        Assert.assertEquals(newTablet.getName() , "L");
    }
    @Test (dependsOnMethods = "updateTablet")
    private void deleteTablet(){
        repo = ctx.getBean(TabletRepository.class);
        Tablet tablet = repo.findOne(id);
        
        repo.delete(tablet);
        Tablet deletedTablet = repo.findOne(id);
        Assert.assertNull(deletedTablet);
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

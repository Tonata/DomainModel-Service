/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.services.HighestFlyerCostService;
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

/**
 *
 * @author Tonata
 */
public class HighestFlyerCostServiceTest {
    public static ApplicationContext ctx;
    public HighestFlyerCostService h;
    
    public HighestFlyerCostServiceTest() {
        Flyer f1 = new Flyer.Builder().description("flyer").cost(608.99).build();
        Flyer f2 = new Flyer.Builder().description("flyer").cost(2000.00).build();
        Flyer f3 = new Flyer.Builder().description("flyer").cost(800.90).build();
        
        List<Flyer> flyers = new ArrayList<Flyer>();
        flyers.add(f1);
        flyers.add(f2);
        flyers.add(f3);
        
        Assert.assertEquals(h.highestCost(flyers), f2);
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

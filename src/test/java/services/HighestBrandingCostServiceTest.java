/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Work;
import com.tonata.photostudio2.services.HighestBrandingCostService;
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
public class HighestBrandingCostServiceTest {
    public static ApplicationContext ctx;
    public HighestBrandingCostService h;
    
    public HighestBrandingCostServiceTest() {
    }
    
    @Test
    public void highestBrandTest(){
        h = ctx.getBean( HighestBrandingCostService.class);
        Branding b1 = new Branding.Builder().description("logo").cost(350.00).build();
        Branding b2 = new Branding.Builder().description("logo 2").cost(400.00).build();
        Branding b3 = new Branding.Builder().description("logo 3").cost(800.00).build();
        
        List<Branding> w = new ArrayList<Branding>();
        w.add(b1);
        w.add(b2);
        w.add(b3);
        
        Assert.assertEquals(h.highestCost(w), b3);
        
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

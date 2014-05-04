/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Photograph;
import com.tonata.photostudio2.services.HighestPhotoCostService;
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
public class HighestPhotoCostServiceTest {
    public static ApplicationContext ctx;
    public HighestPhotoCostService h;
    
    public HighestPhotoCostServiceTest() {
    }
    
    @Test
    public void highestPhotoCost(){
        h = ctx.getBean(HighestPhotoCostService.class);
        
        Photograph p1 = new Photograph.Builder().description("Wedding").cost(1000.00).build();
        Photograph p2 = new Photograph.Builder().description("Self portait").cost(1500.00).build();
        Photograph p3 = new Photograph.Builder().description("Sports shoot").cost(3000.00).build();
        
        List<Photograph> photo = new ArrayList<Photograph> ();
        photo.add(p1);
        photo.add(p2);
        photo.add(p3);
        
        Assert.assertEquals(h.highestCost(photo), p3);
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

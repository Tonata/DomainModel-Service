/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Camera;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.domain.Tablet;
import com.tonata.photostudio2.services.TotalPhotographerGadgetsService;
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
public class TotalPhotographerGadgetsServiceTest {
    public static ApplicationContext ctx;
    public TotalPhotographerGadgetsService t;
    
    public TotalPhotographerGadgetsServiceTest() {
    }
    
    @Test
    public void totalGadgets(){
        t = ctx.getBean(TotalPhotographerGadgetsService.class);
        
        List<Camera> c = new ArrayList<Camera>();
        c.add(new Camera.Builder().costPrice(12000.00).build());
        Tablet tab = new Tablet.Builder().costPrice(7000.00).build();
        DesktopPC pc = new DesktopPC.Builder().costPrice(2000.00).build();
        
        Photographer photographer = new Photographer.Builder().cameras(c).tablet(tab).desktopPc(pc).build();
        
        Assert.assertEquals(t.totalCost(photographer), 39000.00);
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

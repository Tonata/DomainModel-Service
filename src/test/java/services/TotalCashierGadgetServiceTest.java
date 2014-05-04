/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Cashier;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.services.TotalCashierGadgetService;
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
public class TotalCashierGadgetServiceTest {
    public static ApplicationContext ctx;
    public TotalCashierGadgetService t;
    
    public TotalCashierGadgetServiceTest() {
    }
    
    @Test
    public void totalGagets(){
        t = ctx.getBean(TotalCashierGadgetService.class);
        
        DesktopPC pc = new DesktopPC.Builder().costPrice(20000.00).build();
        Cashier cashier = new Cashier.Builder("12433").desktopPc(pc).build();
        
        Assert.assertEquals(t.totalCost(cashier), 20000.00);
        
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

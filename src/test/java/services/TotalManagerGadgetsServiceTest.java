/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Manager;
import com.tonata.photostudio2.domain.Smartboard;
import com.tonata.photostudio2.services.TotalManagerGadgetsService;
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
public class TotalManagerGadgetsServiceTest {
    public static ApplicationContext ctx;
    public TotalManagerGadgetsService t;
    
    public TotalManagerGadgetsServiceTest() {
    }
    
    @Test
    public void totalGadgets(){
        t = ctx.getBean(TotalManagerGadgetsService.class);
        
        Smartboard board = new Smartboard.Builder().costPrice(25000.00).build();
        DesktopPC pc = new DesktopPC.Builder().costPrice(13500.00).build();
        Manager manager = new Manager.Builder("3423").lastName("Maclaren").board(board).desktopPc(pc).build();
        
        Assert.assertEquals(t.totalCost(manager), 38500.00);
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

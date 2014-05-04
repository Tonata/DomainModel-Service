/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Tablet;
import com.tonata.photostudio2.services.TotalEditorGadgetsService;
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
public class TotalEditorGadgetsServiceTest {
    public static ApplicationContext ctx;
    public TotalEditorGadgetsService t;
    
    public TotalEditorGadgetsServiceTest() {
    }
    
    @Test
    public void totals(){
        t = ctx.getBean(TotalEditorGadgetsService.class);
        
        DesktopPC pc = new DesktopPC.Builder().costPrice(23000.00).build();
        Tablet tab = new Tablet.Builder().costPrice(7000.00).build();
        
        Editor editor = new Editor.Builder("123").firstName("Jon").desktopPc(pc).tablet(tab).build();
        
        Assert.assertEquals(t.totalCost(editor), 30000.00);
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

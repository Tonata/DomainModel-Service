/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.domain.Photographer;
import com.tonata.photostudio2.repository.PhotographerRepository;
import com.tonata.photostudio2.services.EquipmentOwnershipService;
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
public class EquipmentOwnershipServiceTest {
    public static ApplicationContext ctx;
    public EquipmentOwnershipService e;
    public PhotographerRepository photographerRepo;
    
    public EquipmentOwnershipServiceTest() {
    }
   
    @Test
    public void totalGadgets(){
      e = ctx.getBean(EquipmentOwnershipService.class);  
      photographerRepo = ctx.getBean(PhotographerRepository.class);
      
      DesktopPC pc1 = new DesktopPC.Builder().code("121").costPrice(23000.00).build();
      Photographer p1 = new Photographer.Builder().firstName("Matt").lastName("Cole").desktopPc(pc1).build();
      
      Assert.assertEquals(e.getOwner(pc1), "Matt Cole");
      
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

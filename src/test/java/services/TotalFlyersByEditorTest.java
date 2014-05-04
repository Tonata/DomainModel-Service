/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.repository.FlyerRepository;
import com.tonata.photostudio2.services.TotalFlyersByEditor;
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
public class TotalFlyersByEditorTest {
    public static ApplicationContext ctx;
    public static Editor editor1;
    public static Editor editor2;
    public FlyerRepository flyerRepo;
    public TotalFlyersByEditor totalFlyersByEditor;
    
    public TotalFlyersByEditorTest() {
    }

    @Test
    public void flyersByEditorTest(){
        flyerRepo = ctx.getBean(FlyerRepository.class);
        totalFlyersByEditor = ctx.getBean(TotalFlyersByEditor.class);
        
        Flyer f1 = new Flyer.Builder().description("Manilla Bar - Vday").editor(editor1).build();
        Flyer f2 = new Flyer.Builder().description("WGHS- Sports Day").editor(editor1).build();
        Flyer f3= new Flyer.Builder().description("Rosebank Methodist Fun day").editor(editor2).build();
        
        flyerRepo.save(f1);
        flyerRepo.save(f2);
        flyerRepo.save(f3);
        
        Assert.assertEquals(totalFlyersByEditor.getFlyers(editor1), 2);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        editor1 = new Editor.Builder("211").firstName("Tonata").lastName("Nakashololo").build();
        editor2 = new Editor.Builder("127").firstName("Nikki").lastName("Shiyagaya").build();
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

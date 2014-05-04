/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.domain.Flyer;
import com.tonata.photostudio2.domain.Work;
import com.tonata.photostudio2.services.TotalWorkType;
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
public class TotalWorkTypeTest {
    public static ApplicationContext ctx;
    public TotalWorkType totalWorkType;
    public List<Work> works;
    public static Editor editor1;
    public TotalWorkTypeTest() {
    }

    @Test
    public void workTypeTest(){
        totalWorkType = ctx.getBean(TotalWorkType.class);
        
        Branding b1 = new Branding.Builder().description("logo").editor(editor1).build();
        Flyer f1 = new Flyer.Builder().description("Mothers day event").editor(editor1).build();
        Flyer f2 = new Flyer.Builder().description("Surfers champs event").editor(editor1).build();
        
        works = new ArrayList<Work>();
        works.add(b1);
        works.add(f1);
        works.add(f2);
        
        Assert.assertEquals(totalWorkType.getTotalWork(works ), 3);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
        editor1 = new Editor.Builder("211").firstName("Tonata").lastName("Nakashololo").build();
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

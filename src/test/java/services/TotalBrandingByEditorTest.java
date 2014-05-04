/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Branding;
import com.tonata.photostudio2.domain.Editor;
import com.tonata.photostudio2.repository.BrandingRepository;
import com.tonata.photostudio2.services.TotalBrandingByEditor;
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
public class TotalBrandingByEditorTest {
    public static ApplicationContext ctx;
    public static Editor editor1;
    public static Editor editor2;
    public BrandingRepository brandRepo;
    public TotalBrandingByEditor totalBrandingByEditor;
    
    public TotalBrandingByEditorTest() {
    }
    
    @Test
    public void test1(){
        brandRepo = ctx.getBean(BrandingRepository.class);
        totalBrandingByEditor = ctx.getBean(TotalBrandingByEditor.class);
        
        Branding b1 = new Branding.Builder().description("boerie roll logo").editor(editor1).build();
        Branding b2 = new Branding.Builder().description("hoodie logo").editor(editor2).build();
        Branding b3 = new Branding.Builder().description("advert").editor(editor1).build();
        
        brandRepo.save(b1);
        brandRepo.save(b2);
        brandRepo.save(b3);
        
        Assert.assertEquals(totalBrandingByEditor.getBranding(editor1), 2);
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

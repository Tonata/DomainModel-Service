/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.DesktopPC;
import com.tonata.photostudio2.repository.DesktopPCRepository;
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
public class DesktopPCRepositoryTest {
    private static ApplicationContext ctx;
    private DesktopPCRepository repo;
    private Long id;
    public DesktopPCRepositoryTest() {
    }
    
    @Test
    public void createDesktopPC(){
        repo = ctx.getBean(DesktopPCRepository.class);
        DesktopPC pc = new DesktopPC.Builder()
                .code("230045-AA")
                .name("Dell Inspiron- Quad core")
                .costPrice(20900.00)
                .build();
        repo.save(pc);
        id = pc.getId();
        Assert.assertNotNull(pc);
    }
    
    @Test (dependsOnMethods = "createDesktopPC")
    public void readDesktopPC(){
        repo = ctx.getBean(DesktopPCRepository.class);
        DesktopPC pc = repo.findOne(id);
        Assert.assertEquals(pc.getName() ,"Dell Inspiron- Quad core");
        
    }
    
    @Test (dependsOnMethods = "readDesktopPC")
    private void updateDesktopPC(){
        repo = ctx.getBean(DesktopPCRepository.class);
        DesktopPC pc = repo.findOne(id);
        DesktopPC updatedPc = new DesktopPC.Builder()
                .desktopPC(pc)
                .name("HP - Quad Core")
                .build();
        repo.save(updatedPc);
        
        DesktopPC newPc = repo.findOne(id);
        Assert.assertEquals(newPc.getName(),"HP - Quad Core" );
        
    }
    
    @Test (dependsOnMethods = "updateDesktopPC")
    private void deleteDesktopPC(){
        repo = ctx.getBean(DesktopPCRepository.class);
        DesktopPC pc = repo.findOne(id);
        
        repo.delete(pc);
        DesktopPC deletedPc = repo.findOne(id);
        Assert.assertNull(deletedPc);
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

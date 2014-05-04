/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Smartboard;
import com.tonata.photostudio2.repository.SmartboardRepository;
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
public class SmartboardRepositoryTest {
    private static ApplicationContext ctx;
    private SmartboardRepository repo;
    private Long id;
    
    public SmartboardRepositoryTest() {
    }
    
    @Test
    public void createSmartboard(){
        repo = ctx.getBean(SmartboardRepository.class);
        Smartboard board = new Smartboard.Builder()
                .code("303042")
                .name("SMART-200")
                .costPrice(10000.00)
                .build();
        
        repo.save(board);
        id = board.getId();
        Assert.assertNotNull(board);
        
    }
    @Test (dependsOnMethods = "createSmartboard")
    public void readSmartboard(){
        repo = ctx.getBean(SmartboardRepository.class);
        Smartboard board = repo.findOne(id);
        Assert.assertEquals(board.getCostPrice(),10000.00);
        
    }
    @Test (dependsOnMethods = "readSmartboard")
    private void updateSmartboard(){
        repo = ctx.getBean(SmartboardRepository.class);
        Smartboard board = repo.findOne(id);
        Smartboard updatedBoard = new Smartboard.Builder()
                .smartboard(board)
                .costPrice(12000.00)
                .build();
        
        repo.save(updatedBoard);
        
        Smartboard newBoard = repo.findOne(id);
        Assert.assertEquals(newBoard.getCostPrice(), 12000.00);
        
    }
    @Test (dependsOnMethods = "updateSmartboard")
    private void deleteSmartboard(){
        repo = ctx.getBean(SmartboardRepository.class);
        Smartboard board = repo.findOne(id);
        
        repo.delete(board);
        Smartboard deletedBoard = repo.findOne(id);
        Assert.assertNull(deletedBoard);
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

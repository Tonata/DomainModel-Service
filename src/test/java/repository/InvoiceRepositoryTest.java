/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package repository;

import com.tonata.photostudio2.app.conf.ConnectionConfig;
import com.tonata.photostudio2.domain.Cashier;
import com.tonata.photostudio2.domain.Invoice;
import com.tonata.photostudio2.repository.InvoiceRepository;
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
public class InvoiceRepositoryTest {
    private static ApplicationContext ctx;
    private InvoiceRepository repo;
    private Long id;
    
    public InvoiceRepositoryTest() {
    }
    
    @Test
    public void createInvoice(){
        repo = ctx.getBean(InvoiceRepository.class);
        Cashier cashier = new Cashier.Builder("Smith-120").firstName("Noya").lastName("Smith").build();
        
        Invoice inv =  new Invoice.Builder()
                .invoiceNum(232)
                .cashier(cashier)
                .build();
        
        repo.save(inv);
        id = inv.getId();
        Assert.assertNotNull(inv);
    }
    
    @Test (dependsOnMethods = "createInvoice")
    public void readInvoice(){
        repo = ctx.getBean(InvoiceRepository.class);
        Invoice inv = repo.findOne(id);
        Assert.assertEquals(inv.getCashier().getWorkerID(), "Smith-120");
    }
    
    @Test (dependsOnMethods = "readInvoice")
    public void updateInvoice(){
        repo = ctx.getBean(InvoiceRepository.class);
        Invoice inv = repo.findOne(id);
        Invoice updatedInvoice = new Invoice.Builder()
                .invoice(inv)
                .invoiceNum(222)
                .build();
        
        repo.save(updatedInvoice);
        Invoice newInvoice = repo.findOne(id);
        Assert.assertEquals(newInvoice.getInvoiceNum(), 222);
    }
    
    @Test (dependsOnMethods = "updateInvoice")
    public void deleteInvoice(){
        repo = ctx.getBean(InvoiceRepository.class);
        Invoice inv = repo.findOne(id);
        
        repo.delete(inv);
        Invoice deletedInvoice = repo.findOne(id);
        Assert.assertNull(deletedInvoice);
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

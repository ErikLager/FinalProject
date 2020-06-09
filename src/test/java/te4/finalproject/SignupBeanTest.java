/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package te4.finalproject;

import nu.te4.finalproject.beans.SignupBean;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Te41905
 */
public class SignupBeanTest {
    
    public SignupBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of signupUser method, of class SignupBean.
     */
    @Test
    public void testSignupUser() {
        System.out.println("signupUser");
        String basicAuth = "";
        SignupBean instance = new SignupBean();
        Response expResult = null;
        String result = instance.signupUser(basicAuth);
        assertEquals(expResult, result);
    }
    
}

/**
 * 
 */
package com.ticket.system;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.ticket.system.util.TSValidationUtils;

/**
 *******************************************************************************
 * Test Executor for the TicketService
 * 
 ******************************************************************************
 */
public class TestExecutor {

	private static Logger logger = Logger.getLogger(TestExecutor.class);
    private TSValidationUtils tsValidationUtils = null;	
    private String emailID = "siva@gmail.com";
    private String wrongEmailID = "siva,asd.com";
    private String yes = "YES";
    
    
	public TestExecutor (){
		
		logger.info("Entered to the TestExecutor");
	}
		
	 @Before
	    public void setUp() {
		 tsValidationUtils = new TSValidationUtils();
		 logger.info("@Before - setUp");
	    }
	 
	@Test
	 public void test_isValidEmail_HappyPath() throws Exception {
	        
		 assertEquals(true,tsValidationUtils.isValidEmailID(emailID));
	        
	 }
	
	@Test
	 public void test_isValidEmail_NegativePath() throws Exception {
	        
		 assertEquals(false,tsValidationUtils.isValidEmailID(wrongEmailID));
	        
	 }
	@Test
	 public void test_isValidOptChoice_HappyPath() throws Exception {
	        
		 assertEquals(true,tsValidationUtils.isValidOptChoice(yes));
	        
	 }
	
	@Test
	 public void test_isValidOptChoice_NegativePath() throws Exception {
	        
		 assertEquals(false,tsValidationUtils.isValidEmailID("YUP"));
	        
	 }
	@Test
	 public void test_isValidOptChoice_HappyPath_no() throws Exception {
	        
		 assertEquals(true,tsValidationUtils.isValidOptChoice("no"));
	        
	 }
	
	@Test
	 public void test_isValidOptChoice_NegativePath_no() throws Exception {
	        
		 assertEquals(false,tsValidationUtils.isValidEmailID("nope"));
	        
	 }
      
}

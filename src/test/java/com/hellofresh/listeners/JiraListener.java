package com.hellofresh.listeners;

import org.testng.ITestListener;

public class JiraListener implements ITestListener {

	
	/*
	 * 
	 * 
	 * 
	 In-case the execution results need to be updated to Jira or any other test case management tool
	 , this lister needs to be implemented
	 
	 We can get the test case id from the current test case by implementing an annotation
	 
	  After implementation, the test method will look like:
	  
	  @Test
	  @TestData(id=12345)
	  public void verifyLogin(){
	  
	  }
	 
	 Where, @TestData - is the annotation that gets the test case ID
	 
	 * 
	 * 
	 * 
	 */
}

package com.vsp.tecsa.steps;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ClaimsTestV2 {
	
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    baseUrl = "http://jenkins.vsp.com/job/claim-pricing-test-regression/";
  }

  @Test
  public void GetFailedClaims() throws Exception {
	  	List<String> failedLinks = new ArrayList<String>();
	  	driver.get(baseUrl);
	  	driver.manage().window().maximize();
	  	driver.findElement(By.partialLinkText("Last build ")).click();
	  	driver.findElement(By.linkText("JBehave Results")).click();
	  	driver.switchTo().frame("myframe");
	  	List<WebElement> rows = driver.findElements(By.tagName("tr"));
	  	List<String> failedClaims = new ArrayList<String>();
	  	List<String> claims = new ArrayList<String>();
	  	System.out.println(rows.size());
		File failedclaims = new File("//NTSCA126/Isdshared/TESCA/ClaimFiles/FailedClaims.doc");
		PrintWriter printwriter = new PrintWriter(failedclaims);
	  	for (WebElement row : rows) {
	  		try{
	  			List<WebElement> columns = row.findElements(By.tagName("td"));	  			
	  			if (columns.size() > 1){
	  				System.out.println(columns.get(0).getAttribute("class"));
	  				if (columns.get(0).getAttribute("class").equals("story failed")) {
	  					List<WebElement> anchors = columns.get(19).findElements(By.tagName("a"));
	  					System.out.println(anchors.get(1).getAttribute("href"));
	  					failedLinks.add(anchors.get(1).getAttribute("href"));  						
	  				}	
	  			}
	  		} catch (NoSuchElementException e) {
	  			System.out.println("no td");
	  		}		  		 		
	  	}
	  	for (String link : failedLinks) {
	  		driver.get(link);
	  		List<WebElement> metaTag = driver.findElements(By.cssSelector(".meta:nth-of-type(2)"));
	  	    System.out.println(metaTag.size() + "  --->  " + "Meta Tags");
		  	for (WebElement metaRow : metaTag) {
		  		try{
		  			List<WebElement> metaDivRows = metaRow.findElements(By.tagName("div"));
		  			System.out.println(metaDivRows.size() + "  --->  " + "Tags are present");			  			
		  			int metaDivCount = 0;		  			
					while (metaDivCount < metaDivRows.size()) {			  			
		  				System.out.println(metaDivRows.get(metaDivCount).getText());
		  				if (metaDivRows.get(metaDivCount).getText().equals("@CPP Regression")) {
		  					System.out.println("The ---->  " + metaDivRows.get(metaDivCount).getText() + " Tag is present in this Story");
		  					List<WebElement> divRows = driver.findElements(By.cssSelector(".scenario"));
		  					System.out.println(divRows.size() + "  --->  " + "Scenarios");
		  				  	for (WebElement newRow : divRows) {
		  				  		try{
		  				  			List<WebElement> failedRows = newRow.findElements(By.tagName("div"));
		  				  			System.out.println(failedRows.size() + "  --->  " + "Test Steps");			  			
		  				  			int divCount = 0;		  			
		  							while (divCount < failedRows.size()) {			  			
		  				  				System.out.println(failedRows.get(divCount).getAttribute("class"));
		  				  				if (failedRows.get(divCount).getAttribute("class").equals("step failed")) {
		  				  					System.out.println(failedRows.get(0).getText());
		  				  					failedClaims.add(failedRows.get(0).getText());
		  				  					break;
		  				  				}			  			
		  					  			divCount += 1;
		  							}
		  				  		} catch (NoSuchElementException e) {
		  				  			System.out.println("no div");
		  				  		  }
		  				    }
		  			        for (String claim : failedClaims) {
		  			            System.out.println(claim);
		  			            if (!claims.contains(claim)){
		  			                  claims.add(claim);
		  			            }
		  			         }
		  			        	Boolean linkAdded = false;
		  			        	printwriter.println(" ");
		  			        	printwriter.println(" ");
		  			            for (String claimLine : claims ) {
		  			            	if (!linkAdded) {
		  			            		printwriter.println("This is the Link: ----> " + link);
		  			            		System.out.println("These are the ones I want: " + claimLine);
		  			                    printwriter.println(" ");
		  			            		linkAdded = true;
		  			            	 }	            	
		  				                System.out.println("These are the ones I want: " + claimLine);
		  				                printwriter.println("       " + claimLine);           	 
		  			             }
		  			            	failedClaims.clear();
		  			            	claims.clear();	
		  			            	break;
		  				}			  			
			  			metaDivCount += 1;
					 }
		  		  } catch (NoSuchElementException e) {
		  			System.out.println("no div");
		  		     }
		      }	  		
	     }
	  				printwriter.close();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}


package com.vsp.tecsa.steps;

import java.io.File;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;

import com.vsp.tecsa.TestTecsaCallMain;

public class Jeffstuff {
  private WebDriver driver;
  private String baseUrl;
//  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "https://www-acpt.vsp.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJeffstuff() throws Exception {
	    driver.get(baseUrl + "/home.html");
	    driver.findElement(By.id("login_link")).click();
	    driver.findElement(By.id("userid")).clear();
	    driver.findElement(By.id("userid")).sendKeys("chuckmile");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("$Test123");
	    driver.findElement(By.id("login_0")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Claims\n					& Reimbursement')]")).click();
	    driver.findElement(By.cssSelector("a[href='/out-of-network1.html']")).click();
	    driver.findElement(By.cssSelector("a.jqTransformSelectOpen")).click();
	    driver.findElement(By.linkText("March")).click();
	    driver.findElement(By.xpath("//form[@id='app1']/div/div[2]/div/a")).click();
	    driver.findElement(By.linkText("16")).click();
	    driver.findElement(By.id("patDateOfSvc_year")).clear();
	    driver.findElement(By.id("patDateOfSvc_year")).sendKeys("2015");
	    driver.findElement(By.id("nextBtn")).click();
	    driver.findElement(By.id("mbrAddressStreet")).clear();
	    driver.findElement(By.id("mbrAddressStreet")).sendKeys("3 lane");
	    driver.findElement(By.id("mbrAddressCity")).clear();
	    driver.findElement(By.id("mbrAddressCity")).sendKeys("folsom");
	    driver.findElement(By.cssSelector("div.addressColumn > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen")).click();
	    driver.findElement(By.linkText("California")).click();
	    driver.findElement(By.id("mbrAddressZip")).clear();
	    driver.findElement(By.id("mbrAddressZip")).sendKeys("95630");
	    driver.findElement(By.id("mbrEmailAddress")).clear();
	    driver.findElement(By.id("mbrEmailAddress")).sendKeys("chuckml@vsp.com");
	    driver.findElement(By.id("nextBtn")).click();
	    driver.findElement(By.id("providerAddressStreet")).clear();
	    driver.findElement(By.id("providerAddressStreet")).sendKeys("3 dr");
	    driver.findElement(By.id("providerAddressCity")).clear();
	    driver.findElement(By.id("providerAddressCity")).sendKeys("folsom");
	    driver.findElement(By.cssSelector("div.addressColumn > div.jqTransformSelectWrapper > div > a.jqTransformSelectOpen")).click();
	    driver.findElement(By.linkText("California")).click();
	    driver.findElement(By.id("providerAddressZip")).clear();
	    driver.findElement(By.id("providerAddressZip")).sendKeys("95630");
	    driver.findElement(By.id("providerPhone")).clear();
	    driver.findElement(By.id("providerPhone")).sendKeys("916-678-5679");
	    driver.findElement(By.id("examCost")).clear();
	    driver.findElement(By.id("examCost")).sendKeys("30.00");
	    driver.findElement(By.id("nextBtn")).click();
	    driver.findElement(By.cssSelector("a.jqTransformSelectOpen")).click();
	    driver.findElement(By.linkText("All About Eyes")).click();
	    driver.findElement(By.id("nextBtn")).click();
	    
//	    driver.findElement(By.cssSelector("#upload input#upload_upload")).clear();
	    
//	    driver.findElement(By.cssSelector(".jqTransformButton.uploadBtn")).click();
//	    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\juanlo2\\Desktop\\12319587-0003_Mock story Success Report.PNG"); // Give  path where the exe is saved.
	    
	    File file = null;

	    try {
	        file = new File(TestTecsaCallMain.class.getClassLoader().getResource("com\\vsp\\tecsa\\stories\\Training Material\\OON 1.pdf").toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }

	    Assert.assertTrue(file.exists()); 
	    
//	    WebElement webElement = driver.findElement(By.cssSelector(".jqTransformButton.uploadBtn"));
	    
	    
	    
	    WebElement webElement = driver.findElement(By.id("upload_upload"));
	    ((JavascriptExecutor)driver).executeScript("arguments[0].style.display = 'block'; arguments[0].style.visibility = 'visible';", webElement);

	    webElement.sendKeys(file.getAbsolutePath());
	    
	    
	    
//	    webElement.sendKeys(file.getAbsolutePath());

//	    driver.findElement(By.id("upload_upload")).sendKeys("C:\\Users\\juanlo2\\Desktop\\12319587-0003_Mock story Success Report.PNG");
	    Thread.sleep(10000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


//  private boolean isElementPresent(List<WebElement> list) {
//    try {
//      driver.findElements((By) list);
//      return true;
//    } catch (NoSuchElementException e) {
//      return false;
//    }
//  }
//
//  private boolean isAlertPresent() {
//    try {
//      driver.switchTo().alert();
//      return true;
//    } catch (NoAlertPresentException e) {
//      return false;
//    }
//  }
//
//  private String closeAlertAndGetItsText() {
//    try {
//      Alert alert = driver.switchTo().alert();
//      String alertText = alert.getText();
//      if (acceptNextAlert) {
//        alert.accept();
//      } else {
//        alert.dismiss();
//      }
//      return alertText;
//    } finally {
//      acceptNextAlert = true;
//    }
//  }
}


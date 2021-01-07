package org.iit.healthcare.helper;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperClass {
	int i= 0;
	WebDriver driver;
	
	public HelperClass(WebDriver driver){
		this.driver=driver;
	}
	
	public void launchApplication(String url){
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
	}
	public void naviagatitomodule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	public void patientlogin(String Uname,String Pword){
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(Pword);
		driver.findElement(By.name("submit")).click();
	}
	public void adminModuleNavigate(String moduleName){

		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	
	public void captureScreenshots(String tc_Name) throws IOException{
		System.out.println("Capturing ScreenshotsMehod");
		TakesScreenshot tc = (TakesScreenshot)driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		System.out.println(source.getAbsolutePath());
		
	File targetFile= new File("./ScreenShots/"+tc_Name+"_"+Calendar.getInstance().getTimeInMillis()%1000000000+".png");
	FileUtils.copyFile(source,targetFile);
	System.out.println(targetFile);
		
	}
	public void highLightElements(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;", element);
		
	}
	public WebDriver switchToAFrames(String frameId,int timeinSecs)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeinSecs);
		driver = wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
		return driver;
	}
	public void scrollToViewOfWebElement(WebElement we){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",we);
		System.out.println("Scrolling down to the exact location" );
	}
	
	}



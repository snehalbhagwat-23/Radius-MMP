package org.iit.healthcare.baseclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected WebDriver driver;
	@BeforeTest
	public void instanstiateDriver(){
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	public void launchAplication(String url){
		driver.get(url);	
	}
	public void getPatientloginPage(String UName, String Pword){

		System.out.println("login");
		driver.findElement(By.linkText("Patient Login")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys(UName);
		driver.findElement(By.id("password")).sendKeys(Pword);
		driver.findElement(By.name("submit")).click();
		
		
	}
	
	public  void moduleNavigation(String moduleName){
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
	
	public void adminLogin(String uName, String password){

		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("admin")).click();

	}
	public void adminModuleNavigation(String moduleName){

		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();

	}
	public void highLightElement(WebElement ele){
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);
	
}
}

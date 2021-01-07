package org.iit.healthcare.patientModule.pageobjectPages;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class PatientViewInformationPage {
	WebDriver driver;
	

	public PatientViewInformationPage(WebDriver driver){
		this.driver=driver;
	}
	
	By actualText= By.xpath("//div[@class='panel-title']");
	 
	String expectedLines= "  Manage My Patient (MMP) is a medical practice management "
			+ "solution that boosts productivity by automating the day-to-day "
			+ "tasks that can slow an office manager down. Central delivers"
			+ " much more than medical billing software. Sure, it has the tools "
			+ "to help generate cleaner claims and reduce denials, but our easy-to-use "
			+ "practice management software also streamlines your workflow to deliver "
			+ "seamless handoffs across departments.";
	String actualLines="";
   
	public void validateViewInformatin(){
		
		String[] expectedText=expectedLines.split("");
		System.out.println(expectedText);
		
		String actualTextLines="";
		String actual = driver.findElement(actualText).getText().trim();
		String[] actualTextList = actual.split("\n");
		System.out.println(actualTextList.length);
		for (int i=0;i<actualTextList.length;i++){
			actualTextList[i].trim();
			actualTextLines=actualTextLines+""+actualTextList[i];
			System.out.println(actualTextLines);
			
			
		}
				
				
				
				
		
		
//		boolean result=true;
//		
//		String[] expectedT = expectedLines.split(" ").;
//		
//		
//		String actualText= driver.findElement(actualLines).getText().trim().replace("\\s", "").trim();//getText().trim();
//				String[]actualTextL= actualText.split("\n");
//				
//		System.out.println(actualText);
//		
//		
//		System.out.println(expectedT);
//		
//	
//		Assert.assertEquals(actualTextL.length, expectedT.length);
//		return false;
		
	}
	

}

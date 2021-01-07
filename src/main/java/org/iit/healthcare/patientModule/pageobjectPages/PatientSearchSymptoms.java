package org.iit.healthcare.patientModule.pageobjectPages;

import org.iit.healthcare.helper.HelperClass;
import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PatientSearchSymptoms {
	WebDriver driver;
	
	By searchTextBox=By.id("search");
	By pageTitle=By.xpath("//h3[@class='panel-title']")	;
	By serachButton=By.xpath("//input[@value='Search']");
	By dataRow=By.xpath("//table[@class='table']//tbody//tr//td");
	
	public PatientSearchSymptoms(WebDriver driver){
		this .driver=driver;
	}
	
	public void searchSymptome(WebDriver driver){
		
	 HelperClass helper=new HelperClass(driver);
	 helper.adminModuleNavigate("Search Symptoms");
	
	 String title= driver.getTitle();
	 System.out.println(title);
	 if (title.contains("search Symptoms")){
		 System.out.println("SearchSymptoms page loaded succssfully");
	 }
	 else
	 {
		 System.out.println("Page not Loaded successfully");
	 }
	}
	public boolean validateSymptoms (String symptoms) throws InterruptedException  
	{
		 boolean display= false;
		 driver.findElement(searchTextBox).clear();
		 driver.findElement(searchTextBox).sendKeys(symptoms);
		 driver.findElement(serachButton).click();
	
		 List <WebElement>symptomsRow=driver.findElements(dataRow);
		 System.out.println("size of row"+symptomsRow.size());
		 
		 if (symptomsRow.size()==3){
			 System.out.println("data will display for "+symptoms);
			 display=true;
		 }
		 else{
			 System.out.println("no data will display for"+symptoms);
			 display =true;
		 }
		 return display;
		 
	 }
		 
	 
	 
	 


		
	}

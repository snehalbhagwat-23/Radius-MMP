package org.iit.healthcare.patientModule.pageobjectPages;

import java.util.HashMap;

import org.apache.cassandra.cli.CliParser.assumeStatement_return;
import org.iit.healthcare.helper.HelperClass;
import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class PatientScheduleAppointmentPage2 {
	WebDriver driver;
	HashMap<String, String> apmtDetailshMap= new HashMap<String, String>();
	HelperClass helper;
	
	
	
	By createNewAppointmentButton = By.xpath("//input[@value='Create new appointment']");
	By doctorXpath = By.xpath( "//h4[contains(text(),'+doctorName+')]/ancestor::td/button[@id='opener']");
	By date = By.id("datepicker");
	By timeTb = By.id("time");
	//By anyPlace = By.xpath("//body");
	By continueBtn = By.id("ChangeHeatName");
	By symptomBox=By.id("sym");
	By submitXpath = By.xpath("//input[@value='Submit']");
	By dateOfAppointmentOnHomeP = By.xpath("//table[@class='table']//tr[1]/td[1]");
	By timeOfAppointmentOnHomeP = By.xpath("//table[@class='table']//tr[1]/td[2]");
	By symptomsAppointmentOnHomeP = By.xpath("//table[@class='table']//tr[1]/td[3]");
	By doctorNameAppointmentOnHomeP = By.xpath("//table[@class='table']//tr[1]/td[4]");
	By dateOfAppointmentOnScheduleP = By.xpath("(//h3[@class='panel-title'])[2]");
	By timeOfAppointmentOnScheduleP = By.xpath("//a[contains(text(),'Time :')]");
	By symptomsOfAppointmentOnScheduleP = By.xpath("//a[contains(text(),'Symptoms:')]");
	By doctorNameOfAppointmentOnScheduleP = By.xpath("//a[contains(text(),'Provider:')]");
	//String doctorXpath =  "//h4[contains(text(),'%%doctorName%%')]/ancestor::td/button[@id='opener']";
	
	
	public PatientScheduleAppointmentPage2(){
		this.driver=driver;
		
	}
	public void clickOnCreateButton(){
		driver.findElement(createNewAppointmentButton).click();
	}
	public HashMap<String,String> bookAppointment (String Doctorname){
		driver.findElement(By.xpath("//h4[contains(text(),'"+Doctorname+"')]/ancestor::ul/following-sibling::button[@id='opener']")).click();
		String [] DrName= Doctorname.split("\\.");
		apmtDetailshMap.put("DoctorName", DrName[1]);
		helper.switchToAFrames("myframe", 20);
		String dateOfApmt=AppLibrary.selectFutureDate(15);
		
		String time= "11 am";
		Select select = new Select(driver.findElement(timeTb));
		select.selectByVisibleText(time);
		apmtDetailshMap.put("Time", time);
		
		driver.findElement(continueBtn);
		
		String symptoms="booking an apmt"+Doctorname+"on date"+dateOfApmt+"for cold,cough";
		driver.findElement(symptomBox).sendKeys(symptoms);
		driver.findElement(submitXpath).click();
		return apmtDetailshMap;
		
	}
	public HashMap<String, String> validateapmtDetailsOnHomePage(){
		helper.naviagatitomodule("Home");
		//boolean result= true;
		/*if( apmtDetailshMap.get("dateOfAppointment").equals(driver.findElement(dateOfAppointmentHP).getText())
				&& apmtDetailshMap.get("time").equals(driver.findElement(timeHP).getText())
				&& apmtDetailshMap.get("symptoms").equals(driver.findElement(symptomsHP).getText())
				&& apmtDetailshMap.get("doctorName").contains(driver.findElement(doctorNameHP).getText()))
		{
			result = true;
		}*/
		HashMap<String, String> homePageApmtDetailsHMAp= new HashMap<String, String>();
		homePageApmtDetailsHMAp.put("dateOfApmt",driver.findElement(dateOfAppointmentOnHomeP).getText());
		homePageApmtDetailsHMAp.put("Time", driver.findElement(timeOfAppointmentOnHomeP).getText());
		homePageApmtDetailsHMAp.put("appointment",driver.findElement(symptomsAppointmentOnHomeP).getText());
		homePageApmtDetailsHMAp.put("DoctorName", driver.findElement(doctorNameAppointmentOnHomeP).getText());
		
		Assert.assertEquals(apmtDetailshMap, homePageApmtDetailsHMAp);
		return homePageApmtDetailsHMAp;
	}
	public HashMap<String, String>  validateAppointmentDetailsSchePage() {
		HashMap<String, String>schedulePageHMap= new HashMap<String, String>();
		String timeWE= driver.findElement(timeOfAppointmentOnScheduleP).getText();
		String[]timeWEArray= timeWE.split(":");
		schedulePageHMap.put("Time",timeWEArray[1].trim());//Time :10am
		
		String symptomWE=driver.findElement(symptomsOfAppointmentOnScheduleP).getText();
		String[] symptomWEArray=symptomWE.split(":");
		schedulePageHMap.put("Symptoms",symptomWEArray[1].trim());//symp:
		
		String doctorNameWE=driver.findElement(doctorNameOfAppointmentOnScheduleP).getText();
		String[] doctorNameWEArray=doctorNameWE.split(":");
		schedulePageHMap.put("DoctorName", doctorNameWEArray[1].trim());
		
		Assert.assertEquals(apmtDetailshMap, schedulePageHMap);
		return schedulePageHMap;
		}
	}
		
	



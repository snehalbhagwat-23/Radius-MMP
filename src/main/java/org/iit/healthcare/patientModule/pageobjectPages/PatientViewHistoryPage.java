package org.iit.healthcare.patientModule.pageobjectPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientViewHistoryPage {
	WebDriver driver;
	By viewhistbutton= By.xpath("//button[text()='View History']");
	
	public PatientViewHistoryPage(){
		this.driver=driver;
	}
	
	
	public void clickOnViewHistoryBtn()
	{
		driver.findElement(viewhistbutton).click();
	}
	public void historyPage(){
		WebElement table= driver.findElement(By.id("wrapper"));
		int buttons=table.findElements(By.tagName("a")).size();
		
		System.out.println(table.findElements(By.tagName("a")).size());
		
		for(int i=1;i<=buttons;i++){
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			table.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
		/*for (WebElement listOfLink :buttons){
			System.out.println(listOfLink.getText());
			String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
			driver*/
		}
		
	}
	
		
	

}

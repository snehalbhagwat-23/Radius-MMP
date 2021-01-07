package org.iit.healthcare.patientModule.pageobjectPages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PatientViewReportPage {
	
	
 WebDriver driver;

	public PatientViewReportPage(WebDriver driver){
		this.driver=driver;
	}
	
	By viewReportbtn=By.xpath("//button[contains(text(),'View Reports')]");
	By Image= By.xpath("div[class='mfp-container mfp-image-holder mfp-s-error']");
	
	public boolean displayViewReport(){
		
		
		boolean result = false;
		String expectedHeader= "View Reports";
		String actualHeader=driver.findElement(By.xpath("//h3[normalize-space()='View Reports']")).getText();
		
		driver.findElement(viewReportbtn).click();
		System.out.println(actualHeader);
		if(expectedHeader.equalsIgnoreCase(actualHeader)){
			
			
			
			System.out.println("matched");
		}
		else{
			System.out.println("not matched");
		}
		
		List <WebElement> list= driver.findElements(By.xpath("//tbody//tr//td//ul"));
		System.out.println(list.size());
		for(int i= 1;i<=list.size();i++){
			String ViewReportIcon="(//tr//td)["+ i +"]//ul//li";
			By Icon =By.xpath(ViewReportIcon);
			driver.findElement(Icon).click();
			driver.findElement(Image).click();
			
		}
		return result;
	}
		
		public boolean ValidatePatientReports(HashMap<String,String> hmap){
			
			//HashMap<String,String> hmap=new HashMap<String,String>();
			boolean res =false;
			
			driver.findElement(viewReportbtn).click();

			List <WebElement> list= driver.findElements(By.xpath("//tbody//tr//td//ul"));
			System.out.println(list.size());
			
			int i = list.size();
			//String viewRep = "(//tr/td)["+ i +"]//li";
			String reportName = "(//tbody//tr//td)["+ i +"]//li//h4" ;
			WebElement rptName = driver.findElement(By.xpath(reportName));
			String report = rptName.getText();
			System.out.println(report);
			
			String reprtDescrption="(//tbody//tr//td)["+i+"]li//div/p";
			WebElement reptDesc= driver.findElement(By.xpath(reprtDescrption));
			String description=reptDesc.getText();
			System.out.println(description);
			String[]DescriptionFi=description.split(":");
			
			if(hmap.get(rptName).equals(report)&&
					hmap.get(description).equals(DescriptionFi[1].trim()))
			{
				res=true;
			}
			System.out.println(res);
			return res;
			
			
			
		}
		
		
		
	}
	



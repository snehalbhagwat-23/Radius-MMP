package org.iit.healthcare.patientModule.pageobjectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PatientLoginPage {
	
	private final WebDriver driver;
	
	public PatientLoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	//helperclass
	By PatientLoginMainTab= By.xpath("//a[contains(text(),'Patient Login')]");
	By PatientLoginBtn=By.xpath("//a[contains(@href,'portal/login.php')]");
	By UsernameTb= By.xpath("//input[@id='username']");
	By PasswordTb=By.xpath("//input[@id='password']");
	By SubmitBtn=By.xpath("//input[@value='Sign In']");
	
	public void loginclick(){
		driver.findElement(PatientLoginMainTab).click();
		driver.findElement(PatientLoginBtn).click();

	}
	
	public void getpatientLoginPage(String username ,String password){
		
		
		driver.findElement(UsernameTb).sendKeys(username);
		driver.findElement(PasswordTb).sendKeys(password);
		driver.findElement(SubmitBtn).click();
		
		
		//login
				/*driver.findElement(By.id("username")).sendKeys(Uname);
				driver.findElement(By.id("password")).sendKeys(Pword);
			//type=Submit//form
				driver.findElement(By.name("submit")).click();	*/
				
	}
	/*public void enterLogin(String Uname,String Pword){
		driver.findElement(By.xpath("//a[@class='button button-alt'][normalize-space()='Login']")).click();//
		
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(Pword);
	//type=Submit//form
		driver.findElement(By.name("submit")).click();	
		
	}*/

	
	
}

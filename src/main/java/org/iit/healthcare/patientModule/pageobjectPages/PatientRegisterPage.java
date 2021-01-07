package org.iit.healthcare.patientModule.pageobjectPages;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;

import org.apache.tools.ant.types.EnumeratedAttribute;
import org.apache.tools.ant.types.resources.comparators.Date;
import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class PatientRegisterPage {
	WebDriver driver;
	HashMap<String, String>hMap=new HashMap<String, String>();
	int noOfCharector=5;
	int noOfDigitInZipCode= 5;
	int noOfDigitInAge=2;
	Random rand= new Random();
	public PatientRegisterPage(WebDriver driver){
		this.driver=driver;
	}

	By registerBtn = By.xpath("//input[@value='Register'] ");
	By firstNameTb=By.id("firstname");
	By lastNameTb= By.id("lastname");
	By DOBTb=By.id("datepicker");
	By licenceTb=By.id("license");
	By ssnTb=By.id("ssn");
	By stateTb=By.id("state");
	By cityTb=By.id("city");
	By addressTb=By.id("address");
	By zipcodeTb=By.id("zipcode");
	By ageTb=By.id("age");
	By heightTb=By.id("height");
	By weightTb=By.id("weight");
	By pharmacyTb=By.id("pharmacy");
	By pharmacyAddressTb=By.id("pharma_adress");
	By emaiTb=By.id("email");
	By usernameTb=By.id("username");
	By passwordTb=By.id("password");
	By confirmpasswordTb=By.id("confirmpassword");
	By securQuestionTb= By.id("security");
	By answerTb= By.id("answer");
	By saveButton=By.xpath("//input[@value='Save']");
	
	public void clickOnRegisterButton(){
		driver.findElement(registerBtn).click();
		
	}

	public void enterFirstName(){
		String FnameValue="FName"+AppLibrary.getRandomString(noOfCharector);
		driver.findElement(firstNameTb).sendKeys(FnameValue);
		hMap.put("FirstName", FnameValue);
	
		
	}
	
	public void enterLastName(){
		String LnameValue="Laname"+AppLibrary.getRandomString(noOfCharector);
		driver.findElement(lastNameTb).sendKeys(LnameValue);
		hMap.put("LastName", LnameValue);
	}
	
	public void enterDOB(){
		Date d= new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
		String dobValue= sdf.format(d);
		driver.findElement(DOBTb).sendKeys(dobValue);
		hMap.put("DOB", dobValue);
		
	}
	public void enterLicence(){
		//String LicenceValue= 999999+rand.nextInt(1000000)+"";
		String LicenceValue=AppLibrary.getRandom(8, 1000000);
		driver.findElement(licenceTb).sendKeys(LicenceValue);
		hMap.put("Licence",LicenceValue);
		System.out.println(LicenceValue);
		}
	public void enterSSn(){
		String SSnValue= 999999+rand.nextInt(1000000)+"";
		driver.findElement(ssnTb).sendKeys(SSnValue);
		hMap.put("SSN", SSnValue);
		System.out.println(SSnValue);
		
			}
	public void enterState(){
		String StateValue= AppLibrary.getRandomState();
		driver.findElement(stateTb).sendKeys(StateValue);
		hMap.put("State", StateValue);
		System.out.println(StateValue);
		
	}
	public void enterCity(){
		String CityValue="PA";
		driver.findElement(cityTb).sendKeys(CityValue);
		hMap.put("City", CityValue);
		System.out.println(CityValue);
	}
	public void enterAddress(){
		String AddressValue="Devon";
		driver.findElement(addressTb).sendKeys(AddressValue);
		hMap.put("Address", AddressValue);
		System.out.println(AddressValue);
		System.out.println(AddressValue);
	}
	public void enterZipcode(){
		String ZipcodeValue=AppLibrary.getRandomNoOfDigits(noOfDigitInZipCode)+"";
		driver.findElement(zipcodeTb).sendKeys(ZipcodeValue);
		hMap.put("Zipcode", ZipcodeValue);
		
		}
	public void enterAgeValue(){
		String AgeValue=AppLibrary.getRandomNoOfDigits(noOfDigitInAge)+"";
		driver.findElement(ageTb).sendKeys(AgeValue);
		hMap.put("Age", AgeValue);
		
	}
	public void enterHeight(){
		String HeightValue= rand.nextInt(100)+"";
		driver.findElement(heightTb).sendKeys(HeightValue);
		hMap.put("Height", HeightValue);
		
	}
	public void enterWeight(){
		String WeightValue=rand.nextInt(149)+"";
		driver.findElement(weightTb).sendKeys(WeightValue);
		hMap.put("weight", WeightValue);
	}
	public void enterPharmacydetails(){
		String PharmacyValue="CVS";
		driver.findElement(pharmacyTb).sendKeys(PharmacyValue);
		hMap.put("Pharmacy", PharmacyValue);
		
		String PharmacyAddressValue= "234 lac Avenue";
		driver.findElement(pharmacyAddressTb).sendKeys(PharmacyAddressValue);
		hMap.put("Pharmacy Address", PharmacyAddressValue);
		
	}
	public void enterUserAccountDetails(){
		String EmailValue="QASnehal"+rand.nextInt(90)+"@gmail.com";
		driver.findElement(emaiTb).sendKeys(EmailValue);
		hMap.put("Email", EmailValue);
		
		String UsernameValue="QAmmp"+rand.nextInt(100);
		driver.findElement(usernameTb).sendKeys(UsernameValue);
		hMap.put("Uesrname", UsernameValue);
		
		String PasswordValue="QASSH	"+rand.nextInt(100);
		driver.findElement(passwordTb).sendKeys(PasswordValue);
		hMap.put("Password", PasswordValue);
		
		//String ConfirmPwordValue= "QASSH"+rand.nextInt(100);
		driver.findElement(confirmpasswordTb).sendKeys(PasswordValue);
		hMap.put("Confirm Password", PasswordValue);
	}
	 public void enterSecurityInfo(){
		 Select select = new Select(driver.findElement(securQuestionTb));
		 select.selectByVisibleText("What is your mother maiden name");
		 hMap.put("Select Question", "What is your mother maiden name");
		 
		 String AnswerValue="QA"+rand.nextInt(100);
		 driver.findElement(By.id("answer")).sendKeys(AnswerValue);
		 hMap.put("Answer", AnswerValue);
	 }
	 public String clickOnSaveButton(){
		 String message="";
		 try {
			
			 
			 driver.findElement(By.name("register")).click();
			 Alert alert= driver.switchTo().alert();
			 alert.accept();
			message= alert.getText();
		} 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("check error mesahe"+e.getMessage());
			//message=checkerror();
		
		 
	}
		return message;
	 }
	 public void fillingData(){
		 enterFirstName();
		 enterLastName();
		 enterDOB();
		 enterLicence();
		 enterSSn();
		 enterState();
		 enterCity();
		 enterAddress();
		 enterZipcode();
		 enterAgeValue();
		 enterHeight();
		 enterWeight();
		 enterPharmacydetails();
		 enterUserAccountDetails();
		 enterSecurityInfo();

		 
	 }
}
		 
	 


	



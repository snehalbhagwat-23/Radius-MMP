package org.iit.healthcare.patientModule.pageobjectPages;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.iit.healthcare.helper.HelperClass;
import org.iit.healthcare.utility.AppLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class PatientEditProfilePage {
	private final WebDriver driver;
	
	static Random rand;
	WebElement we;
	HashMap<String,String> hMap;
	HashMap<String,String> hMap1;
	HelperClass helper;
	
	
		public PatientEditProfilePage(WebDriver driver)
	{
		this.driver=driver;		
	}
	By userName = By.id("username");
	By password = By.id("password");
	By submit	= By.name("submit");
	By profile= By.xpath("//a[@href='profile.php']");
	By editBtn = By.id("Ebtn");	
	By firstNameTb=(By.id("fname"));
	By lastNameTb=(By.id("lname"));
	By licenceTb=(By.id("licn"));
	By ssnTb=(By.id("ssn"));
	By adressTb=(By.id("addr"));
	By ageTb=(By.id("age"));
	By weightTb=(By.id("weight"));
	By heightTb=(By.id("height"));
	By cityTb=(By.id("city"));
	By stateTb=(By.id("state"));
	By zipTb=(By.id("zip"));
	By providerinfoTb=(By.id("proinfo"));
	By insuinfo=(By.id("Insinfo"));	
	By submitTb=(By.id("Sbtn"))	;
	
	public void  loginToHomePage(String Uname, String Pword)
	{
		driver.findElement(userName).sendKeys(Uname);
		driver.findElement(password).sendKeys(Pword);
		driver.findElement(submit).click();
	}
	public void clickOnProfileTB(){
		driver.findElement(profile).click();
		
	}
	public void clickOnEditBtn()
	{
		driver.findElement(editBtn).click();
		System.out.println("click on EditButton");
	}
	
	public void editRandomfields() throws IOException{
		System.out.println("editData");
		int number= 1+rand.nextInt(15);
		System.out.println("we are going to update "+number+"fields");
		for (int i= 1;i<=number;i++)
		{
			int num= 1+rand.nextInt();
			System.out.println("editing field no."+num);
			switch (num){
				case 1:
					editFirstname();
					break;
				case 2:
					editLastname();
					break;
				case 3:
					editLicence();
					break;
				case 4:
					editSSN();
					break;
				case 5:
					editAddress();
					break;
				case 6:
					editAge();
					break;
				case 7:
					editWeight();
					break;
				case 8:
					editHeight();
					break;
				case 9:
					editCity();
					break;
				case 10:
					editState();
					break;
				case 11:
					editZipCode();
					break;
				case 12:
					enterProviderIformation();
					break;
				case 13:
					enterInsuranceInformation();
					break;
				
				
			}
		}
	}
	public void editAllfields() throws IOException{
		editFirstname();
		editLastname();
		editLicence();
		editSSN();
		editAddress();
		editAge();
		editWeight();
		editHeight();
		editCity();
		editState();
		editZipCode();
		enterProviderIformation();
		enterInsuranceInformation();
		
	}
	
	
	
	public  HashMap<String, String> getFieldEdit() {
		hMap1.put("Fname", driver.findElement(firstNameTb).getAttribute("value"));
		hMap1.put("Lname", driver.findElement(lastNameTb).getAttribute("value"));
		hMap1.put("Licence",driver.findElement(licenceTb).getAttribute("value"));
		hMap1.put("SSN",driver.findElement(ssnTb).getAttribute("value"));
		hMap1.put("Address",driver.findElement(adressTb).getAttribute("value"));
		hMap1.put("Age",driver.findElement(ageTb).getAttribute("value"));
		hMap1.put("Weight",driver.findElement(weightTb).getAttribute("value"));
		hMap1.put("Height",driver.findElement(heightTb).getAttribute("value"));
		hMap1.put("City",driver.findElement(cityTb).getAttribute("value"));
		hMap1.put("State",driver.findElement(ssnTb).getAttribute("value"));
		hMap1.put("Zipcode", driver.findElement(zipTb).getAttribute("value"));
		return hMap1;
		
	}
	
	public boolean updatevalidation()
	{
		boolean result= false;
		if(getFieldEdit().equals(hMap))
			result=true;
			System.out.println("upadate result is "+ result);
			return result;
		}
	
	public void editFirstname(){
		we=driver.findElement(firstNameTb);
		System.out.println("Edit FirstName"+ we.getText());
		we.clear();
		String firstNameValue="editFirstName"+(char)(60+rand.nextInt(20));
		we.sendKeys(firstNameValue);
		hMap.put("Fname",firstNameValue);
		
		
	}
	public void editLastname(){
		we=driver.findElement(lastNameTb);
		System.out.println("Edit lastName"+ we.getText());
		we.clear();
		String LastNameValue="editLastName"+(char)(60+rand.nextInt(20));
		we.sendKeys(LastNameValue);
		hMap.put("Lname",LastNameValue);
	}
	public void editLicence(){
		we=driver.findElement(licenceTb);
		String LicenceValue= Calendar.getInstance().getTimeInMillis()+"";
		System.out.println("total number of digit ii Licenece no is"+ LicenceValue.length());
		we.clear();
		we.sendKeys(LicenceValue);
		hMap.put("Licenece",LicenceValue);
	}
	public void editSSN(){
		we=driver.findElement(ssnTb);
		String SsnValue=Calendar.getInstance().getTimeInMillis()+"";
		System.out.println("total no. of digit in SSN ");
		we.clear();
		we.sendKeys(SsnValue);
		hMap.put("SSN",SsnValue);
				
	}
	public void editAddress(){
		we=driver.findElement(adressTb);
		String AddressValue=1+rand.nextInt(24)+",editAddress";
		we.clear();
		we.sendKeys(AddressValue);
		hMap.put("Address", AddressValue);
		
	}
	public void editAge(){
		we=driver.findElement(ageTb);
		String AgeValue= 18+rand.nextInt(78)+"";//above 18 only
		we.clear();
		we.sendKeys(AgeValue);
		hMap.put("Age",AgeValue);
		
	}
	public void editWeight(){
		we=driver.findElement(weightTb);
		String WeightValue=29+rand.nextInt(200)+"";
		we.clear();
		we.sendKeys(WeightValue);
		hMap.put("Weight", WeightValue);
		}
	public void editHeight(){
		we= driver.findElement(heightTb);
		String HeightValue= 20+rand.nextInt(200)+"";
		we.clear();
		we.sendKeys(HeightValue);
		hMap.put("Height", HeightValue);
		}
	/*public static String getRandomState(){
		String state="";
		String[] stateArray= {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
				"Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine","Maryland", "Massachusetts", "Michigan",
				"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York",
				"North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
				"Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };
		int num= rand.nextInt(29);
		state=stateArray[num];
		System.out.println(state);
		return state;*/
	
		public void editCity(){
			int noOfChars= 10;
			we=driver.findElement(cityTb);
			String CityValue=AppLibrary.getRandomString(noOfChars)+"";
			we.sendKeys(CityValue);
			hMap.put("City", CityValue);
			
			
		}

	
	public  void editState() throws IOException{
		we=driver.findElement(stateTb);
		String StateValue=AppLibrary.getRandomState()+"";		we.sendKeys(StateValue);
		hMap.put("State", StateValue);	
		helper.captureScreenshots("State err");
		
	}
	public void editZipCode(){
		int noOfDigits=5;
	  
	  we= driver.findElement(zipTb);
	  String ZipcodeValue=AppLibrary.getRandomNoOfDigits(noOfDigits)+"";
	  we.sendKeys(ZipcodeValue);
	  we.clear();
	  hMap.put("Zipcode", ZipcodeValue);
	}
	public void enterProviderIformation(){
		int noOfChars=7;
		we= driver.findElement(providerinfoTb);
		String ProviderInfoValue=AppLibrary.getRandomString(noOfChars)+"";
		we.sendKeys(ProviderInfoValue);
		we.clear();
		hMap.put("ProviderInfo", ProviderInfoValue);	
		}
	public void enterInsuranceInformation(){
		 int noOfChars=10;
		 helper.highLightElements(we);
		 we= driver.findElement(insuinfo);
		 String InsuranceInfoValue=AppLibrary.getRandomString(noOfChars)+"";
		 we.sendKeys(InsuranceInfoValue);
		 hMap.put("InsuranveInformation", InsuranceInfoValue);
	}
	  public String clickOnSaveButton(){
		 
		  String msg="";
		  try{
			  we=driver.findElement(submitTb);
			  helper.highLightElements(we);
			  we.click();
			  Alert alert= driver.switchTo().alert();
			  alert.getText();
			  alert.accept();
		  }
		  
		  catch(Exception e){
			  System.out.println("Exceptio"+e.getMessage());
		  } 
		  msg=checkErrorMessage();
		  
		return msg;
		  
		  
	  }
	  public String checkErrorMessage(){
		  String msg ="";
		  System.out.println("in error msg");
		  String ErroElement="";
		   List<WebElement> errorElemets = driver.findElements(By.tagName("p"));
		   System.out.println("all error elements "+errorElemets.size());
		   for(WebElement allelements:errorElemets){
			   if(allelements.isDisplayed()){
			   System.out.println(allelements.getText());
			   ErroElement=allelements.getAttribute("id");
			   System.out.println(ErroElement);
			      
		   }
		}
	  try{
		  helper.highLightElements(driver.findElement(submitTb));
		  driver.findElement(submitTb).click();
		  Alert alert= driver.switchTo().alert();
		  alert.accept();
		  }
	  catch(Exception e){
		  System.out.println("Exception got:"+e.getMessage());}
	return msg;
	  }
		  
		  
		  
	  }
	
	
		
	
	
	
		

	
	
	
	
	
	
		
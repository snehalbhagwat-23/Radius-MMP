package org.iit.healthcare.patientModule.pageobjectPages;

import java.util.List;
import java.util.Random;

import org.iit.healthcare.helper.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PatientPayFeesPage {
	WebDriver driver;
	HelperClass helper;
	
	
	By payText=By.linkText("Pay Now");
	By amounts=By.id("amount");
	By continueBtn=By.xpath("//input[@value='Continue']");
	//card details
	By customerName=By.id("name");
	By cardType=By.id("card_name");
	By cardNumber=By.id("cid");
	By cardMonth=By.id("cardMonth");
	By cardYear=By.id("cardYear");
	By cardcvv=By.id("cvv");
	By submitBtn=By.xpath("//input[@value='submit']");
	By selectOptions = By.xpath("//select[@id='amount']/option[text()='$50']");
	
	Random rand= new Random();
	private String amount;

	public PatientPayFeesPage(WebDriver driver){
		this.driver=driver;
		
	}
	public void navigateToPay()
	{
		driver.findElement(payText).click();
	}
	public void selectPayment(String amount){
		WebElement we = driver.findElement(amounts);
		helper.scrollToViewOfWebElement(we);
		Select amt= new Select(we);
		amount="$"+amount;
		System.out.println(amount+"has to pay");
		amt.selectByVisibleText("$100");
		driver.findElement(continueBtn).click();
	}
	public void cardInfo(){
		String cardHolderFLname="Radius"+rand.nextInt(1000)+"";
		driver.findElement(customerName).sendKeys(cardHolderFLname);
		
		Select cards= new Select(driver.findElement(cardType));
		List<WebElement> cardList= cards.getOptions();
		System.out.println("Type of the cards"+cardList);
		for(int i=0; i<cardList.size();i++)
		{
			String cardName= cards.getOptions().get(i).getText();
			if(cardName.equals("Visa"))
			{
				cards.selectByVisibleText("visa");
				String visaCardNum=(long)((rand.nextDouble()*10000000000000L)+550000000000L)+"";
				
				driver.findElement(cardcvv).sendKeys(visaCardNum);
				break;
			}
			else if(cardName.equals("Master Card"))
			{
				cards.selectByVisibleText("Master Card");
				String masterCardNum=(long)((rand.nextDouble()*10000000000000L)+6500000000000L)+"";
				driver.findElement(cardcvv).sendKeys(masterCardNum);
				break;
			}
			else if (cardName.equals("American Express") )
			{
				cards.selectByVisibleText("American Express");
				String amaericanExCardNumber=(long) ((rand.nextDouble() * 100000000000000L) + 3200000000000000L)+"";
				driver.findElement(By.id("cid")).sendKeys(amaericanExCardNumber);
				break;
			}
		}
			
			Select month =new Select(driver.findElement(cardMonth));
			month.selectByValue("06");
			System.out.println(month);
			Select year= new Select(driver.findElement(cardYear));
			year.selectByValue("2021");
			System.out.println(year);
			String cvvValue= rand.nextInt(1000)+"";	
			driver.findElement(cardcvv).sendKeys(cvvValue);
		}
		
			public void clickOnSubmitBtn()
			{
			driver.findElement(submitBtn).click();
			}
			
			public void payFees(String fees){
				navigateToPay();
				
				selectPayment(fees);
				cardInfo();
				clickOnSubmitBtn();
			}

			
		
	
		
	}
	
	



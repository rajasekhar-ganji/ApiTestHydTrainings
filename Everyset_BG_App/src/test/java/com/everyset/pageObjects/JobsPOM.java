package com.everyset.pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.everyset.testcases.BaseClass;
import com.everyset.utilities.ReadingFiles_Utils;
import com.everyset.utilities.HelperClass;
import com.everyset.utilities.Constant_Paths;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobsPOM extends BaseClass{
	
	// Login module
	@FindBy(id = "signIn_email")
	WebElement email;
	@FindBy(id = "signIn_password")
	WebElement password;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;
	//Success message
	@FindBy(xpath = "//*[@class='ant-message-notice-content']")
	WebElement successmessage;
	
	
	
	
	//Notification Count
		@FindBy(xpath = "")
		WebElement NotificationCount;

	// Invites page
	@FindBy(xpath = "//*[text()='Invited']//parent::td//parent::tr/td[2]")
	List<WebElement> invites;
	
	@FindBy(id = "submit-to-job-btn")
	WebElement submitbuttoninInvites;
	
	
	// Submit to Job
	@FindBy(xpath = "//*[text()='Cancel']//parent::button//following-sibling::button")
	WebElement submittojobbuttoninpopup;
	
	
	@FindBy(id = "AppQ1")
	List<WebElement> textbox1;
	
	
	//Unvailable page
	@FindBy(xpath = "//*[text()='Unavailable']")
	WebElement Unavailble;
	
	@FindBy(id = "CQ3")
	WebElement textbox2;
	
	@FindBy(xpath = "//*[text()='I am Available']")
	WebElement Iamavailblebutton;
	
	
	//Available page
	@FindBy(xpath = "//*[text()='Available']")
	WebElement Available;

	
	@FindBy(xpath ="//button[text()='No Longer Available']") 
	WebElement nolongeravailablebutton;
	
	
	
	
	
	
	
	// Avail Checks page
	@FindBy(xpath = "//*[text()='Avail Checks']")
	WebElement Availchecks;

	
	
	
	
	
	
	
	// Booked tabs bar
	@FindBy(xpath = "//*[text()='Bookings']")
	WebElement Booked;
	
	
	
	
	
	
	
	
	
	//profile pic
	@FindBy(xpath = "//*[@id='__next']/main/header/section[3]")
	WebElement profile;
	
	//my account
	@FindBy(xpath = "//*[text()='My Account']")
	WebElement myaccount;

	
	
	
	@FindBy(xpath = "//*[@class='ant-btn css-cs932n ant-btn-default sc-99f86f4e-19 fwRgHk']")
	List<WebElement> photoUploadbutton;

	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div[1]/div[3]/form/div[1]/div/div/div/div/div/div/div/div/div/div/div[3]/img[1]")
	WebElement photodelete;

	
	@FindBy(xpath = "//*[@class='ant-btn css-cs932n ant-btn-primary sc-99f86f4e-24 hJhlwM']")
	WebElement UpdateToUnavailable;
	
	@FindBy(xpath = "//*[@class='ant-badge ant-badge-not-a-wrapper Badge css-cs932n']")
	WebElement ValidationforStatusBadges;
	
	
	
	public JobsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login() {
		log.info("Everyset app statred");
		email.sendKeys(ReadingFiles_Utils.ConnectPropertyFile("username"));
		log.info("User name entered successfully");
		password.sendKeys(ReadingFiles_Utils.ConnectPropertyFile("password"));
		log.info("Password entered successfully");
		loginButton.click();
		HelperClass.TimeOut(5000);
		log.info("Clicked on login button");
		HelperClass.waitforElement(successmessage);
		String msg=successmessage.getText();
		log.info("Message========>  "+msg);
		log.info("Login Successfully");
		
	}
	
	//Invites page
	public void invites() throws Exception {
		log.info("Before Clicked on Invites");
	HelperClass.waitforElements(invites);
		for(WebElement e:invites) {
			if(e.getText().trim().equalsIgnoreCase("App + No Sizes + No App Questions + Custom Questions"))
			{
			Thread.sleep(2000);
			e.click();
		}	
		}		
		Thread.sleep(5000);
		submitbuttoninInvites.click();
		log.info("Clicked on submit to job successfully");
		Thread.sleep(2000);
		Boolean result=submittojobbuttoninpopup.isEnabled();
		System.out.println(result);
		if(submittojobbuttoninpopup.isEnabled()==false) {
			if(textbox1.size()>0) {
			textbox1.get(0).sendKeys("raj");
			}
				
			textbox2.sendKeys("aa");
				Thread.sleep(2000);
			}
			
		if(photoUploadbutton.size()>0) {
			String [] photoArray = {Constant_Paths.Car1, Constant_Paths.Car2, Constant_Paths.Car3, Constant_Paths.Car4, Constant_Paths.Car5};
			for (int i = 0; i < photoArray.length; i++) {
				if(submittojobbuttoninpopup.isEnabled()==false)
				{
				HelperClass.PhotoUpload(photoUploadbutton.get(0), photoArray[i]);
			    }
			}
			}
		
		else {
			//submittojobbuttoninpopup.click();
		}
	
}

	//Unavailable
	public void unavailable() throws Exception {
		HelperClass.waitforElement(Unavailble);
		Unavailble.click();
		Thread.sleep(5000);
		Iamavailblebutton.click();
		Assert.assertFalse(submittojobbuttoninpopup.isEnabled());	
		textbox2.sendKeys("RAJ");
		Assert.assertTrue(submittojobbuttoninpopup.isEnabled());	
		submittojobbuttoninpopup.click();
		Thread.sleep(5000);
		Assert.assertEquals(ValidationforStatusBadges.getText(),"Available");
	}	
	//Available
	public void available() throws Exception {
		HelperClass.waitforElement(Available);
		Available.click();
		Thread.sleep(5000);
		nolongeravailablebutton.click();
		Thread.sleep(5000);
		UpdateToUnavailable.click();
		Thread.sleep(5000);
		Assert.assertEquals(ValidationforStatusBadges.getText(),"Unavailable");
		
	}

//String s=NotificationCount.getText();
//System.out.println(s);
//		
//		Thread.sleep(4000);
//		photoUploadbutton.click();
//		Thread.sleep(4000);
//		HelperClass.StringSelection(HelperClass.photo1);
//		HelperClass.Robot();
//		Thread.sleep(10000);
//		photoUploadbutton.click();
//		Thread.sleep(4000);
//		HelperClass.StringSelection(HelperClass.photo2);
//		HelperClass.Robot();
//		Thread.sleep(10000);
//		photoUploadbutton.click();
//		Thread.sleep(4000);
//		HelperClass.StringSelection(HelperClass.photo3);
//		HelperClass.Robot();
//		Thread.sleep(4000);
//		photodelete.click();
	
	public void searchBox(String data) {
		textbox2.sendKeys(data);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void availchecksTab() {
		Availchecks.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void BookedTab() {
		Booked.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void invitesTab() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void selectprofile() {
		profile.click();
	}
	
	
	public void ProfileIcon() {
//		a = new Actions(driver);
//		a.clickAndHold(profile).perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		myaccount.click();
	}

}

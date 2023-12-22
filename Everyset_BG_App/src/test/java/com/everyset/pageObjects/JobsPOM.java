package com.everyset.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
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
import com.everyset.utilities.ExtentReportwithScreenshot_Util;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JobsPOM {
	private WebDriver driver;
	public static Logger log = Logger.getLogger(JobsPOM.class);
	// Login module
	@FindBy(id = "signIn_email")
	WebElement email;
	@FindBy(id = "signIn_password")
	WebElement password;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement loginButton;

	// Success message
	@FindBy(xpath = "//*[@class='ant-message-notice-content']")
	WebElement successmessage;

	// Photo upload button
	@FindBy(xpath = "//*[text()='Drag and drop files here or click to upload.']//parent::button")
	List<WebElement> UploadButton;

	@FindBy(xpath = "//input[@type='text']")
	List<WebElement> Textbox;

	@FindBy(xpath = "//*[@type='search']//parent::span//parent::div")
	List<WebElement> Dropdown;
	// Notification Count
	@FindBy(xpath = "//*[text()='Action Required']//following-sibling::span")
	WebElement NotificationCount;

	// Invites page
	@FindBy(xpath = "//*[text()='Invites']")
	WebElement InvitesTab;

	@FindBy(xpath = "//*[text()='Invited']//parent::td//parent::tr")
	List<WebElement> invites_jobs;

	@FindBy(id = "submit-to-job-btn")
	WebElement submittojobbutton_invites;

	// Submit to Job
	@FindBy(xpath = "//*[text()='Cancel']//parent::button//following-sibling::button")
	WebElement submittojob_button;

	// Unvailable page
	@FindBy(xpath = "//*[text()='Unavailable']//parent::td//parent::tr")
	List<WebElement> Unavailble_jobs;

	@FindBy(xpath = "//*[text()='I am Available']")
	WebElement Iamavailble_button;

	// Available page

	@FindBy(xpath = "//*[text()='Available']//parent::td//parent::tr")
	List<WebElement> Available_jobs;

	@FindBy(xpath = "//button[text()='No Longer Available']")
	WebElement nolongeravailable_button;

	// Avail Checks page
	@FindBy(xpath = "//*[text()='Avail Checks']")
	WebElement AvailchecksTab;

	@FindBy(xpath = "//*[text()='Avail Check']//parent::td//parent::tr")
	List<WebElement> Availcheck_jobs;

	@FindBy(xpath = "//*[text()='Avail Confirmed']//parent::td//parent::tr")
	List<WebElement> AvailConfirmed_jobs;

	@FindBy(xpath = "//*[@class='sc-dcd01160-8 xrBEF']")
	WebElement AvailConfirmed_card;

	@FindBy(xpath = "//*[text()='Released']//parent::td//parent::tr")
	List<WebElement> Released_jobs;

	@FindBy(xpath = "//*[text()='Denied']//parent::td//parent::tr")
	List<WebElement> Denied_jobs;

	// Booked tabs bar
	@FindBy(xpath = "//*[text()='Bookings']")
	WebElement BookingsTab;

	@FindBy(xpath = "//*[text()='Booked']//parent::td//parent::tr")
	List<WebElement> Booked_jobs;
	@FindBy(xpath = "//*[text()='Canceled']//parent::td//parent::tr")
	List<WebElement> Canceled_jobs;

	@FindBy(xpath = "//*[text()='No Show']//parent::td//parent::tr")
	List<WebElement> NoShow_jobs;

	@FindBy(xpath = "//*[text()='Canceled w/ Pay']//parent::td//parent::tr")
	List<WebElement> CanceledwithPay_jobs;

	@FindBy(xpath = "//*[text()='CLICK HERE TO SEE YOUR DETAILS']")
	WebElement CLICKHERETOSEEYOURDETAILS;
	@FindBy(xpath = "//*[text()='I acknowledge I am booked']//parent::button")
	WebElement IamBooked_button;
	@FindBy(xpath = "//*[@id='Signature']")
	WebElement Signature_textbox;
	@FindBy(xpath = "//*[@alt='Tick Icon']")
	List<WebElement> BookedwithTick_jobs;
	@FindBy(xpath = "//*[@id='booking-faqs-btn']")
	WebElement BookingFAQS_button;
	@FindBy(xpath = "//*[text()='Close']//parent::button")
	WebElement Close_button;

	// profile pic
	@FindBy(xpath = "//*[@class='sc-fad91bf7-0 kFShvP']")
	WebElement profile;

	// my account
	@FindBy(xpath = "//*[text()='My Account']")
	WebElement myaccount;
	
	@FindBy(xpath = "//button[text()='Log Out']")
	WebElement logout;

	
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
		
		String username=ReadingFiles_Utils.ConnectPropertyFile("username");
		String pwd=ReadingFiles_Utils.ConnectPropertyFile("password");
		
		log.info("Everyset app statred");
		email.sendKeys(username);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("User name entered successfully");
		password.sendKeys(pwd);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Password entered successfully");
		loginButton.click();
		HelperClass.TimeOut(5000);
		log.info("Clicked on login button");
		HelperClass.waitforElement(successmessage);
		String msg = successmessage.getText();
		log.info("Message========>  " + msg);
		Assert.assertEquals(driver.getTitle(), ReadingFiles_Utils.ConnectPropertyFile("page_title"));
		System.out.println(driver.getTitle());
		log.info("Login Successfully");

	}

	// Success message Validation
	public void ValidationofSuccessMessage(String ExpectedMessage) {
		HelperClass.waitforElement(successmessage);
		String Expected = ExpectedMessage;
		String Actual = successmessage.getText();
		log.info("Success message========>  " + Actual);
		Assert.assertEquals(Actual, Expected);
	}

	// Invites page
	public void invites() throws Exception {
		HelperClass.waitforElements(invites_jobs);
		System.out.println(invites_jobs.size());
		if (invites_jobs.size() > 0) {
			log.info("Before Clicked on Invites");
			WebElement e = invites_jobs.get(5);
			e.click();
			Thread.sleep(5000);
			submittojobbutton_invites.click();
			log.info("Clicked on submit to job successfully");
			Thread.sleep(2000);
			Boolean result = submittojob_button.isEnabled();
			System.out.println(result);
			if (result == false) {
				log.info("Clicked job successfully");
				if (Dropdown.size() > 0) {
					for (int i = 0; i < Dropdown.size(); i++) {
						Dropdown.get(i).click();
						HelperClass.DownArrowAction();
						Dropdown.get(i).click();
					}
				}
				if (Textbox.size() > 0) {
					for (WebElement text_Box : Textbox) {
						text_Box.sendKeys("Answered");
						HelperClass.TimeOut(3000);
					}
				}

				if (UploadButton.size() > 0) {
					for (int i = 0; i < UploadButton.size(); i++) {
						String[] photoArray = { Constant_Paths.Car1, Constant_Paths.Car2, Constant_Paths.Car3,
								Constant_Paths.Car4, Constant_Paths.Car5 };
						for (int j = 0; j < photoArray.length; j++) {
							if (UploadButton.get(i).isEnabled() == true) {
								HelperClass.PhotoUpload(UploadButton.get(i), photoArray[j]);
							}
						}
					}
				}
				// submittojob_button.click();
			}
			log.info("Submit to job Enabled Already");
			// submittojob_button.click();

		} else {
			log.info("Invites jobs not found");
		}
	}

	// Unavailable
	public void unavailable() throws Exception {
		HelperClass.waitforElements(Unavailble_jobs);
		// if(Unavailble_jobs.size()>0) {
		
		Unavailble_jobs.get(5).click();
		Thread.sleep(5000);
		Iamavailble_button.click();
		Assert.assertFalse(submittojob_button.isEnabled());
		Assert.assertTrue(submittojob_button.isEnabled());
		// submittojob_button.click();
		Thread.sleep(5000);
		Assert.assertEquals(ValidationforStatusBadges.getText(), "Available");
		Logout();
	}

//		else {
//			log.info("Unavailable jobs not found");
//		}
//	}
	// Available
	public void available() throws Exception {
		log.info("test into available");
		//HelperClass.waitforElements(Available_jobs);
		HelperClass.TimeOut(15000);
		HelperClass.ScrollDown();
		HelperClass.TimeOut(5000);
		System.out.print(Available_jobs.size());
		Assert.assertTrue(false);
		if (Available_jobs.size() > 0) {
			log.info("test into available jobs");
			Available_jobs.get(10).click();
			nolongeravailable_button.click();
			Thread.sleep(5000);
			UpdateToUnavailable.click();
			Thread.sleep(5000);
			Assert.assertEquals(ValidationforStatusBadges.getText(), "Unavailable");
			
		} else {
			log.info("Available jobs not found");
		}
	}

	public void availchecksTab() {
		log.info("test into availchecks");
		HelperClass.ElementToBeClickable(AvailchecksTab);
		HelperClass.MouseHoverAndClick(AvailchecksTab);
		HelperClass.TimeOut(10000);
		HelperClass.ScrollDown();
		HelperClass.TimeOut(5000);
		Assert.assertTrue(false);
 		//HelperClass.waitforElements(Availcheck_jobs);
		System.out.println(Availcheck_jobs.size());
		if (Availcheck_jobs.size() > 0) {
			log.info("test into availchecks jobs");
			WebElement e = Availcheck_jobs.get(5);
			e.click();
			
		} else {
			log.info("Avail Checks jobs not found");
		}
	}

	public void availconfirmed() {
		if (Availcheck_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(AvailchecksTab);
			AvailchecksTab.click();
			HelperClass.waitforElements(AvailConfirmed_jobs);
			System.out.println(AvailConfirmed_jobs.size());
			WebElement e = AvailConfirmed_jobs.get(0);
			e.click();
		} else {
			log.info("Avail Confirmed jobs not found");
		}
	}

	public void DeniedJobs() {
		if (Denied_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(AvailchecksTab);
			AvailchecksTab.click();
			HelperClass.waitforElements(Denied_jobs);
			System.out.println(Denied_jobs.size());
			WebElement e = Denied_jobs.get(0);
			e.click();
		} else {
			log.info("Denied jobs not found");
		}
	}

	public void ReleasedJobs() {
		if (Released_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(AvailchecksTab);
			AvailchecksTab.click();
			HelperClass.waitforElements(Released_jobs);
			System.out.println(Released_jobs.size());
			WebElement e = Released_jobs.get(0);
			e.click();
		} else {
			log.info("Released jobs not found");
		}
	}

	public void BookedTab() {
		log.info("test into bookings");
		HelperClass.TimeOut(5000);
		HelperClass.ElementToBeClickable(BookingsTab);
		BookingsTab.click();
		HelperClass.TimeOut(5000);
		HelperClass.ScrollDown();
		HelperClass.TimeOut(5000);
		//HelperClass.waitforElements(Booked_jobs);
		System.out.println(Booked_jobs.size());
		if (Booked_jobs.size() > 0) {
			log.info("test into bookings jobs");
			WebElement e = Booked_jobs.get(20);
			e.click();
			HelperClass.TimeOut(5000);
			CLICKHERETOSEEYOURDETAILS.click();
			System.out.println(IamBooked_button.isEnabled());
			Signature_textbox.sendKeys("raj");
			System.out.println(IamBooked_button.isEnabled());
			// IamBooked_button.click();
			// ValidationofSuccessMessage("Status Updated Successfully");
		} else {
			log.info("Booked jobs not found");
		}
	}

	public void BookedWithTick() {
		HelperClass.ElementToBeClickable(BookingsTab);
		BookingsTab.click();
		HelperClass.waitforElements(BookedwithTick_jobs);
		System.out.println(BookedwithTick_jobs.size());
		if (BookedwithTick_jobs.size() > 0) {
			BookedwithTick_jobs.get(5).click();
			HelperClass.TimeOut(3000);
			BookingFAQS_button.click();
			HelperClass.TimeOut(3000);
			String pageSource = driver.getPageSource();
			String expectedText = "What is “Call Time”?";
			Assert.assertTrue(pageSource.contains(expectedText), "Text content not found in the page");
			Close_button.click();
		} else {
			log.info("BookedwithTick jobs not found");
		}
	}

	public void NoShowJobs() {
		if (NoShow_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(BookingsTab);
			BookingsTab.click();
			HelperClass.waitforElements(NoShow_jobs);
			System.out.println(NoShow_jobs.size());
			WebElement e = NoShow_jobs.get(0);
			e.click();
		} else {
			log.info("Noshow jobs not found");
		}
	}

	public void CanceledJobs() {
		if (Canceled_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(BookingsTab);
			BookingsTab.click();
			HelperClass.waitforElements(Canceled_jobs);
			System.out.println(Canceled_jobs.size());
			WebElement e = Canceled_jobs.get(0);
			e.click();
		} else {
			log.info("Canceled jobs not found");
		}
	}

	public void CanceledWithPayJobs() {
		if (CanceledwithPay_jobs.size() > 0) {
			HelperClass.ElementToBeClickable(BookingsTab);
			BookingsTab.click();
			HelperClass.waitforElements(CanceledwithPay_jobs);
			System.out.println(CanceledwithPay_jobs.size());
			WebElement e = CanceledwithPay_jobs.get(0);
			e.click();
		} else {
			log.info("CanceledwithPay jobs not found");
		}
	}

	public void selectprofile() {
		profile.click();
	}

	public void Logout() {
		HelperClass.ClickonElement(myaccount);
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(logout);
		HelperClass.TimeOut(3000);
}
}
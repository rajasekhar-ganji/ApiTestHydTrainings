package com.everyset.pageObjects;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.everyset.testcases.BaseClass;
import com.everyset.utilities.ReadingFiles_Utils;
import com.everyset.utilities.HelperClass;
import com.everyset.utilities.TestDataProvider;

public class MyProfilePOM extends BaseClass {
	// Login module
		@FindBy(id = "signIn_email")
		WebElement email;
		@FindBy(id = "signIn_password")
		WebElement password;
		@FindBy(xpath = "//*[@type='submit']")
		WebElement loginButton;
		
	@FindBy(xpath = "//*[text()='My Profile']/parent::li")
	WebElement MyProfilebutton;

	@FindBy(xpath = "//*[@class='ant-message-notice-content']")
	WebElement successmessage;
	@FindBy(xpath = "//*[@class='ant-modal-close-x']")
	WebElement closewindow;
	
	@FindBy(xpath = "//*[@class='sc-11b131b1-0 iDAWJF']")
	WebElement MyProfile;
	@FindBy(xpath = "//*[@class='sc-11b131b1-5 bImojE']")
	WebElement MyProfileData;
	
	@FindBy(xpath = "//*[@class='ant-avatar ant-avatar-lg ant-avatar-circle css-cs932n']")
	List<WebElement> NoProfilePicture;
	
	@FindBy(xpath = "//*[@class='sc-11b131b1-2 OZMXP']")
	List<WebElement> ProfilePicture;

	@FindBy(xpath = "//*[@class='sc-11b131b1-25 jMKyhK']")
	List<WebElement> AllProfilePhotos;

	@FindBy(xpath = "//*[@class='sc-11b131b1-6 hntrhS']")
	List<WebElement> ChangeProfile;

	@FindBy(xpath = "//*[@class='ant-scroll-number ant-badge-count ant-badge-multiple-words']")
	WebElement Badge;
	
	@FindBy(xpath = "//*[@class='ant-card ant-card-bordered sc-11b131b1-13 cJavQV css-cs932n']")
	List<WebElement> MyProfileOptions;

	@FindBy(xpath = "//*[@class='sc-11b131b1-7 kRXlAm']")
	WebElement ViewPhotos;
	@FindBy(xpath = "//*[@class='sc-11b131b1-17 cRRIsP']")
	List<WebElement> AllPhotos;

	// General info
	@FindBy(xpath = "//*[text()='General Information']")
	WebElement GeneralInformation;
	@FindBy(xpath = "//*[text()='General Information']//following-sibling::div")
	WebElement Generalinfoediticon;
	@FindBy(xpath = "//*[text()='General Information']//following-sibling::img[1]")
	WebElement Generalinfogreentick;

	@FindBy(id = "StepOne_firstName")
	WebElement firstname;
	@FindBy(id = "StepOne_lastName")
	WebElement lastname;
	@FindBy(id = "StepOne_stageName")
	WebElement stagename;
	@FindBy(xpath = "//*[text()='Call In Service']//following::div[1]")
	WebElement Callinservice;
	@FindBy(xpath = "//*[text()='Minor?']//following::div[1]")
	WebElement MajorandMinorAgeClick;
	@FindBy(xpath = "//*[text()='No - I am 18 or older']")
	WebElement Mazor;
	@FindBy(xpath = "//*[text()='Yes - I am under 18']")
	WebElement Minor;
	@FindBy(css = "input#StepOne_minAge")
	WebElement minAge;
	@FindBy(css = "input#StepOne_maxAge")
	WebElement maxAge;
	@FindBy(xpath = "//*[text()='Birthday (MM/DD/YYYY)']//following::div[5]/input")
	WebElement dateofbirth;
	@FindBy(xpath = "//*[text()='Union Status']//following::div[1]")
	WebElement unionstatus;
	@FindBy(xpath = "//*[@id='StepOne_unionId']")
	WebElement sagaftraid;

//Contact 
	@FindBy(xpath = "//*[text()='Contact']")
	WebElement Contact;
	@FindBy(xpath = "//div[text()='Contact']//following-sibling::div")
	WebElement contactediticon;
	@FindBy(xpath = "//div[text()='Contact']//following-sibling::img[1]")
	WebElement contactgreentick;

	@FindBy(id = "StepOne_phoneNumber")
	WebElement phonenumber;
	@FindBy(id = "StepTwo_addresslLane1")
	WebElement Residential_address;
	@FindBy(id = "StepTwo_addressLane2")
	WebElement Residential_address2;
	@FindBy(id = "StepTwo_residentialCity")
	WebElement Residential_city;
	@FindBy(xpath = "//*[@id='StepTwo_residentialState']")
	WebElement Residential_state;
	@FindBy(id = "StepTwo_residentialZipCode")
	WebElement Residential_zipcode;

	@FindBy(xpath = "//*[text()='Same as Residential Address']//preceding-sibling::span")
	WebElement checkbox;
	@FindBy(xpath = "//input[@class='ant-checkbox-input']")
	WebElement checkedbox;

	@FindBy(id = "StepTwo_mailingAddress")
	WebElement Mailing_address;
	@FindBy(id = "StepTwo_Address Line 2")
	WebElement Mailing_address2;
	@FindBy(id = "StepTwo_mailingCity")
	WebElement Mailing_city;
	@FindBy(xpath = "//*[@id='StepTwo_mailingState']")
	WebElement Mailing_state;
	@FindBy(id = "StepTwo_mailingZipCode")
	WebElement Mailing_zipcode;
//Appearance
	@FindBy(xpath = "//*[text()='Appearance']")
	WebElement appearance;
	@FindBy(xpath = "//div[text()='Appearance']//following-sibling::div")
	WebElement appearanceediticon;
	@FindBy(xpath = "//div[text()='Appearance']//following-sibling::img[1]")
	WebElement appearancegreentick;
	@FindBy(xpath = "//*[text()='Gender']//following-sibling::div[1]")
	WebElement gender;
	@FindBy(xpath = "//*[text()='Height']//following-sibling::div[1]")
	WebElement height;
	@FindBy(xpath = "//*[text()='Weight']//following-sibling::div[1]")
	WebElement weight;
	@FindBy(xpath = "//*[text()='Primary Portrayable Ethnicity']//following-sibling::div[1]")
	WebElement PrimaryPortrayableEthnicity;
	@FindBy(xpath = "//*[text()='Additional Portrayable Ethnicity']//following-sibling::div[1]")
	WebElement AdditionalPortrayableEthnicity;
	@FindBy(xpath = "//*[text()='Body Type']//following-sibling::div[1]")
	WebElement bodytype;
	@FindBy(xpath = "//*[text()='Hair Length']//following-sibling::div[1]")
	WebElement hairlength;
	@FindBy(xpath = "//*[text()='Hair Color']//following-sibling::div[1]")
	WebElement haircolor;
	@FindBy(xpath = "//*[text()='Eye Color']//following-sibling::div[1]")
	WebElement eyecolor;
//Wardrobe 
	@FindBy(xpath = "//*[text()='Wardrobe']")
	WebElement wardrobe;
	@FindBy(xpath = "//div[text()='Wardrobe Measurements']//following-sibling::div")
	WebElement wardrobeediticon;
	@FindBy(xpath = "//div[text()='Wardrobe Measurements']//following-sibling::img[1]")
	WebElement Wardrobegreentick;
	@FindBy(xpath = "//*[text()='Dress']//following-sibling::div[1]")
	WebElement dress;
	@FindBy(xpath = "//*[@id='StepOne_coat/chest']")
	WebElement coat;
	@FindBy(xpath = "//*[@id='StepOne_neck']")
	WebElement neck;
	@FindBy(xpath = "//*[@id='StepOne_hips']")
	WebElement hips;
	@FindBy(xpath = "//*[@id='StepOne_sleeve']")
	WebElement sleeve;
	@FindBy(xpath = "//*[@id='StepOne_inseam']")
	WebElement inseam;
	@FindBy(xpath = "//*[@id='StepOne_waist']")
	WebElement waist;
	@FindBy(xpath = "//*[@id='StepOne_pant']")
	WebElement pant;
	@FindBy(xpath = "//*[@id='StepOne_bust/band']")
	WebElement bust;
	@FindBy(xpath = "//*[text()='Cup']//following::div[1]")
	WebElement cup;
	@FindBy(xpath = "//*[text()='Shirt']//following::div[1]")
	WebElement shirt;
	@FindBy(xpath = "//*[text()='Shoe']//following::div[1]")
	WebElement shoe;
	@FindBy(xpath = "//*[text()='Hat']//following::div[1]")
	WebElement hat;

//Skills and Props
	@FindBy(xpath = "//*[text()='Skills']")
	WebElement Skills;
	@FindBy(xpath = "//*[text()='Props']")
	WebElement Props;
	
	@FindBy(xpath = "//*[@class='sc-ee372ebb-11 iuqfEv']/div[2]")
	WebElement SkillsEditbutton;

	@FindBy(xpath = "//*[@class='sc-9c0457ac-12 eUJXwR']/div[2]")
	WebElement Propsediticon;

	@FindBy(xpath = "//*[@class='sc-d98f9bf1-3 gkoqHi']")
	WebElement Skills_Props_GreenTick;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable sc-ee372ebb-14 ebdlTy css-cs932n']")
	List<WebElement> Allskills;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable sc-9c0457ac-15 iguvQi css-cs932n']")
	List<WebElement> Allprops;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-ee372ebb-14 bDZWyC css-cs932n']")

	List<WebElement> deselectSkillname;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-ee372ebb-14 bDZWyC css-cs932n']/span")
	List<WebElement> deselectSkill;

	@FindBy(xpath = "//*[@class='anticon anticon-close sc-9c0457ac-17 hjSqjz']/parent::span")
	List<WebElement> deselectPropname;

	@FindBy(xpath = "//*[@class='anticon anticon-close sc-9c0457ac-17 hjSqjz']")
	List<WebElement> deselectProp;

//Vehicles
	@FindBy(xpath = "//*[text()='Vehicles']")
	WebElement vehicles;
	@FindBy(xpath = "//*[@class='sc-2a2c929-2 faUKWS']//following-sibling::div")
	WebElement vehiclesAdd;
	@FindBy(xpath = "//*[text()='Make']//following-sibling::div[1]")
	WebElement make;
	@FindBy(xpath = "//*[text()='Model']//following-sibling::div[1]")
	WebElement model;
	@FindBy(xpath = "//*[text()='Year']//following-sibling::div[1]")
	WebElement year;
	@FindBy(xpath = "//*[text()='Color']//following-sibling::div[1]")
	WebElement color;
	@FindBy(xpath = "//*[text()='Condition']//following-sibling::div[1]")
	WebElement condition;
	@FindBy(xpath = "//*[text()='Type']//following-sibling::div[1]")
	WebElement type;
	@FindBy(xpath = "//*[@class='ant-btn css-cs932n ant-btn-default sc-d9e00700-7 QteOy']")
	WebElement AddvehiclePhotoUpload;
	@FindBy(xpath = "//*[@class='ant-btn css-cs932n ant-btn-default sc-3d172c4-7 hVzuQB']")
	WebElement EditvehiclePhotoUpload;

	@FindBy(xpath = "//*[@class='sc-d9e00700-8 dLmCkp']")
	WebElement greentick;
	@FindBy(xpath = "//*[@class='sc-3d172c4-8 liIWuC']")
	WebElement edit_greentick;

	@FindBy(xpath = "//*[@class='sc-2a2c929-12 gXaQJZ']")
	List<WebElement> AllsavedVehicle;

	@FindBy(xpath = "//*[@class='sc-2a2c929-12 gXaQJZ']//following-sibling::div")
	List<WebElement> editVehicleIcons;

	@FindBy(xpath = "//*[text()='Delete Vehicle']")
	WebElement DeleteVehicle;
	@FindBy(xpath = "//*[@class='sc-3d172c4-14 iDdcmO']")
	List<WebElement> DeleteCarimage;

//Photos
	@FindBy(xpath = "//a[text()='View Photos']")
	WebElement Photos;
	@FindBy(xpath = "//*[@class='sc-f1092a9c-2 esnEyZ']")
	WebElement UploadButton;
	@FindBy(xpath = "//*[@class='ant-btn css-cs932n ant-btn-primary']")
	WebElement PhotoUploadButton;
	@FindBy(xpath = "//div[@class='sc-f1092a9c-4 cQGktF']")
	List<WebElement> PhotoCount;
	@FindBy(xpath = " //*[text()='Edit Photo']")
	WebElement EditPhoto;

	@FindBy(xpath = "//*[text()='Make Profile Picture']")
	WebElement Makeprofilepic;
	@FindBy(xpath = "//*[text()='Delete']")
	WebElement deletePhoto;

	@FindBy(xpath = "//*[text()='Save']")
	WebElement Save;

	@FindBy(xpath = "//*[text()='Rotate']")
	WebElement rotate;
	@FindBy(xpath = "//*[text()='Crop']")
	WebElement crop;

	@FindBy(xpath = "//*[@class='right-section-container']/div")
	WebElement cropArea;

	// Constructor
	
	public MyProfilePOM(WebDriver driver) {
		BaseClass.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login() {
		log.info("Everyset app statred");
		HelperClass.waitforElement(email);
		HelperClass.Senddataforlogin(email, ReadingFiles_Utils.ConnectPropertyFile("username"));
		log.info("User name entered successfully");
		
		HelperClass.Senddataforlogin(password, ReadingFiles_Utils.ConnectPropertyFile("password"));
		log.info("Password entered successfully");
		loginButton.click();
		log.info("Clicked on login button");
		HelperClass.waitforElement(successmessage);
		String msg=successmessage.getText();
		log.info("Message========>  "+msg);
		Assert.assertEquals(driver.getTitle(), "Jobs | Everyset");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		log.info("Login Successfully");
		
	}
	
	// My Profile
	public void MyProfileSelection() {
		log.info("Everyset landing page Displayed");
		HelperClass.ClickonMyProfileElement(MyProfilebutton);
		log.info("My Profile main page Displayed");
	}

	public void MyProfileMainPage(String function, String choosePhotobyIndex) {
		HelperClass.waitforElement(MyProfile);
		Assert.assertTrue(MyProfile.isDisplayed());
		log.info("My Profile text displayed==> " + MyProfile.getText());
		HelperClass.waitforElement(MyProfileData);
		Assert.assertTrue(MyProfileData.isDisplayed());
		HelperClass.waitforElement(Badge);
		Assert.assertTrue(Badge.isDisplayed());
		log.info("Badge Name displayed==> " + Badge.getText());
		System.out.println("My profile options diplayed==> ");
		for (WebElement e : MyProfileOptions) {
			Assert.assertTrue(e.isDisplayed());
			Assert.assertTrue(e.isEnabled());
			System.out.print(e.getText()+", ");
		}
		HelperClass.waitforElement(ViewPhotos);
		Assert.assertTrue(ViewPhotos.isDisplayed());
		Assert.assertTrue(ViewPhotos.isEnabled());
		System.out.println();
		log.info("View photos text displayed==> " + ViewPhotos.getText());
		for (WebElement e : AllPhotos) {
		Assert.assertTrue(e.isDisplayed());
		}
		if (function.equals("ProfilePicture")) {
				if(ProfilePicture.size()>0) {
					HelperClass.performProfilePictureAction(ProfilePicture);
					log.info("Clicked on Profile picture succesfully");
				}
				
	        else if(NoProfilePicture.size()>0) {
			HelperClass.performProfilePictureAction(NoProfilePicture);
			log.info("Clicked on No Profile picture succesfully");
			}	
				if(AllProfilePhotos.size()>0) {
			HelperClass.SelectPhoto(AllProfilePhotos, choosePhotobyIndex);
			log.info("Profile picture selected succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
			log.info("Profile picture saved succesfully");
				}
				else {
					HelperClass.ClickonElement(closewindow);
					log.info("No Profile pictures in window and close the window");
				}
			
		} else if (function.equals("ChangeProfile")) {
			HelperClass.performProfilePictureAction(ChangeProfile);
			log.info("Clicked on Change Profile picture linktext succesfully");
			if(AllProfilePhotos.size()>0) {
			HelperClass.SelectPhoto(AllProfilePhotos, choosePhotobyIndex);
			log.info("Profile picture selected succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
			log.info("Profile picture saved succesfully");
			}
			else {
					HelperClass.ClickonElement(closewindow);
					log.info("No Profile pictures in window and close the window");
				}
			
			}
		}
	

	// General Information
	public void GeneralInformation(String firstName, String lastName, String stageName, String Callingserve,
			String MinorOrMazor, String minage, String maxage, String Dob, String UnionstatusName, String Sagid)
			throws Exception {
		HelperClass.ClickonMyProfileElement(GeneralInformation);
		log.info("General Information page Displayed");
		HelperClass.MouseHoverAndClick(Generalinfoediticon);
		log.info("General Information Edit page displayed successfully when clicked on edit icon");
		HelperClass.Senddata(firstname, firstName);
		log.info("First name entered successfully");
		HelperClass.Senddata(lastname, lastName);
		log.info("Last name entered successfully");
		HelperClass.Senddata(stagename, stageName);
		log.info("Stage name entered successfully");
		HelperClass.SelectfromDropdown(Callinservice, Callingserve);
		log.info("CallinService selected successfully");
		HelperClass.ClickonElement(MajorandMinorAgeClick);
		System.out.println(MinorOrMazor);
		HelperClass.TimeOut(3000);
		if (MinorOrMazor.equals("Major")) {
			HelperClass.ClickonElement(Mazor);
			log.info("Major option selected successfully");
			HelperClass.Senddata(minAge, minage);
			log.info("Minimum Age entered successfully");
			HelperClass.Senddata(maxAge, maxage);
			HelperClass.ScrollDown();
			log.info("Maximum Age entered successfully");
		} else if (MinorOrMazor.equals("Minor")) {
			HelperClass.ClickonElement(Minor);
			log.info("Minor option selected successfully");
			HelperClass.Senddata(dateofbirth, Dob);
			log.info("Date of birth entered successfully");
		}
		HelperClass.SelectfromDropdown(unionstatus, UnionstatusName);
		log.info("Union status selected successfully");
		if (UnionstatusName.equalsIgnoreCase("SAG-AFTRA")) {
			HelperClass.Senddata(sagaftraid, Sagid);
			log.info("Sag-Aftra id entered successfully");
		}
		HelperClass.ScrollUp();
		log.info("Scroll up successfully");
		HelperClass.ClickonElement(Generalinfogreentick);
		log.info("Clicked on greentick successfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
		log.info("Data Saved successfully");
	}

	// Contact
	public void contact(String phone, String address_1, String Address_2, String Resi_city, String statename,
			String Zipcode, String MailingAddress, String Mailing_Address, String Mailing_Address_2,
			String Mailing_City, String Mailing_statename, String Mailing_Zipcode) throws Exception {
		HelperClass.ClickonMyProfileElement(Contact);
		log.info("Contact page Displayed");
		HelperClass.MouseHoverAndClick(contactediticon);
		log.info("Contact Edit page displayed successfully when clicked on edit icon");
		HelperClass.Senddata(phonenumber, phone);
		log.info("Phone number entered in text box succesfully");
		HelperClass.Senddata(Residential_address, address_1);
		log.info("Residential address entered in text box succesfully");
		HelperClass.Senddata(Residential_address2, Address_2);
		log.info("Address 2 entered in text box succesfully");
		HelperClass.Senddata(Residential_city, Resi_city);
		log.info("City entered in text box succesfully");
		HelperClass.Senddata(Residential_state, statename);
		log.info("State entered in text box");
		HelperClass.PressEnter();
		log.info("Selected state in dropdown succesfully");
		HelperClass.Senddata(Residential_zipcode, Zipcode);
		log.info("Zip code entered in text box succesfully");
		
		HelperClass.ScrollDown();
		if (MailingAddress.equalsIgnoreCase("Same")) {
			Assert.assertFalse(checkedbox.isSelected());
			System.out.println(checkedbox.isSelected());
			HelperClass.ClickonElement(checkbox);
			HelperClass.TimeOut(3000);
			System.out.println(checkedbox.isSelected());
			Assert.assertTrue(checkedbox.isSelected());
			log.info("Clicked checkbox succesfully");
		} else if (MailingAddress.equalsIgnoreCase("NotSame")) {
			HelperClass.Senddata(Mailing_address, Mailing_Address);
			log.info("Mailing address entered in text box succesfully");
			HelperClass.Senddata(Mailing_address2, Mailing_Address_2);
			log.info("Address 2 entered in text box succesfully");
			HelperClass.Senddata(Mailing_city, Mailing_City);
			log.info("City entered in text box succesfully");
			HelperClass.Senddata(Mailing_state, Mailing_statename);
			log.info("State entered in text box");
			HelperClass.PressEnter();
			log.info("Selected state in dropdown succesfully");
			HelperClass.Senddata(Mailing_zipcode, Mailing_Zipcode);
			log.info("Zip code entered in text box succesfully");
		}
		HelperClass.ScrollUp();
		log.info("Scroll up succesfully");
		HelperClass.ClickonElement(contactgreentick);
		log.info("Clicked on greetick successfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
		log.info("Data saved successfully");
	}

	// Wardrobe
	public void Wardrobe(String Gender, String Female_Dress, String Female_Hips, String Female_Waist,
			String Female_Pant, String Female_Bust, String Female_Cup, String Female_Shirt, String Female_Shoe,
			String Female_Hat, String Male_Coat, String Male_Neck, String Male_Sleeve, String Male_Waist,
			String Male_Inseam, String Male_Shirt, String Male_Shoe, String Male_Hat, String Nonbinary_Dress,
			String Nonbinary_Coat, String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips,
			String Nonbinary_Waist, String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust,
			String Nonbinary_Cup, String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat)
			throws Exception {
		HelperClass.ClickonMyProfileElement(wardrobe);
		log.info("Wardrobe page displayed successfully");
		HelperClass.MouseHoverAndClick(wardrobeediticon);
		log.info("Wardrobe Edit page displayed successfully when clicked on edit icon");
		if (Gender.equals("Female") || Gender.equals("Transgender Female")) {
			log.info("Gender selected Female or trans female");
			HelperClass.SelectfromDropdown(dress, Female_Dress);
			log.info("Selected Dress value in dropdown succesfully");
			HelperClass.Senddata(hips, Female_Hips);
			log.info("Hips value entered in text box succesfully");
			HelperClass.Senddata(waist, Female_Waist);
			log.info("Waist value entered in text box succesfully");
			HelperClass.Senddata(pant, Female_Pant);
			log.info("Pant value entered in text box succesfully");
			HelperClass.Senddata(bust, Female_Bust);
			log.info("Bust value entered in text box succesfully");
			HelperClass.ScrollDown();
			HelperClass.SelectfromDropdown(cup, Female_Cup);
			log.info("Selected Cup value in dropdown succesfully");
			HelperClass.SelectfromDropdown(shirt, Female_Shirt);
			log.info("Selected Shirt value in dropdown succesfully");
			HelperClass.SelectfromDropdown(shoe, Female_Shoe);
			log.info("Selected Shoe value in dropdown succesfully");
			HelperClass.SelectfromDropdown(hat, Female_Hat);
		} else if (Gender.equals("Male") || Gender.equals("Transgender Male")) {
			log.info("Gender selected Male or trans male");
			HelperClass.Senddata(coat, Male_Coat);
			log.info("Coat value entered in text box succesfully");
			HelperClass.Senddata(neck, Male_Neck);
			log.info("Neck value entered in text box succesfully");
			HelperClass.Senddata(sleeve, Male_Sleeve);
			log.info("Sleeve value entered in text box succesfully");
			HelperClass.Senddata(waist, Male_Waist);
			log.info("Waist value entered in text box succesfully");
			HelperClass.ScrollDown();
			HelperClass.Senddata(inseam, Male_Inseam);
			log.info("Inseam value entered in text box succesfully");
			HelperClass.SelectfromDropdown(shirt, Male_Shirt);
			log.info("Selected shirt value in dropdown succesfully");
			HelperClass.SelectfromDropdown(shoe, Male_Shoe);
			log.info("Selected Shoe value in dropdown succesfully");
			HelperClass.SelectfromDropdown(hat, Male_Hat);
			log.info("Selected hat value in dropdown succesfully");
		} else if (Gender.equals("Non Binary")) {
			log.info("Gender selected Non binary");
			HelperClass.SelectfromDropdown(dress, Nonbinary_Dress);
			log.info("Selected dress value in dropdown succesfully");
			HelperClass.Senddata(coat, Nonbinary_Coat);
			log.info("Coat value entered in text box succesfully");
			HelperClass.Senddata(neck, Nonbinary_Neck);
			log.info("Neck value entered in text box succesfully");
			HelperClass.Senddata(sleeve, Nonbinary_Sleeve);
			HelperClass.ScrollDown();
			log.info("Sleeve value entered in text box succesfully");
			HelperClass.Senddata(hips, Nonbinary_Hips);
			log.info("Hips value entered in text box succesfully");
			HelperClass.Senddata(waist, Nonbinary_Waist);
			log.info("Waist value entered in text box succesfully");
			HelperClass.Senddata(inseam, Nonbinary_Inseam);
			log.info("Inseam value entered in text box succesfully");
			HelperClass.Senddata(pant, Nonbinary_Pant);
			log.info("Pant value entered in text box succesfully");
			HelperClass.Senddata(bust, Nonbinary_Bust);
			HelperClass.ScrollDown();
			log.info("Bust value entered in text box succesfully");
			HelperClass.SelectfromDropdown(cup, Nonbinary_Cup);
			log.info("Selected cup value in dropdown succesfully");
			HelperClass.SelectfromDropdown(shirt, Nonbinary_Shirt);
			log.info("Selected shirt value in dropdown succesfully");
			HelperClass.SelectfromDropdown(shoe, Nonbinary_Shoe);
			log.info("Selected Shoe value in dropdown succesfully");
			HelperClass.SelectfromDropdown(hat, Nonbinary_Hat);
			log.info("Selected hat value in dropdown succesfully");
			HelperClass.ScrollUp();
		}
		HelperClass.ScrollUp();
		HelperClass.MouseHoverAndClick(Wardrobegreentick);
		log.info("Clicked on green color tick mark succesfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
		log.info("Data saved successfully");
	}

	// Appearance
	public void appearance(String Gender, String Height, String Weight, String Ethnicity, String Ethnicity2,
			String body, String Hairlength, String Haircolor, String Eyecolor) {
		HelperClass.ClickonMyProfileElement(appearance);
		log.info("Appearance page displayed successfully");
		HelperClass.MouseHoverAndClick(appearanceediticon);
		log.info("Appearance Editpage displayed successfully when clicked on edit icon");
		HelperClass.SelectfromDropdown(gender, Gender);
		log.info("Selected gender value in dropdown succesfully");
		HelperClass.SelectfromDropdown(height, Height);
		log.info("Selected height value in dropdown succesfully");
		HelperClass.SelectfromDropdown(weight, Weight);
		log.info("Selected weight value in dropdown succesfully");
		HelperClass.SelectfromDropdown(PrimaryPortrayableEthnicity, Ethnicity);
		log.info("Selected PrimaryPortrayableEthnicity value in dropdown succesfully");
		HelperClass.SelectfromDropdown(AdditionalPortrayableEthnicity, Ethnicity2);
		log.info("Selected AdditionalPortrayableEthnicity value in dropdown succesfully");
		HelperClass.ScrollDown();
		HelperClass.SelectfromDropdown(bodytype, body);
		log.info("Selected bodytype value in dropdown succesfully");
		HelperClass.SelectfromDropdown(hairlength, Hairlength);
		log.info("Selected hairlength value in dropdown succesfully");
		HelperClass.SelectfromDropdown(haircolor, Haircolor);
		log.info("Selected haircolor value in dropdown succesfully");
		HelperClass.SelectfromDropdown(eyecolor, Eyecolor);
		log.info("Selected eyecolor value in dropdown succesfully");
		HelperClass.ScrollUp();
		log.info("Scroll up succesfully");
		HelperClass.ClickonElement(appearancegreentick);
		log.info("Clicked on green color tick mark succesfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Profile Successfully Saved");
		log.info("Data saved successfully");
	}

	// Skills
	public void SelectSkills() throws Exception {
		HelperClass.ClickonMyProfileElement(Skills);
		log.info("Skills page diplayed succesfully");
		HelperClass.MouseHoverAndClick(SkillsEditbutton);
		log.info("Skills Edit page displayed successfully when clicked on edit icon");
			HelperClass.waitforElements(Allskills);
			log.info("Total Number of Skills in page==> "+Allskills.size());
			
			for (WebElement element:Allskills) {
				HelperClass.MouseHoverAndClick(element);
				for (WebElement element1: Allskills) {
					HelperClass.MouseHoverAndClick(element1);
				}
				break;
			}
			log.info("Selected Skills successfully");
			HelperClass.ScrollUp();
		
		
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Skills Successfully Saved");
		log.info("Skills data saved succesfully");

	}

	public void DeselectSkills() throws Exception {
		HelperClass.ClickonMyProfileElement(Skills);
		log.info("Skills page diplayed succesfully");
		HelperClass.MouseHoverAndClick(SkillsEditbutton);
		log.info("Skills Edit page displayed successfully when clicked on edit icon");
			HelperClass.waitforElements(deselectSkill);
			for (WebElement e : deselectSkill) {
				HelperClass.MouseHoverAndClick(e);
			}
			log.info("Deselect skills succesfully");
		
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Skills Successfully Saved");
		log.info("Skills data saved succesfully");

	}
	
	
	// Props
	public void Props(String Function, String Prop1, String Prop2, String Prop3, String Prop4, String Prop5)
			throws Exception {
		HelperClass.ClickonMyProfileElement(Props);
		log.info("Props page diplayed succesfully");
		HelperClass.MouseHoverAndClick(Propsediticon);
		log.info("Props Edit page displayed successfully when clicked on edit icon");
		if (Function.equals("Select")) {
			HelperClass.ScrollDown();
			for (int i = 0; i < Allprops.size(); i++) {
				String prop = Allprops.get(i).getText().replaceAll("\\s", "");

				if (prop.equals(Prop1) || prop.equals(Prop2) || prop.equals(Prop3) || prop.equals(Prop4)
						|| prop.equals(Prop5)) {
					WebElement e = Allprops.get(i);
					HelperClass.MouseHoverAndClick(e);
				}
			}
			log.info("Selected Props successfully");
		} else if (Function.equals("Deselect")) {
			HelperClass.ScrollDown();
			for (int i = 0; i < deselectPropname.size(); i++) {
				String prop = deselectPropname.get(i).getText().replaceAll("\\s", "");
				if (prop.equals(Prop1) || prop.equals(Prop4) || prop.equals(Prop5)) {
					WebElement e = deselectProp.get(i);
					HelperClass.MouseHoverAndClick(e);
				}
			}
			log.info("Deselected Props successfully");
		}
		HelperClass.ScrollUp();
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		HelperClass.ValidationofSuccessMessage(successmessage, "Props Successfully Saved");
		log.info("Props data saved succesfully");

	}

	// Vehicles
	public void Vehicles(String Function, String numberofphotosUpload, String NameofeditVehicle, String NameofdeleteVehicle, String Make,
			String Model, String Year, String Color, String Condition, String Type, String carpic, String carpic2,
			String editMake, String editModel, String editYear, String editColor, String editCondition, String editType,
			String carpic3, String carpic4, String carpic5) throws Exception {
		HelperClass.ClickonMyProfileElement(vehicles);
		log.info("vehicle page displayed successfully");
		HelperClass.TimeOut(10000);
		if (Function.equals("Add")) {
			HelperClass.MouseHoverAndClick(vehiclesAdd);
			log.info("vehicle new Vehicle add page opened successfully");
			HelperClass.SelectfromDropdown(make, Make);
			log.info("Selected make value in dropdown succesfully");
			HelperClass.SelectfromDropdown(model, Model);
			log.info("Selected model value in dropdown succesfully");
			HelperClass.SelectfromDropdown(year, Year);
			log.info("Selected year value in dropdown succesfully");
			HelperClass.SelectfromDropdown(color, Color);
			log.info("Selected color value in dropdown succesfully");
			HelperClass.SelectfromDropdown(condition, Condition);
			log.info("Selected condition value in dropdown succesfully");
			HelperClass.ScrollDown();
			log.info("Scroll down succesfully");
			HelperClass.SelectfromDropdown(type, Type);
			log.info("Selected type value in dropdown succesfully");
			HelperClass.SelectPhotoforVehicle(AddvehiclePhotoUpload, carpic, carpic2, carpic3, carpic4, carpic5, numberofphotosUpload);
			HelperClass.ScrollUp();
			HelperClass.ClickonElement(greentick);
			log.info("Clicked on greentick mark succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Vehicle Successfully Saved");
			log.info("vehicle data added successfully");
		} else if (Function.equals("Edit")) {
			HelperClass.SelectSpecificvehicle(AllsavedVehicle, editVehicleIcons, NameofeditVehicle);
			HelperClass.SelectfromDropdown(make, editMake);
			log.info("Selected make value in dropdown succesfully");
			HelperClass.SelectfromDropdown(model, editModel);
			log.info("Selected model value in dropdown succesfully");
			HelperClass.SelectfromDropdown(year, editYear);
			log.info("Selected year value in dropdown succesfully");
			HelperClass.SelectfromDropdown(color, editColor);
			log.info("Selected color value in dropdown succesfully");
			HelperClass.SelectfromDropdown(condition, editCondition);
			log.info("Selected condition value in dropdown succesfully");
			HelperClass.ScrollDown();
			log.info("Scrolldown succesfully");
			HelperClass.SelectfromDropdown(type, editType);
			log.info("Selected type value in dropdown succesfully");
			HelperClass.TimeOut(2000);
			for (WebElement e : DeleteCarimage) {
				if (e.isDisplayed()) {
					HelperClass.ClickonElement(e);
					log.info("Removed photo succesfully");
				}
			}
			HelperClass.SelectPhotoforVehicle(EditvehiclePhotoUpload, carpic, carpic2, carpic3, carpic4, carpic5, numberofphotosUpload);
			HelperClass.ScrollUp();
			log.info("Scrollup succesfully");
			HelperClass.MouseHoverAndClick(edit_greentick);
			log.info("Clicked on greentick mark succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Vehicle Successfully Saved");
			log.info("vehicle data updated successfully");
		} else if (Function.equals("Delete")) {
			HelperClass.SelectSpecificvehicle(AllsavedVehicle, editVehicleIcons, NameofdeleteVehicle);
			HelperClass.waitforElement(DeleteVehicle);
			HelperClass.ClickonElement(DeleteVehicle);
			log.info("Clicked on Delete vehicle linktext successfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Vehicle Successfully deleted");
			log.info("Vehicle data deleted succesfully");
		}
	}

	// Photos
	public void Photos(String Function, String ChoosephotobyIndex, String profilePic1, String profilePic2, String profilePic3, String profilePic4) throws Exception {
		HelperClass.ClickonMyProfileElement(Photos);
		log.info("Photos Page displayed successfully");
		HelperClass.TimeOut(10000);
		int NumberOfPhotos = PhotoCount.size();
		System.out.println(NumberOfPhotos);
		if (Function.equals("Upload")) {
			if(NumberOfPhotos==4) {
				log.info("4 Photo displayed in page");
			}
			else {
			String [] photoArray = {profilePic1, profilePic2, profilePic3, profilePic4};
			for (int i = NumberOfPhotos; i <=3; i++) {
			    HelperClass.PhotoUpload(UploadButton, photoArray[i]);
			    HelperClass.ClickonElement(PhotoUploadButton);
			    HelperClass.TimeOut(3000);
			}
			HelperClass.ValidationofSuccessMessage(successmessage, "Photo uploaded successfully");
			log.info("Photo upload successfully");
			}		
		} 
		else if (Function.equalsIgnoreCase("Crop")) {
			HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
			log.info("Clicked on Edit icon on photo successfully");
			HelperClass.MouseHoverAndClick(EditPhoto);
			log.info("Clicked on edit photo button successfully");
			HelperClass.ClickonElement(crop);
			log.info("Clicked on crop button successfully");
			HelperClass.CropFunction(cropArea);
			log.info("Crop function done successfully");
			HelperClass.MouseHoverAndClick(Save);
			log.info("Clicked on save button successfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Picture Successfully Updated");
			log.info("Picture updated Successfully");
		} else if (Function.equalsIgnoreCase("Rotate")) {
			HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
			log.info("Clicked on edit photo button successfully");
			HelperClass.MouseHoverAndClick(EditPhoto);
			log.info("Clicked on Edit Photo button successfully");
			HelperClass.MouseHoverAndClick(rotate);
			log.info("Clicked on Rotate button successfully");
			HelperClass.MouseHoverAndClick(Save);
			log.info("Clicked on Save button successfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Picture Successfully Updated");
			log.info("Picture updated Successfully");

		} else if (Function.equalsIgnoreCase("MakeProfile")) {
			HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
			log.info("Clicked on edit photo button successfully");
			HelperClass.MouseHoverAndClick(Makeprofilepic);
			log.info("Clicked on Make profile picture option succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Profile picture Successfully Updated");
			log.info("Profile picture updated succesfully");
		}

		else if (Function.equalsIgnoreCase("Delete")) {
			HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
			log.info("Clicked on edit photo button successfully");
			HelperClass.MouseHoverAndClick(deletePhoto);
			log.info("Clicked on delete option succesfully");
			HelperClass.ValidationofSuccessMessage(successmessage, "Photos Successfully deleted");
			log.info("Photos deleted succesfully");
		}
	}
}

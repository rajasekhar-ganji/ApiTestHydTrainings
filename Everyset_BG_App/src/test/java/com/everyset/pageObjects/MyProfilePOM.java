package com.everyset.pageObjects;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.everyset.utilities.Constant_Paths;
import com.everyset.utilities.HelperClass;
import com.everyset.utilities.ReadingFiles_Utils;

public class MyProfilePOM {
	private WebDriver driver;
	public static Logger log = Logger.getLogger(MyProfilePOM.class);
	public static String Selectgender=null;
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
	@FindBy(xpath = "//button[@class='ant-modal-close']")
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
	
	
	@FindBy(xpath = "//*[@class='ant-breadcrumb-link']/a")
	WebElement Profile_breadcrumb;
	
	
	@FindBy(xpath = "//*[text()='General Information']//following-sibling::div//preceding-sibling::div")
	WebElement GeneralInformation_Header;
	@FindBy(xpath = "//*[text()='Contact']//following-sibling::div//preceding-sibling::div")
	WebElement Contact_Header;
	@FindBy(xpath = "//*[text()='Appearance']//following-sibling::div//preceding-sibling::div")
	WebElement Appearance_Header;
	@FindBy(xpath = "//*[text()='Wardrobe Measurements']//following-sibling::div//preceding-sibling::div")
	WebElement Wardrobe_Header;
	@FindBy(xpath = "//*[text()='Skills']//following-sibling::div//preceding-sibling::div")
	WebElement Skills_Header;
	@FindBy(xpath = "//*[text()='Props']//following-sibling::div//preceding-sibling::div")
	WebElement Props_Header;
	@FindBy(xpath = "//*[text()='Vehicles']//following-sibling::div//preceding-sibling::div")
	WebElement Vehicles_Header;
	@FindBy(xpath = "//*[text()='Photos']//following-sibling::div//preceding-sibling::div")
	WebElement Photos_Header;
	
	
	
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

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-ee372ebb-14 sc-ee372ebb-15 bDZWyC cXhmfU css-cs932n']")

	List<WebElement> deselectSkillname;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-ee372ebb-14 sc-ee372ebb-15 bDZWyC cXhmfU css-cs932n']/span")
	List<WebElement> deselectSkill;
	
	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-9c0457ac-15 sc-9c0457ac-16 jjRTRK hluNiS css-cs932n']")
	List<WebElement> deselectPropname;

	@FindBy(xpath = "//*[@class='ant-tag ant-tag-checkable ant-tag-checkable-checked sc-9c0457ac-15 sc-9c0457ac-16 jjRTRK hluNiS css-cs932n']/span")
	List<WebElement> deselectProp;
 
	@FindBy(xpath = "//*[@class='sc-ee372ebb-12 gTQfNx']")
	List<WebElement> NoSkills;
	@FindBy(xpath = "//*[@class='sc-9c0457ac-14 dvSVRO']")
	List<WebElement> NoProps;
	
//Vehicles
	@FindBy(xpath = "//*[text()='Vehicles']")
	WebElement vehicles;
	
	@FindBy(xpath = "//*[@class='no-vehicles-message']")
	List<WebElement> NoVehicles;
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
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginModule(String username, String Password) {
		log.info("Everyset app statred");
		HelperClass.waitforElement(email);
		HelperClass.Senddataforlogin(email, username);
		log.info("User name entered successfully");
		HelperClass.Senddataforlogin(password,Password );
		log.info("Password entered successfully");
		HelperClass.ClickonElement(loginButton);
		log.info("Clicked on login button");
		HelperClass.waitforElement(successmessage);
		String Actual = successmessage.getText();
		log.info("Message========>  " + Actual);
		Assert.assertEquals(Actual, "Successfully logged in!");
		HelperClass.TimeOut(3000);
		log.info("Login Successfully");

	}
	
	public void Login(String username, String pwd) {
		log.info("Everyset app statred");
		email.sendKeys(username);
		log.info("User name entered successfully");
		password.sendKeys(pwd);
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

	//Success message Validation
	public void ValidationofSuccessMessage(String ExpectedMessage) {
		HelperClass.waitforElement(successmessage);
		String Expected = ExpectedMessage;
		String Actual = successmessage.getText();
		log.info("Success message========>  " + Actual);
		Assert.assertEquals(Actual, Expected);
	}
	
	// My Profile
	public void MyProfileSelection() {
		log.info("Everyset landing page Displayed");
		HelperClass.ElementToBeClickable(MyProfilebutton);
		HelperClass.ClickonElement(MyProfilebutton);
		log.info("My Profile main page Displayed");
	}

	public void MyProfileMainPage() {
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
			System.out.print(e.getText() + ", ");
		}
		HelperClass.waitforElement(ViewPhotos);
		Assert.assertTrue(ViewPhotos.isDisplayed());
		Assert.assertTrue(ViewPhotos.isEnabled());
		System.out.println();
		log.info("View photos text displayed==> " + ViewPhotos.getText());
		for (WebElement e : AllPhotos) {
			Assert.assertTrue(e.isDisplayed());
		}
	}
	public void MyProfile_ChangeProfilePicture(String Function, String choosePhotobyIndex)
	{
		if (Function.equalsIgnoreCase("ProfilePic")) {
			HelperClass.TimeOut(3000);
			if (ProfilePicture.size() > 0) {
				HelperClass.performProfilePictureAction(ProfilePicture);
				log.info("Clicked on Profile picture succesfully");
			}
			HelperClass.TimeOut(3000);
			if (NoProfilePicture.size() > 0) {
				HelperClass.performProfilePictureAction(NoProfilePicture);
				log.info("Clicked on No Profile picture succesfully");
			}
			HelperClass.TimeOut(3000);
			if (AllProfilePhotos.size() > 0) {
				HelperClass.SelectPhoto(AllProfilePhotos, choosePhotobyIndex);
				log.info("Profile picture selected succesfully");
				ValidationofSuccessMessage("Profile Successfully Saved");
				log.info("Profile picture saved succesfully");
			} else {
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(closewindow);
				log.info("No Profile pictures in window and close the window");
			}
		} else if (Function.equalsIgnoreCase("ChangeProfile")) {
			HelperClass.TimeOut(3000);
			HelperClass.performProfilePictureAction(ChangeProfile);
			log.info("Clicked on Change Profile picture linktext succesfully");
			if (AllProfilePhotos.size() > 0) {
				HelperClass.SelectPhoto(AllProfilePhotos, choosePhotobyIndex);
				log.info("Profile picture selected succesfully");
				ValidationofSuccessMessage("Profile Successfully Saved");
				log.info("Profile picture saved succesfully");
			} else {
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(closewindow);
				log.info("No Profile pictures in window and close the window");
			}

		}
	}

	// General Information
	public void GeneralInformation(String firstName, String lastName, String stageName, String Callingserve,
			String MinorOrMazor, String minage, String maxage, String Dob, String UnionstatusName, String Sagid)
			throws Exception {
		HelperClass.ElementToBeClickable(GeneralInformation);
		HelperClass.ClickonElement(GeneralInformation);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(GeneralInformation_Header.isDisplayed());
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
		ValidationofSuccessMessage("Profile Successfully Saved");
		log.info("Data Saved successfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");
	}

	// Contact
	public void contact(String phone, String address_1, String Address_2, String Resi_city, String statename,
			String Zipcode, String MailingAddress, String Mailing_Address, String Mailing_Address_2,
			String Mailing_City, String Mailing_statename, String Mailing_Zipcode) throws Exception {
		
		HelperClass.ElementToBeClickable(Contact);
		HelperClass.ClickonElement(Contact);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Contact_Header.isDisplayed());
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
		ValidationofSuccessMessage("Profile Successfully Saved");
		log.info("Data saved successfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");
	}
	
	
	// Appearance
	public void appearance(String Gender, String Height, String Weight, String Ethnicity, String Ethnicity2,
			String body, String Hairlength, String Haircolor, String Eyecolor) {
		Selectgender=Gender;

		HelperClass.ElementToBeClickable(appearance);
		HelperClass.ClickonElement(appearance);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Appearance_Header.isDisplayed());
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
		ValidationofSuccessMessage("Profile Successfully Saved");
		log.info("Data saved successfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");
	}
	
	// Wardrobe
	public void Wardrobe(String Female_Dress, String Female_Hips, String Female_Waist, String Female_Pant,
			String Female_Bust, String Female_Cup, String Female_Shirt, String Female_Shoe, String Female_Hat,
			String Male_Coat, String Male_Neck, String Male_Sleeve, String Male_Waist, String Male_Inseam,
			String Male_Shirt, String Male_Shoe, String Male_Hat, String Nonbinary_Dress, String Nonbinary_Coat,
			String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
			String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
			String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
		
		HelperClass.ElementToBeClickable(wardrobe);
		HelperClass.ClickonElement(wardrobe);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Wardrobe_Header.isDisplayed());
		log.info("Wardrobe page displayed successfully");
		HelperClass.MouseHoverAndClick(wardrobeediticon);
		log.info("Wardrobe Edit page displayed successfully when clicked on edit icon");
		String Gender=Selectgender.replaceAll("\\s", "");
		System.out.println(Gender);
		if (Gender.equals("Female") || Gender.equals("TransgenderFemale")) {
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
		} else if (Gender.equals("Male") || Gender.equals("TransgenderMale")) {
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
		} else if (Gender.equals("Non-Binary")) {
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
		ValidationofSuccessMessage("Profile Successfully Saved");
		log.info("Data saved successfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");
	}

	// Skills
	public void SelectSkills() throws Exception {
		HelperClass.ElementToBeClickable(Skills);
		HelperClass.ClickonElement(Skills);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Skills_Header.isDisplayed());
		log.info("Skills page diplayed succesfully");
		if(NoSkills.size()>0)
		{
			HelperClass.MouseHoverAndClick(SkillsEditbutton);
			log.info("Skills Edit page displayed successfully when clicked on edit icon");
		}
		HelperClass.SelectAllvalues(Allskills);
		log.info("Selected Skills successfully");
		HelperClass.ScrollUp();
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Skills Successfully Saved");
		log.info("Skills data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");


	}

	public void DeselectSkills() throws Exception {
		HelperClass.ElementToBeClickable(Skills);
		HelperClass.ClickonElement(Skills);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Skills_Header.isDisplayed());
		log.info("Skills page diplayed succesfully");
		HelperClass.MouseHoverAndClick(SkillsEditbutton);
		log.info("Skills Edit page displayed successfully when clicked on edit icon");
		HelperClass.DeselectAllvalues(deselectSkill);
		log.info("Deselect skills succesfully");
		HelperClass.TimeOut(5000);
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Skills Successfully Saved");
		log.info("Skills data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");


	}

	public void Skills(String Function, String Skill1, String Skill2, String Skill3, String Skill4, String Skill5,String Skill6, String Skill7, String Skill8)
			throws Exception {
		HelperClass.ElementToBeClickable(Skills);
		HelperClass.ClickonElement(Skills);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Skills_Header.isDisplayed());
		log.info("Skills page diplayed succesfully");
		if(NoSkills.size()>0)
		{
			HelperClass.MouseHoverAndClick(SkillsEditbutton);
			log.info("Skills Edit page displayed successfully when clicked on edit icon");
		}
	
		String[] selectskills= {Skill1,Skill2,Skill3,Skill4,Skill5, Skill6, Skill7, Skill8};
		String[] deselectskills= {Skill1, Skill2, Skill8,Skill6};
		int l=deselectSkill.size()-deselectskills.length;
		if (Function.equals("Select")) {
			HelperClass.ScrollDown();
			HelperClass.SelectSpecificvalue(Allskills, selectskills);
			log.info("Selected Skills successfully");
		} else if (Function.equals("Deselect")) {
			while(true)
			{
			HelperClass.DeselectSpecificvalue(deselectSkillname, deselectSkill, deselectskills);
			HelperClass.TimeOut(3000);
			if(deselectSkill.size()==l) {
				break;
			}
			}
			log.info("Deselected Skills successfully");
		}
		HelperClass.TimeOut(3000);
		HelperClass.ScrollUp();
		HelperClass.TimeOut(3000);
		HelperClass.ScrollUp();
		HelperClass.DoubleClickonElement(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Skills Successfully Saved");
		log.info("Skills data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");

	}

	// Props
	public void SelectProps() throws Exception {
		HelperClass.ElementToBeClickable(Props);
		HelperClass.ClickonElement(Props);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Props_Header.isDisplayed());
		log.info("Props page diplayed succesfully");
		if(NoProps.size()>0)
		{
			HelperClass.MouseHoverAndClick(Propsediticon);
			log.info("Props Edit page displayed successfully when clicked on edit icon");
		}
		HelperClass.SelectAllvalues(Allprops);
		log.info("Selected Props successfully");
		HelperClass.ScrollUp();
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Props Successfully Saved");
		log.info("Props data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");

	}

	public void DeselectProps() throws Exception {
		HelperClass.ElementToBeClickable(Props);
		HelperClass.ClickonElement(Props);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Props_Header.isDisplayed());
		log.info("Props page diplayed succesfully");
		HelperClass.MouseHoverAndClick(Propsediticon);
		log.info("Props Edit page displayed successfully when clicked on edit icon");
		HelperClass.DeselectAllvalues(deselectProp);
		log.info("Deselect Props succesfully");
		HelperClass.TimeOut(5000);
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Props Successfully Saved");
		log.info("Props data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");

	}

	public void Props(String Function, String Prop1, String Prop2, String Prop3, String Prop4, String Prop5)
			throws Exception {
		HelperClass.ElementToBeClickable(Props);
		HelperClass.ClickonElement(Props);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Props_Header.isDisplayed());
		log.info("Props page diplayed succesfully");
		if(NoProps.size()>0)
		{
			HelperClass.MouseHoverAndClick(Propsediticon);
			log.info("Props Edit page displayed successfully when clicked on edit icon");
		}
		String[] selectProps= {Prop1,Prop2,Prop3, Prop4,Prop5};
		String[] deselectprops= {Prop5,Prop2,Prop1};
		int length=deselectProp.size()-deselectprops.length;
		if (Function.equals("Select")) {
			HelperClass.ScrollDown();
			HelperClass.SelectSpecificvalue(Allprops, selectProps);
			log.info("Selected Props successfully");
		} else if (Function.equals("Deselect")) {
			while(true)
			{
			HelperClass.DeselectSpecificvalue(deselectPropname, deselectProp, deselectprops);
			HelperClass.TimeOut(3000);
			if(deselectProp.size()==length) {
				break;
			}
			}
			log.info("Deselected Props successfully");
		}
		HelperClass.ScrollUp();
		HelperClass.MouseHoverAndClick(Skills_Props_GreenTick);
		log.info("Clicked on green color tickmark succesfully");
		ValidationofSuccessMessage("Props Successfully Saved");
		log.info("Props data saved succesfully");
		HelperClass.TimeOut(3000);
		HelperClass.ClickonElement(Profile_breadcrumb);
		log.info("Clicked on Profile breadcrumb successfully");
		log.info("My Profile main page Displayed");
	}
	
	// Vehicles
	public void Vehicles(String Function, String numberofphotosUpload, String NameofeditVehicle,
			String Make, String Model, String Year, String Color, String Condition,
			String Type, String editMake, String editModel, String editYear, String editColor, String editCondition,
			String editType) throws Exception {
		HelperClass.ElementToBeClickable(vehicles);
		HelperClass.ClickonElement(vehicles);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Vehicles_Header.isDisplayed());
		log.info("vehicle page displayed successfully");
		HelperClass.TimeOut(10000);
		if (Function.equals("Add")) {
			if(NoProps.size()>0)
			{
				HelperClass.MouseHoverAndClick(vehiclesAdd);
				log.info("New Vehicle add page opened successfully");
			}
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
			String[]CarsPics= {Constant_Paths.Car1, Constant_Paths.Car2, Constant_Paths.Car3, Constant_Paths.Car4, Constant_Paths.Car5};
			HelperClass.PhotoUploadforVehicle(AddvehiclePhotoUpload, numberofphotosUpload,CarsPics);
			HelperClass.ScrollUp();
			HelperClass.ClickonElement(greentick);
			log.info("Clicked on greentick mark succesfully");
			ValidationofSuccessMessage("Vehicle Successfully Saved");
			log.info("vehicle data added successfully");
			HelperClass.TimeOut(3000);
			HelperClass.ClickonElement(Profile_breadcrumb);
			log.info("Clicked on Profile breadcrumb successfully");
			log.info("My Profile main page Displayed");

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
			String[]CarsPics= {Constant_Paths.Car3, Constant_Paths.Car4, Constant_Paths.Car5,Constant_Paths.Car1, Constant_Paths.Car2};
			HelperClass.PhotoUploadforVehicle(EditvehiclePhotoUpload,numberofphotosUpload,CarsPics);
			HelperClass.ScrollUp();
			log.info("Scrollup succesfully");
			HelperClass.MouseHoverAndClick(edit_greentick);
			log.info("Clicked on greentick mark succesfully");
			ValidationofSuccessMessage("Vehicle Successfully Saved");
			log.info("vehicle data updated successfully");
			HelperClass.TimeOut(3000);
			HelperClass.ClickonElement(Profile_breadcrumb);
			log.info("Clicked on Profile breadcrumb successfully");
			log.info("My Profile main page Displayed");
			HelperClass.TimeOut(3000);
			HelperClass.ClickonElement(Profile_breadcrumb);
			log.info("Clicked on Profile breadcrumb successfully");
			log.info("My Profile main page Displayed");

		} 
	}
		public void DeleteVehicles(String Function,String NameofdeleteVehicle) throws Exception {
			HelperClass.ElementToBeClickable(vehicles);
			HelperClass.ClickonElement(vehicles);
			HelperClass.TimeOut(3000);
			Assert.assertTrue(Vehicles_Header.isDisplayed());
			log.info("vehicle page displayed successfully");
		 if (Function.equals("Delete")) {
			if (AllsavedVehicle.size() > 0) {
				HelperClass.SelectSpecificvehicle(AllsavedVehicle, editVehicleIcons, NameofdeleteVehicle);
				HelperClass.waitforElement(DeleteVehicle);
				HelperClass.ClickonElement(DeleteVehicle);
				log.info("Clicked on Delete vehicle linktext successfully");
				ValidationofSuccessMessage("Vehicle Successfully deleted");
				log.info("Vehicle data deleted succesfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");
			}
			else
			{
				log.info("Vehicles Data not Found");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		} else if (Function.equals("DeleteAll")) {
			HelperClass.TimeOut(10000);
			System.out.println(AllsavedVehicle.size());
			System.out.println(editVehicleIcons.size());
			if (AllsavedVehicle.size() > 0) {
				HelperClass.DeleteAllData(editVehicleIcons, DeleteVehicle);
				log.info("Clicked on Delete vehicle linktext successfully");
				ValidationofSuccessMessage("Vehicle Successfully deleted");
				log.info("Vehicle data deleted succesfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");
			}
			else
			{
				log.info("Vehicles Data not Found");HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");
			}
		}
	}

	// Photos
	public void UploadPhotos(String Function, String UploadNumberofPhotos) throws Exception {
		HelperClass.ElementToBeClickable(Photos);
		HelperClass.ClickonElement(Photos);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Photos_Header.isDisplayed());
		log.info("Photos Page displayed successfully");
		HelperClass.TimeOut(10000);
		int PhotosCount = PhotoCount.size();
		System.out.println(PhotosCount);
		if (Function.equals("UploadPhotos")) {
			if (PhotosCount == 4) {
				log.info("4 Photos displayed in page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			} else {
				String[] photoArray = {Constant_Paths.photo1, Constant_Paths.photo2, Constant_Paths.photo3,Constant_Paths.photo4};
				for (int i = PhotosCount; i <= 3; i++) {
					HelperClass.PhotoUpload(UploadButton, photoArray[i]);
					HelperClass.ClickonElement(PhotoUploadButton);
					HelperClass.TimeOut(3000);
				}
				ValidationofSuccessMessage("Photo uploaded successfully");
				log.info("Photo upload successfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		} else if (Function.equalsIgnoreCase("UploadSpecificNumberofPhotos")) {
			if (PhotosCount == 4) {
				log.info("4 Photos displayed in page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			} 
			else {
			String[] photoArray = {Constant_Paths.photo4, Constant_Paths.photo2, Constant_Paths.photo3,Constant_Paths.photo1};
			Integer Numberofphotos = Integer.valueOf(UploadNumberofPhotos);
			for (int i = photoArray.length - Numberofphotos; i <= 3; i++) {
				HelperClass.PhotoUpload(UploadButton, photoArray[i]);
				HelperClass.ClickonElement(PhotoUploadButton);
				HelperClass.TimeOut(3000);
			}
			ValidationofSuccessMessage("Photo uploaded successfully");
			log.info("Photo upload successfully");
			HelperClass.TimeOut(3000);
			HelperClass.ClickonElement(Profile_breadcrumb);
			log.info("Clicked on Profile breadcrumb successfully");
			log.info("My Profile main page Displayed");
		} 
		}
		}
	public void Photos(String Function,String ChoosephotobyIndex) throws Exception {
		HelperClass.ElementToBeClickable(Photos);
		HelperClass.ClickonElement(Photos);
		HelperClass.TimeOut(3000);
		Assert.assertTrue(Photos_Header.isDisplayed());
		log.info("Photos Page displayed successfully");
		HelperClass.TimeOut(10000);	
		 if (Function.equalsIgnoreCase("Crop")) {
			if (PhotoCount.size() > 0) {
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
				ValidationofSuccessMessage("Picture Successfully Updated");
				log.info("Picture updated Successfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
			else {
				log.info("Photos not found in Page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		} else if (Function.equalsIgnoreCase("Rotate")) {
			if (PhotoCount.size() > 0) {
				HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
				log.info("Clicked on edit photo button successfully");
				HelperClass.MouseHoverAndClick(EditPhoto);
				log.info("Clicked on Edit Photo button successfully");
				HelperClass.MouseHoverAndClick(rotate);
				log.info("Clicked on Rotate button successfully");
				HelperClass.TimeOut(3000);
				HelperClass.DoubleClickonElement(Save);
				log.info("Clicked on Save button successfully");
				ValidationofSuccessMessage("Picture Successfully Updated");
				log.info("Picture updated Successfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
			else {
				log.info("Photos not found in Page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		} else if (Function.equalsIgnoreCase("MakeProfile")) {
			if (PhotoCount.size() > 0) {
				HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
				log.info("Clicked on edit photo button successfully");
				HelperClass.MouseHoverAndClick(Makeprofilepic);
				log.info("Clicked on Make profile picture option succesfully");
				ValidationofSuccessMessage("Profile picture Successfully Updated");
				log.info("Profile picture updated succesfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
			else {
				log.info("Photos not found in Page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		} else if (Function.equalsIgnoreCase("Delete")) {
			if (PhotoCount.size() > 0) {
				HelperClass.SelectPhoto(PhotoCount, ChoosephotobyIndex);
				log.info("Clicked on edit photo button successfully");
				HelperClass.MouseHoverAndClick(deletePhoto);
				log.info("Clicked on delete option succesfully");
				ValidationofSuccessMessage("Photos Successfully deleted");
				log.info("Photos deleted succesfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
			else {
				log.info("Photos not found in Page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		}else if (Function.equalsIgnoreCase("DeleteAllPhotos")) {
			if (PhotoCount.size() > 0) {
				HelperClass.DeleteAllData(PhotoCount, deletePhoto);
				ValidationofSuccessMessage("Photos Successfully deleted");
				log.info("Photos deleted succesfully");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
			else {
				log.info("Photos not found in Page");
				HelperClass.TimeOut(3000);
				HelperClass.ClickonElement(Profile_breadcrumb);
				log.info("Clicked on Profile breadcrumb successfully");
				log.info("My Profile main page Displayed");

			}
		}
	}
	
	
}

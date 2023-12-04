package com.everyset.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.everyset.pageObjects.MyProfilePOM;
import com.everyset.utilities.TestDataProvider;

@Listeners(com.everyset.utilities.FailedTestcase_Screenshot_Utils.class)
//@Listeners(utils.ExtentReportUtils.class)
public class MyProfile extends BaseClass {
	MyProfilePOM pom;

	
	@BeforeMethod
	public void BeforeMethod() {
		BaseClass.OpenBrowser();
		pom = new MyProfilePOM(driver);
		pom.Login();
		pom.MyProfileSelection();
		}
	
	//@Test(dataProvider = "senddataformyprofile", dataProviderClass = TestDataProvider.class)
	public void MyProfileMainPage(String Function, String choosePhotobyIndex) {
		
	//pom.MyProfileMainPage(Function, choosePhotobyIndex);
    }
	//@Test(dataProvider = "CSVfileDataProvider", dataProviderClass = TestDataProvider.class)
	public void GeneralInformation(String first, String last, String stage, String Callinserve, String agerange,
			String min, String max, String dob, String union, String Sagid) throws Exception {
		
		pom.GeneralInformation(first, last, stage, Callinserve, agerange, min, max, dob, union, Sagid);
	}

	@Test( dataProvider = "csvDataProvider", dataProviderClass =TestDataProvider.class)
	public void Contact(String phone, String address_1, String Address_2, String Resi_city, String statename,
			String Zipcode, String MailingAddress, String Mailing_Address, String Mailing_Address_2, String Mailing_City, String Mailing_statename, String Mailing_Zipcode) throws Exception {
		
		pom.contact(phone, address_1, Address_2, Resi_city, statename, Zipcode,  MailingAddress,  Mailing_Address,  Mailing_Address_2,  Mailing_City,  Mailing_statename,  Mailing_Zipcode);
	}
//	 @Test(dataProvider="senddataforappearance",dataProviderClass =TestDataProvider.class )
//		public void appearance(String gender, String height, String weight, String Ethnicty, String Ethnicity2,String body, String hairlength,
//				String haircolor, String eyecolor) {
//		
//		 pom.appearance(gender, height, weight, Ethnicty,Ethnicity2, body, hairlength, haircolor, eyecolor);
//		}
//
//		@Test( dataProvider = "senddataforwardrobe", dataProviderClass = TestDataProvider.class)
//		public void wardrobe(String Gender, String Dress, String Hips, String Waist, String Pant, String Bust, String Cup,
//				String Shirt, String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist,
//				String Inseam, String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat, String Nonbinary_Neck, String Nonbinary_Sleeve, 
//				String Nonbinary_Hips, String Nonbinary_Waist, String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup, String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
//			
//			pom.Wardrobe(Gender, Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist,
//					Inseam, MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress,  Nonbinary_Coat,  Nonbinary_Neck,  Nonbinary_Sleeve, 
//					 Nonbinary_Hips,  Nonbinary_Waist,  Nonbinary_Inseam,  Nonbinary_Pant,  Nonbinary_Bust,  Nonbinary_Cup,  Nonbinary_Shirt,  Nonbinary_Shoe,  Nonbinary_Hat);
//		}
//
//		@Test()
//		public void SelectAllSkills(String function) throws Exception {
//			pom.SelectSkills();
//			
//		}
//		
//		@Test(dependsOnMethods="SelectAllSkills")
//		public void DeselectAllSkills(String function) throws Exception {
//			pom.DeselectSkills();
//			
//		}
//
//		@Test(dataProvider = "senddataforprops", dataProviderClass = TestDataProvider.class)
//		public void Props(String Function,String Prop1, String Prop2, String Prop3, String Prop4, String Prop5) throws Exception {
//			
//			pom.Props(Function, Prop1, Prop2, Prop3, Prop4, Prop5);
//		}
//		@Test( dataProvider = "senddataforvehicles", dataProviderClass = TestDataProvider.class)
//		public void Vehicles(String Function, String numberofphotosUpload,String EditVehicle, String deletevehicle,String Make, String Model, String Year, String Color, String Condition, String Type,
//				String carpic, String carpic2, String makeedit, String Modeledit, String editYear, String editColor, String editCondition, String editType, String carpic3, String carpic4, String carpic5) throws Exception {
//			
//			pom.Vehicles(Function, numberofphotosUpload,EditVehicle, deletevehicle, Make, Model, Year, Color, Condition, Type, carpic,carpic2, makeedit, Modeledit, editYear, editColor, editCondition, editType, carpic3, carpic4,carpic5);
//		}
//
//		@Test( dataProvider = "senddataforphotos", dataProviderClass = TestDataProvider.class)
//		public void Photos(String Function,String ChoosephotobyIndex, String profilePic1, String profilePic2, String profilePic3, String profilePic4) throws Exception {
//			
//			pom.Photos(Function,ChoosephotobyIndex, profilePic1,profilePic2, profilePic3, profilePic4);
//		}

	  
	}

	
//	@AfterMethod
//	public void Close() {
//		Base.CloseBrowser();
//	}


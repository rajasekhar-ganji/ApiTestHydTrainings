package com.everyset.testcases;


import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.everyset.pageObjects.MyProfilePOM;
import com.everyset.utilities.ExtentReportwithScreenshot_Util;
import com.everyset.utilities.ReadingFiles_Utils;
import com.everyset.utilities.TestDataProvider;

public class MyProfile extends BaseClass {
//	@BeforeTest
//	public void BeforeTest() {
//		ExtentReportwithScreenshot_Util.setExtent();
//	}
//
//
//	@AfterTest
//	public void AfterTest() {
//		ExtentReportwithScreenshot_Util.endReport();
//	}
	
//	@Test(priority=1,enabled=true)
//	public void MyProfile_MainPage() {
//		extentTest = extent.startTest("MyProfile_MainPage");
//		pom1.MyProfileMainPage();
//	}
//
//	@Test(priority=2,enabled=true,dataProvider = "senddatafor_SelectProfilePic", dataProviderClass = TestDataProvider.class)
//	public void ProfilePictureChange(String Function, String ChoosebyIndex) {
//		extentTest = extent.startTest("ProfilePictureChange");
//		pom1.MyProfile_ChangeProfilePicture(Function, ChoosebyIndex);
//	}
//	@Test(priority=3,enabled=true,dataProvider = "senddatafor_changeProfile", dataProviderClass = TestDataProvider.class)
//	public void ChangeProfilePicture(String Function, String ChoosebyIndex) {
//		extentTest = extent.startTest("ChangeProfilePicture");
//		pom1.MyProfile_ChangeProfilePicture(Function, ChoosebyIndex);
//	}
//
//	@Test(priority=4,enabled=true,dataProvider = "senddatafor_generalInformation_withMinor", dataProviderClass = TestDataProvider.class)
//	public void GeneralInformation_withMinor(String first, String last, String stage, String Callinserve, String agerange,
//			String min, String max, String dob, String union, String Sagid) throws Exception {
//		extentTest = extent.startTest("GeneralInformation_withMinor");
//		pom1.GeneralInformation(first, last, stage, Callinserve, agerange, min, max, dob, union, Sagid);
//	}
//
//	@Test(priority=5,enabled=true,dataProvider = "senddatafor_generalInformation_withMajor", dataProviderClass = TestDataProvider.class)
//	public void GeneralInformation_withMajor(String first, String last, String stage, String Callinserve, String agerange,
//			String min, String max, String dob, String union, String Sagid) throws Exception {
//		extentTest = extent.startTest("GeneralInformation_withMajor");
//		pom1.GeneralInformation(first, last, stage, Callinserve, agerange, min, max, dob, union, Sagid);
//	}
//
//	@Test(priority=6,enabled=true,dataProvider = "senddataforcontact_withAddressSame", dataProviderClass = TestDataProvider.class)
//	public void Contact_withAddressSame(String phone, String address_1, String Address_2, String Resi_city, String statename,
//			String Zipcode, String MailingAddress, String Mailing_Address, String Mailing_Address_2,
//			String Mailing_City, String Mailing_statename, String Mailing_Zipcode) throws Exception {
//		extentTest = extent.startTest("Contact_withAddressSame");
//		pom1.contact(phone, address_1, Address_2, Resi_city, statename, Zipcode, MailingAddress, Mailing_Address,
//				Mailing_Address_2, Mailing_City, Mailing_statename, Mailing_Zipcode);
//	}
//
//	@Test(priority=7,enabled=true,dataProvider = "senddataforcontact_withAddressNotSame", dataProviderClass = TestDataProvider.class)
//	public void Contact_withAddressNotSame(String phone, String address_1, String Address_2, String Resi_city, String statename,
//			String Zipcode, String MailingAddress, String Mailing_Address, String Mailing_Address_2,
//			String Mailing_City, String Mailing_statename, String Mailing_Zipcode) throws Exception {
//		extentTest = extent.startTest("Contact_withAddressNotSame");
//		pom1.contact(phone, address_1, Address_2, Resi_city, statename, Zipcode, MailingAddress, Mailing_Address,
//				Mailing_Address_2, Mailing_City, Mailing_statename, Mailing_Zipcode);
//	}
////
////	@Test(priority = 8,enabled=true, dataProvider = "senddatafor_appearance_withMale", dataProviderClass = TestDataProvider.class)
////	public void appearance_withMale(String gender, String height, String weight, String Ethnicty, String Ethnicity2,
////			String body, String hairlength, String haircolor, String eyecolor) {
////		extentTest = extent.startTest("appearance_withMale");
////		pom.appearance(gender, height, weight, Ethnicty, Ethnicity2, body, hairlength, haircolor, eyecolor);
////	}
////
////	@Test(priority = 9,enabled=true, dependsOnMethods = "appearance_withMale", dataProvider = "senddatafor_wardrobe", dataProviderClass = TestDataProvider.class)
////	public void wardrobe_withMale(String Dress, String Hips, String Waist, String Pant, String Bust, String Cup, String Shirt,
////			String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist, String Inseam,
////			String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat,
////			String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
////			String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
////			String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
////		extentTest = extent.startTest("wardrobe_withMale");
////		pom.Wardrobe(Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist, Inseam,
////				MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress, Nonbinary_Coat, Nonbinary_Neck, Nonbinary_Sleeve,
////				Nonbinary_Hips, Nonbinary_Waist, Nonbinary_Inseam, Nonbinary_Pant, Nonbinary_Bust, Nonbinary_Cup,
////				Nonbinary_Shirt, Nonbinary_Shoe, Nonbinary_Hat);
////	}
////	
////	@Test(priority = 10, enabled=true,dataProvider = "senddatafor_appearance_withFemale", dataProviderClass = TestDataProvider.class)
////	public void appearance_withFemale(String gender, String height, String weight, String Ethnicty, String Ethnicity2,
////			String body, String hairlength, String haircolor, String eyecolor) {
////		extentTest = extent.startTest("appearance_withFemale");
////		pom.appearance(gender, height, weight, Ethnicty, Ethnicity2, body, hairlength, haircolor, eyecolor);
////	}
////	
////	@Test(priority = 11, enabled=true,dependsOnMethods = "appearance_withFemale", dataProvider = "senddatafor_wardrobe", dataProviderClass = TestDataProvider.class)
////	public void wardrobe_withFemale(String Dress, String Hips, String Waist, String Pant, String Bust, String Cup, String Shirt,
////	String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist, String Inseam,
////	String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat,
////	String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
////	String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
////	String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
////		extentTest = extent.startTest("wardrobe_withFemale");
////pom.Wardrobe(Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist, Inseam,
////		MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress, Nonbinary_Coat, Nonbinary_Neck, Nonbinary_Sleeve,
////		Nonbinary_Hips, Nonbinary_Waist, Nonbinary_Inseam, Nonbinary_Pant, Nonbinary_Bust, Nonbinary_Cup,
////		Nonbinary_Shirt, Nonbinary_Shoe, Nonbinary_Hat);
////}
////	@Test(priority = 12,enabled=true, dataProvider = "senddatafor_appearance_withNonBinary", dataProviderClass = TestDataProvider.class)
////	public void appearance_withNonbinary(String gender, String height, String weight, String Ethnicty, String Ethnicity2,
////			String body, String hairlength, String haircolor, String eyecolor) {
////		extentTest = extent.startTest("appearance_withNonbinary");
////		pom.appearance(gender, height, weight, Ethnicty, Ethnicity2, body, hairlength, haircolor, eyecolor);
////	}
////
////	@Test(priority = 13,enabled=true, dependsOnMethods = "appearance_withNonbinary", dataProvider = "senddatafor_wardrobe", dataProviderClass = TestDataProvider.class)
////	public void wardrobe_withNonbinary(String Dress, String Hips, String Waist, String Pant, String Bust, String Cup, String Shirt,
////			String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist, String Inseam,
////			String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat,
////			String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
////			String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
////			String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
////		extentTest = extent.startTest("wardrobe_withNonbinary");
////		pom.Wardrobe(Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist, Inseam,
////				MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress, Nonbinary_Coat, Nonbinary_Neck, Nonbinary_Sleeve,
////				Nonbinary_Hips, Nonbinary_Waist, Nonbinary_Inseam, Nonbinary_Pant, Nonbinary_Bust, Nonbinary_Cup,
////				Nonbinary_Shirt, Nonbinary_Shoe, Nonbinary_Hat);
////	}
////	
////	@Test(priority = 14,enabled=true, dataProvider = "senddatafor_appearance_withTransgenderMale", dataProviderClass = TestDataProvider.class)
////	public void appearance_withTransMale(String gender, String height, String weight, String Ethnicty, String Ethnicity2,
////			String body, String hairlength, String haircolor, String eyecolor) {
////		extentTest = extent.startTest("appearance_withTransMale");
////		pom.appearance(gender, height, weight, Ethnicty, Ethnicity2, body, hairlength, haircolor, eyecolor);
////	}
////
////	@Test(priority = 15, enabled=true,dependsOnMethods = "appearance_withTransMale", dataProvider = "senddatafor_wardrobe", dataProviderClass = TestDataProvider.class)
////	public void wardrobe_withTransgenderMale(String Dress, String Hips, String Waist, String Pant, String Bust, String Cup, String Shirt,
////			String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist, String Inseam,
////			String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat,
////			String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
////			String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
////			String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
////		extentTest = extent.startTest("wardrobe_withTransgenderMale");
////		pom.Wardrobe(Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist, Inseam,
////				MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress, Nonbinary_Coat, Nonbinary_Neck, Nonbinary_Sleeve,
////				Nonbinary_Hips, Nonbinary_Waist, Nonbinary_Inseam, Nonbinary_Pant, Nonbinary_Bust, Nonbinary_Cup,
////				Nonbinary_Shirt, Nonbinary_Shoe, Nonbinary_Hat);
////	}
////	
////	@Test(priority = 16, enabled=true,dataProvider = "senddatafor_appearance_withTransgenderFemale", dataProviderClass = TestDataProvider.class)
////	public void appearance_withTransFemale(String gender, String height, String weight, String Ethnicty, String Ethnicity2,
////			String body, String hairlength, String haircolor, String eyecolor) {
////		extentTest = extent.startTest("appearance_withTransFemale");
////		pom.appearance(gender, height, weight, Ethnicty, Ethnicity2, body, hairlength, haircolor, eyecolor);
////	}
////	 @Test(priority=17,enabled=true,dependsOnMethods="appearance_withTransFemale",dataProvider ="senddatafor_wardrobe", dataProviderClass = TestDataProvider.class)
////	public void wardrobe_withTransgenderFemale(String Dress, String Hips, String Waist, String Pant, String Bust, String Cup, String Shirt,
////			String Shoe, String Hat, String Coat, String Neck, String Sleeve, String MaleWaist, String Inseam,
////			String MaleShirt, String MaleShoe, String MaleHat, String Nonbinary_Dress, String Nonbinary_Coat,
////			String Nonbinary_Neck, String Nonbinary_Sleeve, String Nonbinary_Hips, String Nonbinary_Waist,
////			String Nonbinary_Inseam, String Nonbinary_Pant, String Nonbinary_Bust, String Nonbinary_Cup,
////			String Nonbinary_Shirt, String Nonbinary_Shoe, String Nonbinary_Hat) throws Exception {
////		 extentTest = extent.startTest("wardrobe_withTransgenderFemale");
////		pom.Wardrobe(Dress, Hips, Waist, Pant, Bust, Cup, Shirt, Shoe, Hat, Coat, Neck, Sleeve, MaleWaist, Inseam,
////				MaleShirt, MaleShoe, MaleHat, Nonbinary_Dress, Nonbinary_Coat, Nonbinary_Neck, Nonbinary_Sleeve,
////				Nonbinary_Hips, Nonbinary_Waist, Nonbinary_Inseam, Nonbinary_Pant, Nonbinary_Bust, Nonbinary_Cup,
////				Nonbinary_Shirt, Nonbinary_Shoe, Nonbinary_Hat);
////	}
////
////	@Test(priority=18,enabled=true)
////	public void SelectAllSkills() throws Exception {
////		extentTest = extent.startTest("SelectAllSkills");
////		pom.SelectSkills();
////	}
////
////	@Test(priority=19,enabled=true)
////	public void DeselectAllSkills() throws Exception {
////		extentTest = extent.startTest("DeselectAllSkills");
////		pom.DeselectSkills();
////	} 
////
//	@Test(priority=20,enabled=true,dataProvider = "senddatafor_Selectskills", dataProviderClass =TestDataProvider.class)
//	public void SelectSpecificSkills(String Function, String Skill1, String Skill2, String Skill3, String Skill4, String Skill5,String Skill6, String Skill7, String Skill8 )
//			throws Exception {
//		extentTest = extent.startTest("SelectSpecificSkills");
//		pom.Skills(Function, Skill1, Skill2, Skill3, Skill4, Skill5, Skill6,  Skill7,  Skill8);
//	}
//
//	@Test(priority=21,enabled=true,dataProvider = "senddatafor_Deselectskills", dataProviderClass =TestDataProvider.class)
//	public void DeselectSpecificSkills(String Function, String Skill1, String Skill2, String Skill3, String Skill4, String Skill5,String Skill6, String Skill7, String Skill8)
//			throws Exception {
//		extentTest = extent.startTest("DeselectSpecificSkills");
//		pom.Skills(Function, Skill1, Skill2, Skill3, Skill4, Skill5,Skill6,Skill7, Skill8);
//	}
//
//	@Test(priority=22,enabled=true)
//	public void SelectAllProps() throws Exception {
//		extentTest = extent.startTest("SelectAllProps");
//		pom.SelectProps();
//	}
//
//	@Test(priority=23,enabled=true)
//	public void DeselectAllProps() throws Exception {
//		extentTest = extent.startTest("DeselectAllProps");
//		pom.DeselectProps();
//	}
//
//  @Test(priority=24,enabled=true,dataProvider = "senddatafor_Selectprops", dataProviderClass = TestDataProvider.class)
//	public void SelectSpecificProps(String Function, String Prop1, String Prop2, String Prop3, String Prop4, String Prop5)
//			throws Exception {
//	  extentTest = extent.startTest("SelectSpecificProps");
//		pom.Props(Function, Prop1, Prop2, Prop3, Prop4, Prop5);
//	}
//
//	@Test(priority=25,enabled=true,dataProvider = "senddatafor_Deselectprops", dataProviderClass = TestDataProvider.class)
//	public void DeselectSpecificProps(String Function, String Prop1, String Prop2, String Prop3, String Prop4, String Prop5)
//			throws Exception {
//		extentTest = extent.startTest("DeselectSpecificProps");
//		pom.Props(Function, Prop1, Prop2, Prop3, Prop4, Prop5);
//	}
//
//	@Test(priority=26,enabled=true,dataProvider = "senddatafor_Addvehicles", dataProviderClass = TestDataProvider.class)
//	public void AddVehicles(String Function, String numberofphotosUpload, String EditVehicle,
//			String Make, String Model, String Year, String Color, String Condition, String Type, String makeedit,
//			String Modeledit, String editYear, String editColor, String editCondition, String editType)
//			throws Exception {
//		extentTest = extent.startTest("AddVehicles");
//		pom.Vehicles(Function, numberofphotosUpload, EditVehicle, Make, Model, Year, Color, Condition, Type, makeedit,
//				Modeledit, editYear, editColor, editCondition, editType);
//	}
//
//	@Test(priority=27,enabled=true,dataProvider = "senddatafor_Editvehicles", dataProviderClass = TestDataProvider.class)
//	public void EditVehicles(String Function, String numberofphotosUpload, String EditVehicle,
//			String Make, String Model, String Year, String Color, String Condition, String Type, String makeedit,
//			String Modeledit, String editYear, String editColor, String editCondition, String editType)
//			throws Exception {
//		extentTest = extent.startTest("EditVehicles");
//		pom.Vehicles(Function, numberofphotosUpload, EditVehicle, Make, Model, Year, Color, Condition, Type, makeedit,
//				Modeledit, editYear, editColor, editCondition, editType);
//	}
//
//	@Test(priority=28,enabled=true,dataProvider = "senddatafor_Deletevehicles", dataProviderClass = TestDataProvider.class)
//	public void DeleteVehicles(String Function, String deletevehicle) throws Exception {
//		extentTest = extent.startTest("DeleteVehicles");
//		pom.DeleteVehicles(Function, deletevehicle);
//	}
//
//	@Test(priority=29,enabled=true,dataProvider = "senddatafor_DeleteAllvehicles", dataProviderClass = TestDataProvider.class)
//	public void DeleteAllVehicles(String Function, String Nameofdeletevehicle) throws Exception {
//		extentTest = extent.startTest("DeleteAllVehicles");
//		pom.DeleteVehicles(Function, Nameofdeletevehicle);
//	}
//	
//	@Test(priority=30,enabled=true,dataProvider = "senddatafor_UploadSpecificNumberOfPhotos", dataProviderClass = TestDataProvider.class)
//	public void UploadSpecificNumberOfPhotos(String Function, String NumberofPhotos) throws Exception {
//		extentTest = extent.startTest("UploadSpecificNumberOfPhotos");
//		pom.UploadPhotos(Function, NumberofPhotos);
//	}
//	
//	@Test(priority=31,enabled=true,dataProvider = "senddatafor_Uploadphotos", dataProviderClass = TestDataProvider.class)
//	public void UploadPhotos(String Function, String NumberofPhotos) throws Exception {
//		extentTest = extent.startTest("UploadPhotos");
//		pom.UploadPhotos(Function, NumberofPhotos);
//	}
//
//
//	@Test(priority=32,enabled=true,dataProvider = "senddatafor_CropPhotos", dataProviderClass = TestDataProvider.class)
//	public void CropPhotos(String Function, String ChooseByIndex) throws Exception {
//		extentTest = extent.startTest("CropPhotos");
//		pom.Photos(Function, ChooseByIndex);
//	}
//
//	@Test(priority=33,enabled=true,dataProvider = "senddatafor_RotatePhotos", dataProviderClass = TestDataProvider.class)
//	public void RotatePhotos(String Function, String ChooseByIndex) throws Exception {
//		extentTest = extent.startTest("RotatePhotos");
//		pom.Photos(Function, ChooseByIndex);
//	}
//
//	@Test(priority=34,enabled=true,dataProvider = "senddatafor_MakeProfilePhotos", dataProviderClass = TestDataProvider.class)
//	public void MakeProfile_Photos(String Function, String ChooseByIndex) throws Exception {
//		extentTest = extent.startTest("MakeProfile_Photos");
//		pom.Photos(Function, ChooseByIndex);
//	}
//
//	@Test(priority=35,enabled=true,dataProvider = "senddatafor_DeletePhotos", dataProviderClass = TestDataProvider.class)
//	public void DeletePhotos(String Function, String ChooseByIndex) throws Exception {
//		extentTest = extent.startTest("DeletePhotos");
//		pom.Photos(Function, ChooseByIndex);
//	}
//
//	@Test(priority=36,enabled=true,dataProvider = "senddatafor_DeleteAllPhotos", dataProviderClass = TestDataProvider.class)
//	public void DeleteAllPhotos(String Function, String ChooseByIndex) throws Exception {
//		extentTest = extent.startTest("DeleteAllPhotos");
//		pom.Photos(Function, ChooseByIndex);
//	}

	}

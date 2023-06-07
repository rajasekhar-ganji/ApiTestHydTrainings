package api.com.pet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utils.HelperUtils;
import utils.UtilsClass;



public class Scenario1  {
	@BeforeSuite
	 public void beforesuite()  {
		try {
			UtilsClass.Xlcovertjson(HelperUtils.ConnectPropertyFile("requestname1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilsClass.baseUrl();   
		
		
	  }
	@BeforeTest
	 public void sendRequest(){
		UtilsClass.sendRequest();   
		
	  }
	@Test
	public void addpetTostore()
	{
		UtilsClass.addPetToStoreNow();
	}
	@Test(priority = 1)
	public void uploadPicture() {
		UtilsClass.uploadImageOfPet();
	}

	@Test(priority = 2)
	public void getByID() {
		
		UtilsClass.findPetGetById();

	}

	@Test(priority = 3)
	public void getByStatus() {
		
		UtilsClass.findPetByStatus();

	}
	  @AfterMethod
	  public void validate() {
		  UtilsClass.validations();
	  }
}

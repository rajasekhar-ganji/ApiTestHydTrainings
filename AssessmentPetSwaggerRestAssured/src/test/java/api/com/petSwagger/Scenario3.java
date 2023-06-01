package api.com.pet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.UtilsClass;

public class Scenario3 {
	@BeforeSuite
	 public void baseURL() {
		UtilsClass.baseUrl();   
	  }
		@BeforeTest
		public void sendRequest() {
		UtilsClass.sendRequest();   
		}
		  @Test
			public void addPetToStore()  {
			 
				UtilsClass.addPetToStoreNow();
			} 

			@Test(priority = 1)
			public void uploadPicture() {
				UtilsClass.uploadImageOfPet();
			}

			@Test(priority = 2)
			public void updateExistingPetData() {
				UtilsClass.updatePetData();
			}
			@Test(priority = 3)
			public void deletePetData() {
				UtilsClass.deletePetData();

			}
			 @AfterMethod
			  public void validate() {
				  UtilsClass.validations();
			  }
  }

package api.com.pet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utils.HelperUtils;
import utils.UtilsClass;



public class Scenario2 {
	@BeforeSuite
	 public void beforesuite() {
		try {
			UtilsClass.Xlcovertjson(HelperUtils.ConnectPropertyFile("requestname1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UtilsClass.baseUrl();   
	  }
	@BeforeTest
	 public void sendRequest()  {
		UtilsClass.sendRequest();   
	  }
  @Test(priority=1)
  public void addpet() throws Exception {
	UtilsClass.addPetToStoreNow();   
  }
  @Test(priority=2)
  public void findById() {
	  UtilsClass.findPetGetById();
  }
  @Test(priority=3)
  public void findbystatus() {
	  UtilsClass.findPetByStatus();
  }
  @Test(priority=4)
  public void delete() {
	  UtilsClass.deletePetData();
  }
  @AfterMethod
  public void validate() {
	  UtilsClass.validations();
  }
}

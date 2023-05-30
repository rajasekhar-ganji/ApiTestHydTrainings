package api.com.pet;

import org.testng.annotations.Test;

public class Scenario2 {

  @Test(priority=1)
  public void add() {
	UtilsClass.addPetToStore(); 
	  
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
}

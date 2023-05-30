package api.com.pet;

import org.testng.annotations.Test;

public class Scenario3 {
	 
		  @Test
			public void addPetToStore() {
			  UtilsClass.addPetToStore();
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
		  
  }

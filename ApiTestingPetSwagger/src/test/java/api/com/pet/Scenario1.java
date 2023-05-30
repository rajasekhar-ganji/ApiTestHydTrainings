package api.com.pet;

import org.testng.annotations.Test;

public class Scenario1 {
	@Test(priority = 1)
	public void uploadPicture() {
		UtilsClass.postUploadImage(25);
	}

	@Test(priority = 2)
	public void getByID() {
		
		UtilsClass.findById(25);

	}

	@Test(priority = 3)
	public void getByStatus() {
		
		UtilsClass.findPetByStatus();

	}
}

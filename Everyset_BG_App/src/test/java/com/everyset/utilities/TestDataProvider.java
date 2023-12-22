package com.everyset.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
public class TestDataProvider {
	@DataProvider(name="senddatafor_login")
	 public Object[][] login() throws Exception {
           Object[][]data= ReadingFiles_Utils.getDataFromSheet("Sheet28");
			return data;
	}
	
	@DataProvider(name="senddatafor_SelectProfilePic")
	 public Object[][] SelectProfile1() throws Exception {
            Object[][]data= ReadingFiles_Utils.getDataFromSheet("Sheet1");
			return data;
	}
	@DataProvider(name = "senddatafor_changeProfile")
	 public Object[][] SelectProfile2() throws Exception {
	    	 Object[][]data = ReadingFiles_Utils.getDataFromSheet("Sheet2");
			return data;
	    }
	 
	@DataProvider(name = "senddatafor_generalInformation_withMinor")
	 public Object[][] getDataforGeneralInformation() throws Exception {
	    	 Object[][]data = ReadingFiles_Utils.getDataFromSheet("Sheet3");
			return data;
	    }
	@DataProvider(name = "senddatafor_generalInformation_withMajor")
	 public Object[][] getDataforGeneralInformation2() throws Exception {
	    	 Object[][]data = ReadingFiles_Utils.getDataFromSheet("Sheet4");
			return data;
	    }

	@DataProvider(name="senddataforcontact_withAddressSame")
	public Object[][]getDataforContact() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet5");
		return data;
	}
	@DataProvider(name="senddataforcontact_withAddressNotSame")
	public Object[][]getDataforContact2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet6");
		return data;
	}
	
	@DataProvider(name="senddatafor_appearance_withMale")
	
	public Object[][]getDataforappearance() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet7");
		return data;
	}
	@DataProvider(name="senddatafor_appearance_withFemale")
	
	public Object[][]getDataforappearance2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet8");
		return data;
	}
	
	@DataProvider(name="senddatafor_appearance_withNonBinary")
	
	public Object[][]getDataforappearance3() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet9");
		return data;
	}
	@DataProvider(name="senddatafor_appearance_withTransgenderMale")
	
	public Object[][]getDataforappearance4() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet10");
		return data;
	}
	
	@DataProvider(name="senddatafor_appearance_withTransgenderFemale")
	
	public Object[][]getDataforappearance5() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet11");
		return data;
	}
	
	@DataProvider(name="senddatafor_wardrobe")
	public Object[][]getDataforWardrobe() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet12");
		return data;
	}
	@DataProvider(name="senddatafor_Selectskills")
	public Object[][]getDataforskills1() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet13");
		return data;
	}
	@DataProvider(name="senddatafor_Deselectskills")
	public Object[][]getDataforskills2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet14");
		return data;
	}
	@DataProvider(name="senddatafor_Selectprops")
	public Object[][]getDataforprops1() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet15");
		return data;
	}

	@DataProvider(name="senddatafor_Deselectprops")
	public Object[][]getDataforprops2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet16");
		return data;
	}
	@DataProvider(name="senddatafor_Addvehicles")
	public Object[][]getDataforVehicles1() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet17");
		return data;
	}
	
	@DataProvider(name="senddatafor_Editvehicles")
	public Object[][]getDataforVehicles2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet18");
		return data;
	}
	@DataProvider(name="senddatafor_Deletevehicles")
	public Object[][]getDataforVehicles3() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet19");
		return data;
	}
	@DataProvider(name="senddatafor_DeleteAllvehicles")
	public Object[][]getDataforVehicles4() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet20");
		return data;
	}
	@DataProvider(name="senddatafor_UploadSpecificNumberOfPhotos")
	public Object[][]getDataforPhotos1() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet21");
		return data;
	}
	@DataProvider(name="senddatafor_Uploadphotos")
	public Object[][]getDataforPhotos2() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet22");
		return data;
	}
	@DataProvider(name="senddatafor_CropPhotos")
	public Object[][]getDataforPhotos3() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet23");
		return data;
	}
	@DataProvider(name="senddatafor_RotatePhotos")
	public Object[][]getDataforPhotos4() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet24");
		return data;
	}
	@DataProvider(name="senddatafor_MakeProfilePhotos")
	public Object[][]getDataforPhotos5() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet25");
		return data;
	}
	@DataProvider(name="senddatafor_DeletePhotos")
	public Object[][]getDataforPhotos6() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet26");
		return data;
	}
	@DataProvider(name="senddatafor_DeleteAllPhotos")
	public Object[][]getDataforPhotos7() throws Exception {
		Object[][]data=ReadingFiles_Utils.getDataFromSheet("Sheet27");
		return data;
	}
	

}
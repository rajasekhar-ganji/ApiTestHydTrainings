package com.everyset.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.everyset.testcases.BaseClass;

import dev.failsafe.Timeout;

public class HelperClass extends BaseClass {
	public static Actions a;
	public static Robot robot;
	public static StringSelection stringSelection;
	

	public static void PhotoUpload(WebElement element, String photopath) throws Exception {
		waitforElement(element);
		MouseHoverAndClick(element);
		TimeOut(5000);
		stringSelection = new StringSelection(photopath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		TimeOut(2000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		TimeOut(5000);
	}
	
	public static void SelectSpecificvehicle(List<WebElement>VehicleElements,List<WebElement>VehicleEditiconElements,String Namefordeleteoredit ) {
		HelperClass.waitforElements(VehicleElements);
		HelperClass.waitforElements(VehicleEditiconElements);
		String VehiclefordeleteorEdit = Namefordeleteoredit.trim();
		log.info("Number of vehicles added ==> " + VehicleElements.size());
		TimeOut(5000);
		for (int i = 0; i < VehicleElements.size(); i++) {
		String Vehicle = VehicleElements.get(i).getText().replaceAll("\\s", "");
		if (VehiclefordeleteorEdit.equals(Vehicle)) {
			WebElement EditIcon = VehicleEditiconElements.get(i);
			HelperClass.DoubleClickonElement(EditIcon);
			log.info("Vehicle Edit page displayed successfully when clicked on edit icon");
		}
	}

	}
	public static void SelectPhoto(List<WebElement>PhotoElements, String number) {
		HelperClass.TimeOut(15000);
		int NumberOfPhotos1 = PhotoElements.size();
		System.out.println("Numbers of photos displayed in window==> "+NumberOfPhotos1);
		Integer num = Integer.valueOf(number);
		WebElement selectprofile = PhotoElements.get(num);
		HelperClass.ClickonElement(selectprofile);
	}
	public static void SelectPhotoforVehicle(WebElement PhotoElements,String carpic, String carpic2, String carpic3, String carpic4, String carpic5,String number) throws Exception {
		String[]Cars= {carpic, carpic2, carpic3, carpic4, carpic5};
		Integer Numberofcars = Integer.valueOf(number);
		for (int i = Cars.length-Numberofcars; i <=4; i++) {
		    HelperClass.PhotoUpload(PhotoElements, Cars[i]);
		    HelperClass.TimeOut(5000);
		}
	}

	
	public static void performProfilePictureAction(List<WebElement>profilePictureElement) {
		WebElement element=profilePictureElement.get(0);
		HelperClass.waitforElement(element);
	    Assert.assertTrue(element.isDisplayed());
	    Assert.assertTrue(element.isEnabled());
	    HelperClass.ClickonElement(element);
	}
	
	public static void ValidationofSuccessMessage(WebElement element, String ExpectedMessage) {
		HelperClass.waitforElement(element);
		String Expected=ExpectedMessage;
		String Actual=element.getText();
		log.info("Success message========>  "+Actual);
		Assert.assertEquals(Actual,Expected);
	}
	public static void ClickonMyProfileElement(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static void waitforElement(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitforElements(List<WebElement> element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.visibilityOfAllElements(element));
	}

	public static void ClickonElement(WebElement element) {
		waitforElement(element);
		element.click();
	}

	public static void DoubleClickonElement(WebElement element) {
		a = new Actions(driver);
		waitforElement(element);
		a.doubleClick(element).perform();
	}

	public static void PressEnter() {
		a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
		a.keyUp(Keys.ENTER).build().perform();
	}

	public static void Senddata(WebElement element, String text) {
		waitforElement(element);
		ClearTextBox(element);
		element.sendKeys(text);
	}
	
	public static void Senddataforlogin(WebElement element, String text) {
		waitforElement(element);
		element.sendKeys(text);
	}

	
	
	public static void SenddataByJavascriptExecutor(WebElement element, String text) {
		// BackSpace(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=" + text + ";", element);
	}

	public static void DownArrowAction() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.SHIFT).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
		a.keyUp(Keys.SHIFT).keyUp(Keys.ARROW_DOWN).keyUp(Keys.ENTER).build().perform();
	}

	public static void MouseHoverAndClick(WebElement element) {
		waitforElement(element);
		a = new Actions(driver);
		a.moveToElement(element).click().build().perform();
		
	}

	public static void ClearTextBox(WebElement element) {
		a = new Actions(driver);
		waitforElement(element);
		a.click(element).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build()
				.perform();
	}

	public static void TimeOut(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ScrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400);");
		HelperClass.TimeOut(3000);
	}

	public static void ScrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -400);");
		HelperClass.TimeOut(3000);
	}

	public static void SelectfromDropdown(WebElement element, String name) {
		waitforElement(element);
		while (!element.getText().equalsIgnoreCase(name)) {
			element.click();
			DownArrowAction();
		}
	}

	public static void CropFunction(WebElement element) {
		a = new Actions(driver);
		waitforElement(element);
		int x = -90;
		int y = -140;
		int width = 100;
		int height = 200;
		a.moveToElement(element).moveByOffset(x, y).clickAndHold().build().perform();
		a.moveToElement(element, width, height).clickAndHold().perform();
	}
}

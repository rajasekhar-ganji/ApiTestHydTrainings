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
//Photo Upload Method
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
	public static void SelectAllvalues(List<WebElement> AllElements) {
		for (WebElement element : AllElements) {
			HelperClass.MouseHoverAndClick(element);
			for (WebElement element1 : AllElements) {
				HelperClass.MouseHoverAndClick(element1);
			}
			break;
		}
		}
	public static void DeselectAllvalues(List<WebElement> AllElements) {
		for (WebElement element : AllElements) {
			HelperClass.MouseHoverAndClick(element);
			for (WebElement element1 : AllElements) {
				HelperClass.MouseHoverAndClick(element1);
			}
			break;
		}
		}
	

	public static void SelectSpecificvalue(List<WebElement> AllElements,String[]values) {
	for (int i = 0; i < AllElements.size(); i++) {
		WebElement element = AllElements.get(i);
		String prop = element.getText().replaceAll("\\s", "");
		String[] s=values;
		for(int j=0;j<s.length;j++) {
		if (prop.equals(s[j])) {
			HelperClass.MouseHoverAndClick(element);
			TimeOut(1000);
		}
	}
	}
	}
	
	public static void DeselectSpecificvalue(List<WebElement> AllElements, List<WebElement> Elements,
			String[]values) {
		for (int i = 0; i < AllElements.size(); i++) {
			String value = AllElements.get(i).getText().replaceAll("\\s", "");
			for(int j=0;j<values.length;j++) {
			if (value.equals(values[j])) {
	                WebElement element = Elements.get(i);
	                HelperClass.MouseHoverAndClick(element);
	                TimeOut(2000);
			}
			}
		}
	
	}
	// Select Specific Vehicle Method
	public static void SelectSpecificvehicle(List<WebElement> VehicleElements, List<WebElement> VehicleEditiconElements,
			String Namefordeleteoredit) {
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

	// Select Photo Method
	public static void SelectPhoto(List<WebElement> PhotoElements, String number) {
		HelperClass.TimeOut(15000);
		int NumberOfPhotos = PhotoElements.size();
		System.out.println("Numbers of photos displayed in window==> " + NumberOfPhotos);
		Integer num = Integer.valueOf(number);
		WebElement selectprofile = PhotoElements.get(num);
		HelperClass.ClickonElement(selectprofile);
	}
	
	
	public static void DeleteAllData(List<WebElement> Elements, WebElement element) {
		int NumberOfElements = Elements.size();
		System.out.println(NumberOfElements);
		for(int i=NumberOfElements-1;i>=0;i--) {
			TimeOut(5000);
		WebElement selectprofile = Elements.get(i);
		HelperClass.ClickonElement(selectprofile);
		HelperClass.MouseHoverAndClick(element);
			}
	}
	// Upload Cars photos for vehicle
	public static void PhotoUploadforVehicle(WebElement PhotoElement,String number,String[] Cars) throws Exception {
		Integer Numberofcars = Integer.valueOf(number);
		for (int i = Cars.length - Numberofcars; i <= 4; i++) {
			HelperClass.PhotoUpload(PhotoElement, Cars[i]);
			HelperClass.TimeOut(10000);
		}
	}

//Click on Profile pic 
	public static void performProfilePictureAction(List<WebElement> profilePictureElement) {
		HelperClass.waitforElements(profilePictureElement);
		WebElement element = profilePictureElement.get(0);
		HelperClass.waitforElement(element);
		HelperClass.ClickonElement(element);
	}

	// Click Method
	public static void ElementToBeClickable(WebElement element) {
		WebDriver driver = getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.elementToBeClickable(element));
	}
	//Explicit Wait Method for one Element
	public static void waitforElement(WebElement element) {
		WebDriver driver = getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.visibilityOf(element));
	}
	//Explicit Wait Method for List of Elements
	public static void waitforElements(List<WebElement> elements) {
		WebDriver driver = getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
		w.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public static void waitfortext(WebElement element, String text) {
		WebDriver driver = getDriver();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(40));
	//	w.until(ExpectedConditions.);
	}
	
	

	// Click Method
	public static void ClickonElement(WebElement element) {
		element.click();
	}

	// Double Click Method
	public static void DoubleClickonElement(WebElement element) {
		WebDriver driver = getDriver();
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}

//Press Enter Method
	public static void PressEnter() {
		WebDriver driver = getDriver();
		a = new Actions(driver);
		a.keyDown(Keys.ENTER).build().perform();
		a.keyUp(Keys.ENTER).build().perform();
	}

	// Clear and sendKeys Method
	public static void Senddata(WebElement element, String text) {
		waitforElement(element);
		ClearTextBox(element);
		element.sendKeys(text);
	}

	// sendKeys Method
	public static void Senddataforlogin(WebElement element, String text) {
		waitforElement(element);
		element.sendKeys(text);
	}

	// Send data into textbox by Javascript executor
	public static void SenddataByJavascriptExecutor(WebElement element, String text) {
		WebDriver driver = getDriver();
		// BackSpace(element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=" + text + ";", element);
	}

	// Press Down Arrow Method
	public static void DownArrowAction() {
		WebDriver driver = getDriver();
		Actions a = new Actions(driver);
		a.keyDown(Keys.SHIFT).keyDown(Keys.ARROW_DOWN).keyDown(Keys.ENTER).build().perform();
		a.keyUp(Keys.SHIFT).keyUp(Keys.ARROW_DOWN).keyUp(Keys.ENTER).build().perform();
	}

	// MouseHover and Click Method
	public static void MouseHoverAndClick(WebElement element) {
		WebDriver driver = getDriver();
		waitforElement(element);
		a = new Actions(driver);
		a.moveToElement(element).click().build().perform();

	}

	
	// Clear Method
	public static void ClearTextBox(WebElement element) {
		WebDriver driver = getDriver();
		a = new Actions(driver);
		waitforElement(element);
		a.click(element).keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).build()
				.perform();
	}

	// Thread Sleep
	public static void TimeOut(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Scroll down by Javascript executor
	public static void ScrollDown() {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 400);");
		HelperClass.TimeOut(3000);
	}

	// Scroll up by Javascript executor
	public static void ScrollUp() {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);");
		HelperClass.TimeOut(3000);
	}
	public static void ScrollIntoVIew(WebElement element) {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		HelperClass.TimeOut(3000);
	}

	// SelectByVisibleText Method
	public static void SelectfromDropdown(WebElement element, String text) {
		waitforElement(element);
		while (!element.getText().equalsIgnoreCase(text)) {
			element.click();
			DownArrowAction();
		}
	}

	// Crop Method
	public static void CropFunction(WebElement element) {
		WebDriver driver = getDriver();
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


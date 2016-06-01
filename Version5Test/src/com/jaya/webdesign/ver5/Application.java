package com.jaya.webdesign.ver5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Application {

	static WebDriver driver;

	@BeforeTest
	public void startingTheBrowser() {
		// Launching chrome browser
		System.setProperty("webdriver.chrome.driver", "/home/sumanth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.url);
	}

	@AfterTest
	public void closingTheBrowser() {
		try {
			Thread.sleep(5L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}

	@Test
	public void urlAndTitleCheck() {
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(currentUrl);
	}

	@Test(dependsOnMethods = "urlAndTitleCheck")
	public void toggleVerification() {
		WebElement toggle = driver.findElement(By.xpath(Constants.toggleXpath));
		if (toggle.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage);
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}
	}

	@Test
	public void titleVerification() {
		// Title Verification according to business requirements

		WebElement company = driver.findElement(By.xpath(Constants.companyHeadingXpath));
		if (company.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage + Constants.elementText + company.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}
	}

	@Test
	public void taglineVerification() {
		WebElement tagLine = driver.findElement(By.xpath(Constants.tagLineXpath));
		if (tagLine.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage + Constants.elementText + tagLine.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

	}

	@Test
	public void buttonVerification() {
		WebElement findOutMore = driver.findElement(By.xpath(Constants.findOutMoreButtonXpath));
		Application.elementVerificationWithText(findOutMore);
	}

	@Test
	public void sloganVerification() {
		WebElement slogan = driver.findElement(By.xpath(Constants.sectionAboutXpath));

		Application.scrollToElement(slogan);
		Application.elementVerificationWithText(slogan);
	}

	@Test
	public void serviceTabVerification() {
		WebElement services = driver.findElement(By.xpath(Constants.sectionServicesXpath));
		Application.scrollToElement(services);
		Application.elementVerificationWithText(services);
	}

	@Test

	public void serviceImageVerification() {
		// Services section image verifications
		WebElement sectionServicesImages = driver.findElement(By.xpath(Constants.sectionServicesImagesXpath));
		Application.scrollToElement(sectionServicesImages);
		Application.elementVerification(sectionServicesImages);
	}

	@Test
	public void serviceSubsectionVerification() {
		// Services section Heading Checking

		WebElement sectionServicesBox = driver.findElement(By.xpath(Constants.sectionServicesBox));
		List<WebElement> sectionServicesHeadings = driver
				.findElements(By.xpath(Constants.sectionServicesHeadingsXpath));

		List<WebElement> sectionServicesParagraphText = driver
				.findElements(By.xpath(Constants.sectionServicesParagraphTextXpath));

		Application.scrollToElement(sectionServicesBox);
		for (int i = 0; i < sectionServicesHeadings.size(); i++) {
			String textOfTheHeadings = sectionServicesHeadings.get(i).getText();
			System.out.println("The text of the element is : " + textOfTheHeadings);
			String paragraphOfTheHeadings = sectionServicesParagraphText.get(i).getText();
			System.out.println(paragraphOfTheHeadings);
		}
	}

	@Test
	public void footerVerification() {
		WebElement footerAddress = driver.findElement(By.xpath(Constants.footerAddressXpath));
		Application.scrollToElement(footerAddress);
		Application.elementVerificationWithText(footerAddress);

	}

	public static void scrollToElement(WebElement scrollIntoElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollIntoElement);
		try {
			Thread.sleep(5L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void elementVerificationWithText(WebElement elementName) {
		if (elementName.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage + Constants.elementText + elementName.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

	}

	public static void elementVerification(WebElement elementName) {
		if (elementName.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage);
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

	}
}
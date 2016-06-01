package com.jaya.webdesign.ver5;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestVersion5 {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Launching chrome browser
		System.setProperty("webdriver.chrome.driver",
				"/home/sumanth/Downloads/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		driver.get(Constants.url);

		// Url and Title Check

		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println(title);
		System.out.println(currentUrl);

		// /Class Declarations

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Toggle Verification

		WebElement toggle = driver.findElement(By.xpath(Constants.toggleXpath));
		if (toggle.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage);
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

		// Title Verification according to business requirements

		WebElement company = driver.findElement(By
				.xpath(Constants.companyHeadingXpath));
		if (company.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage
					+ Constants.elementText + company.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

		// Tagline Verification according to business requirements

		WebElement tagLine = driver.findElement(By
				.xpath(Constants.tagLineXpath));
		if (tagLine.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage
					+ Constants.elementText + tagLine.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

		// Button Verification according to business requirements

		WebElement findOutMore = driver.findElement(By
				.xpath(Constants.findOutMoreButtonXpath));
		TestVersion5.elementVerificationWithText(findOutMore);

		// Slogan Verification according to business requirements

		WebElement slogan = driver.findElement(By
				.xpath(Constants.sectionAboutXpath));

		js.executeScript("arguments[0].scrollIntoView(true);", slogan);
		Thread.sleep(500);

		TestVersion5.elementVerificationWithText(slogan);

		// SERVICES SECTION

		// Section Services verification according to business requirements
		WebElement services = driver.findElement(By
				.xpath(Constants.sectionServicesXpath));
		js.executeScript("arguments[0].scrollIntoView(true)", services);
		Thread.sleep(500);
		TestVersion5.elementVerificationWithText(services);

		// Services section image verifications

		WebElement sectionServicesImages = driver.findElement(By
				.xpath(Constants.sectionServicesImagesXpath));
		TestVersion5.scrollToElement(sectionServicesImages);
		TestVersion5.elementVerification(sectionServicesImages);

		// Services section Heading Checking

		WebElement sectionServicesBox = driver.findElement(By
				.xpath(Constants.sectionServicesBox));
		List<WebElement> sectionServicesHeadings = driver.findElements(By
				.xpath(Constants.sectionServicesHeadingsXpath));

		List<WebElement> sectionServicesParagraphText = driver.findElements(By
				.xpath(Constants.sectionServicesParagraphTextXpath));

		TestVersion5.scrollToElement(sectionServicesBox);
		for (int i = 0; i < sectionServicesHeadings.size(); i++) {
			String textOfTheHeadings = sectionServicesHeadings.get(i).getText();
			System.out.println("The text of the element is : "
					+ textOfTheHeadings);
			String paragraphOfTheHeadings = sectionServicesParagraphText.get(i)
					.getText();
			System.out.println(paragraphOfTheHeadings);
		}

		// Aside section HEading verification
		WebElement asideSectionHeading = driver.findElement(By.xpath(Constants.asideSectionHeadingXpath));
		TestVersion5.scrollToElement(asideSectionHeading);
		TestVersion5.elementVerificationWithText(asideSectionHeading);
		
		//Footer address verification
		
		WebElement footerAddress = driver.findElement(By.xpath(Constants.footerAddressXpath));
		TestVersion5.scrollToElement(footerAddress);
		TestVersion5.elementVerificationWithText(footerAddress);
		
		// Closing the Browser with 20 seconds wait
		Thread.sleep(20L);
		driver.close();

	}

	public static void elementVerificationWithText(WebElement elementName) {
		if (elementName.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage
					+ Constants.elementText + elementName.getText());
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

}

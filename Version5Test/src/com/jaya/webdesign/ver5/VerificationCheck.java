package com.jaya.webdesign.ver5;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class VerificationCheck {

	public WebDriver driver;

	public void scrollToElement(WebElement scrollIntoElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", scrollIntoElement);
		try {
			Thread.sleep(5L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void elementVerificationWithText(WebElement elementName) {
		if (elementName.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage + Constants.elementText + elementName.getText());
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

	}

	public void elementVerification(WebElement elementName) {
		if (elementName.isDisplayed()) {
			System.out.println(Constants.elementPresentMessage);
		} else {
			System.out.println(Constants.elementNotPresentMessage);
		}

	}
}

package com.testautomation.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumUtitlities {
	
	public static void highlightTheElementInPage(WebElement element,WebDriver driver) {
		try {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element); 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

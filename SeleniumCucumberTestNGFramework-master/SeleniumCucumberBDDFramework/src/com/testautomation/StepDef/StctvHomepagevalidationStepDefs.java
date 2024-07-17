package com.testautomation.StepDef;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.testautomation.Listeners.ExtentReportListener;
import com.testautomation.PageObjects.StctvHomePage;
import com.testautomation.Utility.BrowserUtility;
import com.testautomation.Utility.SeleniumUtitlities;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StctvHomepagevalidationStepDefs extends ExtentReportListener
{
	
	private WebDriver driver;
	
	
	@Given("^Open Chrome browser with URL$")
	public void open_Chrome_browser_with_URL() throws Throwable
	{
		ExtentTest logInfo=null;
		
		
		try {
			test = extent.createTest(Feature.class, "Youtube channel name validation");							
			test=test.createNode(Scenario.class, "Youtube channel name validations");						
			logInfo=test.createNode(new GherkinKeyword("Given"), "open_Chrome_browser_with_URL");
			 		
			driver=BrowserUtility.OpenBrowser(driver,"chrome","https://subscribe.stctv.com/sa-en" );
			
			logInfo.pass("Opened chrome browser and entered url");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
			
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}		
	}
	
	@When("Click the {string} to validate the currency detail for specific subscription")
	public void click_the_sa_to_validate_the_currency_detail_for_specific_subscription(String country) {
		WebElement countrybtn = new StctvHomePage(driver).countryBtn;
		WebElement countryList = new StctvHomePage(driver).selectCountryBtn;
		WebElement saCountryBtn = new StctvHomePage(driver).countrySaudiBtn;
		WebElement bhCountryBtn = new StctvHomePage(driver).countryBahrainBtn;
		WebElement kwCountryBtn = new StctvHomePage(driver).countryKuwaitBtn;
		Assert.assertTrue(countrybtn.isDisplayed(), "The country button is not avaiable in homepage");
		SeleniumUtitlities.highlightTheElementInPage(countrybtn,driver);
		countrybtn.click();
		Assert.assertTrue(countryList.isDisplayed(), "The country list is not avaiable in homepage");
		
		if(country.equalsIgnoreCase("sa")) {
			Assert.assertTrue(saCountryBtn.isDisplayed(), "The saudi country button is not avaiable in homepage");
			SeleniumUtitlities.highlightTheElementInPage(saCountryBtn,driver);
			saCountryBtn.click();
		}else if(country.equalsIgnoreCase("kw")) {
			Assert.assertTrue(kwCountryBtn.isDisplayed(), "The Kuwait country button is not avaiable in homepage");
			SeleniumUtitlities.highlightTheElementInPage(kwCountryBtn,driver);
			kwCountryBtn.click();
		}else if(country.equalsIgnoreCase("bh")) {
			Assert.assertTrue(bhCountryBtn.isDisplayed(), "The Bharain country button is not avaiable in homepage");
			SeleniumUtitlities.highlightTheElementInPage(bhCountryBtn,driver);
			bhCountryBtn.click();
		}
	    throw new cucumber.api.PendingException();
	}
	
	@And("Validate the subscription package type for each {string}")
	public void validate_subscription_package_for_each_country(String country) {
	    
		WebElement packageLite = new StctvHomePage(driver).packageLite;
		WebElement packageClassic = new StctvHomePage(driver).packageClassic;
		WebElement packagePremium = new StctvHomePage(driver).packagePremium;
		
		verifyThePackage(packageLite,"Lite");
		verifyThePackage(packageClassic,"Classic");
		verifyThePackage(packagePremium,"Premium");
		
	    throw new cucumber.api.PendingException();
	}
	
	@Then("Validate the {string} detail for each country selected")
	public void validate_the_currency_detail_for_each_country_selected(String currency) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> priceList =new StctvHomePage(driver).countriesPrice; 
		List<WebElement> CurrencyType =new StctvHomePage(driver).countriesPriceType;
		
		for(int i=0;i<priceList.size();i++) {
			verifyTheCurrencyDetail(priceList.get(i),CurrencyType.get(i),currency);
		}
	    throw new cucumber.api.PendingException();
	}
	
	public void verifyThePackage(WebElement element,String packageName) {
		Assert.assertTrue(element.isDisplayed(), "The "+packageName+" package is not avaiable in homepage");
		SeleniumUtitlities.highlightTheElementInPage(element,driver);
		Assert.assertTrue(element.getText().equalsIgnoreCase(packageName), "The package name is incorrect in homepage");
		
	}
	
	public void verifyTheCurrencyDetail(WebElement priceList,WebElement currencyType,String currency) {
		Assert.assertTrue(priceList.isDisplayed(), "The "+priceList+" for the country is not avaiable in homepage");
		SeleniumUtitlities.highlightTheElementInPage(priceList,driver);
		Assert.assertTrue(currencyType.isDisplayed(), "The "+currency+" for the country is not avaiable in homepage");
		SeleniumUtitlities.highlightTheElementInPage(currencyType,driver);
		Assert.assertTrue(currencyType.getText().contains(currency), "The "+currency+" name does not match with country");
		
	}
}

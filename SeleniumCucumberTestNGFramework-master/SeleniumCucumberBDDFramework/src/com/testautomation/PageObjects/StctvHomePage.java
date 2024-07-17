package com.testautomation.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class StctvHomePage 
{
	WebDriver driver;
	
	public StctvHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="country-btn")
	public WebElement countryBtn;
	
	@FindBy(id="country-selct")
	public WebElement selectCountryBtn;
	
	@FindBy(id="sa")
	public WebElement countrySaudiBtn;
	
	@FindBy(id="bh")
	public WebElement countryBahrainBtn;
	
	@FindBy(id="kw")
	public WebElement countryKuwaitBtn;
	
	@FindBy(id="name-lite")
	public WebElement packageLite;
	
	@FindBy(id="name-classic")
	public WebElement packageClassic;
	
	@FindBy(id="name-premium")
	public WebElement packagePremium;
	
	@FindBy(xpath="//div[@class='price']/b")
	public List<WebElement> countriesPrice;
	
	@FindBy(xpath="//div[@class='price']/i")
	public List<WebElement> countriesPriceType;
}

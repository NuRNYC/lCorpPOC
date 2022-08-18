package objectRepos;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CareerPage {
	WebDriver driver;
	
	public CareerPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@class='ph-global-search-v3-default-theme8 ph-widget-target au-target au-target']//form[@class='phs-global-search-area phs-global-sr-container ph-widget-box ph-mobile-search-backdrop au-target']//div[@class='form-group phs-global-search ph-search-group']//div[@class='au-target input-group dropdown-close']//div[@class='job-filter ph-suggestion-focus-block ph-search-group']//div//input[@id='typehead']") 
	public WebElement topSearch;
	
	@FindBy(xpath ="//span[normalize-space()='\"QA Test Automation Developer\"']") 
	public WebElement searchResultHeading;
	
	@FindBy(xpath ="//div[@class='job-title']//span[contains(text(),'QA Test Automation Developer')]") 
	public WebElement positionTitle;
	
	@FindBy(xpath ="//h1[@class='job-title']") 
	public WebElement jobDetailsHeading;
	
	@FindBy(xpath ="//span[@class='au-target job-location']") 
	public WebElement jobLocation;
	
	@FindBy(xpath ="//span[@class='au-target jobId']") 
	public WebElement jobID;
	
	@FindBy(xpath ="//div[@class='job-description']//p[contains(text(),'Advance your Information Technology (IT) career at')]") 
	public WebElement jobDescription;
	
	@FindBy(xpath ="//div[@class='col-lg-8 col-md-8 col-sm-12']//ul[2]") 
	public WebElement underManagementUL;

	
	public void searchJob(String searchString) {
		try {
			topSearch.click();
			topSearch.sendKeys(searchString+Keys.RETURN);
			//topSearch.sendKeys(Keys.RETURN);
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}	
	}
	
	public boolean verifySearchReslHeadingDisplayed() {
		try {
			if(searchResultHeading.isDisplayed())
			    return true;
			else 
				return false;
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}
		return false;	
	}
	
	public void clickPositionTitle() {
		try {
			positionTitle.click();
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}
		
	}
	
	public boolean verifyJobDetailsHeadingDisplayed() {
		try {
			if(jobDetailsHeading.isDisplayed())
			    return true;
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}
		return false;	
	}
	
	public String getSecondElementTextof_underManagementUL() {
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='col-lg-8 col-md-8 col-sm-12']//ul[2]/li")); 
		String text= allElements.get(1).getText();
		System.out.println(allElements.get(1).getText());
		return text;
	}
	
	public String verifyThirdRequirement() {
		List<WebElement> allElements = driver.findElements(By.xpath("//div[@class='col-lg-8 col-md-8 col-sm-12']//ul[4]/li")); 
		String text= allElements.get(2).getText();
		System.out.println(allElements.get(2).getText());
		return text;
	}

}

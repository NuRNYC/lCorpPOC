package objectRepos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
	}
	
	By careers = By.xpath("//div[@id='login-container']//a[@class='no-ext ext']");
	
	public void clickOnCareerLink() {
		try {
			driver.findElement(careers).click();
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}	
	}
}

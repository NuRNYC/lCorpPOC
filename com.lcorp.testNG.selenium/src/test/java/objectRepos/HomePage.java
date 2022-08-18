package objectRepos;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//div[@id='login-container']//a[@class='no-ext ext']") public WebElement careerLink;
	

	public void clickOnCareerLinkFromMenu() {
		try {
			careerLink.click();
		} catch(Exception e) {
			System.out.println("Exception Caught "+e.getMessage());
		}	
	}
	
}

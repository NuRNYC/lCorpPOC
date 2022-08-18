package testScenarios;

import static org.testng.AssertJUnit.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepos.HomePage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	
	
	
	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTestS() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.labcorp.com/");
		
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testScenarioOne()
    {
    	HomePage hPage = new HomePage(driver);
    	hPage.clickOnCareerLink();
        assertTrue( true );
    }
    
    @AfterTest
    public void tearDown() {
    	driver.quit();
    	
    }
    
    
    
}

package testScenarios;

import static org.testng.AssertJUnit.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepos.CareerPage;
import objectRepos.HomePage;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	WebDriver driver;
	HomePage hPage;
	CareerPage cPage;
	String jobSearch="QA Test Automation Developer";
	String jobLoc= "Location\n"
			+ "Durham, North Carolina, United States of America";
	String jobID="Job Id : 21-90223_RM";
	String description="The right candidate for this role will participate in the test automation technology development and best practice models.";
	
	
	//@SuppressWarnings("deprecation")
	@BeforeTest
	public void beforeTestSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.labcorp.com/");
		
	}
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     */
    @Test
    public void testScenarioOne()
    {
    	//HomePage hPage = new HomePage(driver);
    	//hPage.clickOnCareerLink();
        //assertTrue( true );
    	hPage = new HomePage(driver);
    	System.out.println(driver.getTitle());
    	hPage.clickOnCareerLinkFromMenu();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        System.out.println(driver.getTitle());

        cPage = new CareerPage(driver);
        cPage.searchJob(jobSearch);
        cPage.verifySearchReslHeadingDisplayed();
        cPage.clickPositionTitle();
    	Assert.assertEquals(cPage.verifyJobDetailsHeadingDisplayed(), true, "Job search Heading did not displayed");
    	Assert.assertEquals(cPage.jobLocation.getText(), jobLoc);
    	Assert.assertTrue(cPage.jobID.getText().contentEquals(jobID), "Job ID did not matched");
    	System.out.println(cPage.jobLocation.getText());
    	System.out.println(cPage.jobID.getText());
    	
    	cPage.jobDescription.getText();
    	
    	//Assert.assertFalse(cPage.jobDescription.getText().contains(description), "Job description did not matched");
    	Assert.assertTrue(cPage.jobDescription.getText().contains(description), "Job description did not matched");
    }
    
    @AfterTest
    public void tearDown() {
    	driver.quit();
    	
    }
    
    
    
}

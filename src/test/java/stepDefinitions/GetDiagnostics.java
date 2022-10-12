package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class GetDiagnostics {
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	// Get Diagnostics 
	
			@And("^I enter Location '(.*)'$")
			public void enter_Location(String location) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetlocationId().sendKeys(location);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Retries '(.*)'$")
			public void enter_Retries(String retries) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetretriesId().sendKeys(retries);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Retry Interval  '(.*)'$")
			public void enter_Retry_Interval(String retryInterval) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetretryIntervalId().sendKeys(retryInterval);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Start Date '(.*)'$")
			public void enter_Start_Date(String startDate) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetstartId().sendKeys(startDate);
				//Thread.sleep(1000);

			}
			

			@And("^I enter Stop Date '(.*)'$")
			public void enter_Stop_Date(String stopDate) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetstopId().sendKeys(stopDate);
				//Thread.sleep(1000);

			}
			
			@And("^I click get Diagnostics$")
			public void get_Diagnostics() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetgetDiagnosticsButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I click diagnostics perform button$")
			public void click_Diagnostics_perform_button() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.GetgetDiagnosticsButton().click();
				//Thread.sleep(5000);

			}
			
			@Then("^User is on the task result diagnostics$")
			  public void VerifyUserOnTaskResultDiagnostics() throws InterruptedException {
					Thread.sleep(5000);
					Operations operations = new Operations(driver);
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					Assert.assertTrue(operations.GetresExist());
					driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
					
				

				}
			

}

package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class UnlockConnecrtor_UpdateFirmware {
	
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	//unlock connector
	
			@And("^I click get Unlock Connector$")
			public void get_Unlock_Connector() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetUnlockConnectorButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I click unlock connector perform button$")
			public void click_unlock_connector_perform_button() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				
				operations.Getsubmitbutton().click();
				//Thread.sleep(5000);

			}
			
			
			//Update Firmware 
			
			@And("^I click get Update Firmware$")
				public void get_Update_Firmware() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetUpdateFirmwareButton().click();
					Thread.sleep(1000);

				}
				
				
			@And("^I enter Retrieve Date '(.*)'$")
				public void enter_Retrieve_Date(String retrieveDate) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetretrieveId().sendKeys(retrieveDate);
					//Thread.sleep(1000);

				}
			
			@And("^I click perform button Update Firmware$")
			public void perform_Button_Update_Firmware() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetperformUpdateFirmwareButton();
				//Thread.sleep(1000);

			}
				

}

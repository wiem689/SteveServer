package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class ChargingProfile {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	//Clear Charging Profile 
	
			@And("^I click Clear Charging Profile$")
				public void get_Clear_Charging_Profile() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetClearChargingButton().click();
					//Thread.sleep(1000);

				}
				
			@And("^I select Filter Type '(.*)'$")
				public void Select_Filter_Type(String filterType) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					
					if(filterType.equalsIgnoreCase("ChargingProfileId")) {
						new Select(operations.GetfilterTypeId()).selectByValue("ChargingProfileId"); 
					
					}
					if(filterType.equalsIgnoreCase("OtherParameters")) {
						new Select(operations.GetfilterTypeId()).selectByValue("OtherParameters"); 
					
					}
					
					//Thread.sleep(1000);
					
					}
				
			@And("^I select Charging Profile ID '(.*)'$")
				public void Select_Charging_Profile(String chargingProfile) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					
					if(chargingProfile.equalsIgnoreCase("")) {
						new Select(operations.GetchargingProfilePkId()).selectByValue(""); 
					
					}
					if(chargingProfile.equalsIgnoreCase("")) {
						new Select(operations.GetchargingProfilePkId()).selectByValue(""); 
					
					}
					
					//Thread.sleep(1000);
					
					}
				
			@And("^I select Charging Profile Purpose '(.*)'$")
				public void Select_Charging_Profile_Purpose(String chargingProfilePurpose) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					
					if(chargingProfilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
						new Select(operations.GetchargingProfilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE"); 
					
					}
					if(chargingProfilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
						new Select(operations.GetchargingProfilePurposeId()).selectByValue("TX_DEFAULT_PROFILE"); 
					
					}if(chargingProfilePurpose.equalsIgnoreCase("TX_PROFILE")) {
						new Select(operations.GetchargingProfilePurposeId()).selectByValue("TX_PROFILE"); 
					
					}
					
					
					//Thread.sleep(1000);
					
					}
				
				
				
			@And("^I Enter Stack Level '(.*)'$")
				public void Select_Stack_Level(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetstackLevelId().sendKeys(ID);
					//Thread.sleep(1000);

				}
				
				//Set Charging Profile 
				
			@And("^I click Set Charging Profile$")
				public void get_Set_Charging_Profile() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetSetChargingButton().click();
					//Thread.sleep(1000);

				}
				

}

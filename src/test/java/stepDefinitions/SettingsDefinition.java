package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Settings;


public class SettingsDefinition {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	
	//Settings
	
			@And("^I click Settings button$")
			public void click_Settings_button() throws InterruptedException {
			
				Settings settings =new Settings(driver);
				settings.GetSettingsButton().click();
				Thread.sleep(5000);

			}
			
			@And("^I enter Heartbeat Interval '(.*)'$")
			public void enter_Heartbeat_Interval(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.Getheartbeat().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I enter Expiration '(.*)'$")
			public void enter_Expiration(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetexpirationId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I click Enable Notifications$")
			public void click_Enable_Notifications() throws InterruptedException {
			
				Settings settings =new Settings(driver);
				settings.GetenabledId().click();
				Thread.sleep(5000);

			}
			
			@And("^I enter Protocol '(.*)'$")
			public void enter_Protocol(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetprotocolId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Host '(.*)'$")
			public void enter_Host(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GethostId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I enter Port '(.*)'$")
			public void enter_Port(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetportId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Form '(.*)'$")
			public void enter_Form(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetfromId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I enter User name '(.*)'$")
			public void enter_User_name(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetusernameId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I enter Password '(.*)'$")
			public void enter_Password(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetpasswordId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			
			@And("^I enter Recipients '(.*)'$")
			public void enter_Recipients(String ID) throws InterruptedException {
		     
				Settings settings =new Settings(driver);
				settings.GetrecipientsId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
			@And("^I click charging sends Notifications$")
			public void click_charging_Notifications() throws InterruptedException {
			
				Settings settings =new Settings(driver);
				settings.GetenabledFeatures1Id().click();
				Thread.sleep(5000);

			}
			
			
			@And("^I click connector gets faulted$")
			public void click_connector_gets_faulted() throws InterruptedException {
			
				Settings settings =new Settings(driver);
				settings.GetenabledFeatures2Id().click();
				Thread.sleep(5000);

			}
			
			 
			 
			 @And("^I click JSON charging station connects$")
				public void click_ccharging_station_connects() throws InterruptedException {
				
					Settings settings =new Settings(driver);
					settings.GetenabledFeatures3Id().click();
					Thread.sleep(5000);

				}
			 
			 @And("^I click JSON charging station disconnects$")
				public void click_charging_station_disconnects() throws InterruptedException {
				
					Settings settings =new Settings(driver);
					settings.GetenabledFeatures4Id().click();
					Thread.sleep(5000);

				}

			 
			 @And("^I click charging station starts a transaction$")
				public void click_charging_starts_transaction() throws InterruptedException {
				
					Settings settings =new Settings(driver);
					settings.GetenabledFeatures5Id().click();
					Thread.sleep(5000);

				}
			 
			 @And("^I click charging station ends a transaction$")
				public void click_charging_ends_transaction() throws InterruptedException {
				
					Settings settings =new Settings(driver);
					settings.GetenabledFeatures6Id().click();
					Thread.sleep(5000);

				}
			 
			 @And("^I click change settings button$")
				public void click_Change_Settings_button() throws InterruptedException {
				
					Settings settings =new Settings(driver);
					settings.GetchangeSettingsButton().click();
					Thread.sleep(5000);

				}

}

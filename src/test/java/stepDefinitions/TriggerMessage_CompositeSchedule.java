package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class TriggerMessage_CompositeSchedule {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	
	// Trigger Message 
	
			@And("^I click Get Trigger Message$")
				public void get_Trigger_Message() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetTriggerMessageButton().click();
					//Thread.sleep(1000);

				}
				
			@And("^I select Trigger Message '(.*)'$")
				public void Select_Trigger_Message(String triggerMessage) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					if(triggerMessage.equalsIgnoreCase("BootNotification")) {
						new Select(operations.GettriggerMessageId()).selectByValue("BootNotification"); 
					
					}if(triggerMessage.equalsIgnoreCase("DiagnosticsStatusNotification")) {
						new Select(operations.GettriggerMessageId()).selectByValue("DiagnosticsStatusNotification"); 
					
					}if(triggerMessage.equalsIgnoreCase("FirmwareStatusNotification")) {
						new Select(operations.GettriggerMessageId()).selectByValue("FirmwareStatusNotification"); 
					
					}if(triggerMessage.equalsIgnoreCase("Heartbeat")) {
						new Select(operations.GettriggerMessageId()).selectByValue("Heartbeat"); 
					
					}if(triggerMessage.equalsIgnoreCase("MeterValues")) {
						new Select(operations.GettriggerMessageId()).selectByValue("MeterValues"); 
					
					}if(triggerMessage.equalsIgnoreCase("StatusNotification")) {
						new Select(operations.GettriggerMessageId()).selectByValue("StatusNotification"); 
					
					}
					
					//Thread.sleep(1000);
					
					}
			
			@And("^I click perform button put trigger msg$")
			public void click_perform_button_put_trigger_msg() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}
			
				
				//Get Composite Schedule 
				
			@And("^I Enter Composite Schedule '(.*)'$")
				public void Select_Composite_Schedule(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetdurationInSecondsId().sendKeys(ID);
					//Thread.sleep(1000);

				}
				
			@And("^I select Charging Rate Unit '(.*)'$")
				public void Select_Charging_Rate_Unit(String chargingRate) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					
					if(chargingRate.equalsIgnoreCase("-- Empty --")) {
						new Select(operations.GetchargingRateUnitId()).selectByValue(""); 
					
					}
					if(chargingRate.equalsIgnoreCase("W")) {
						new Select(operations.GetchargingRateUnitId()).selectByValue("W"); 
					
					}if(chargingRate.equalsIgnoreCase("A")) {
						new Select(operations.GetchargingRateUnitId()).selectByValue("A"); 
					
					}
					
					//Thread.sleep(1000);
					
					}
			
			
			
			@And("^I click Get Composite Schedule$")
			public void get_Composite_Schedule() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetCompositeButton().click();
				//Thread.sleep(1000);

			}
			
			
			@And("^I click perform button get composite schedule$")
			public void click_perform_button_get_composite_schedule() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}
			
			

}

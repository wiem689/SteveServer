package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class Transaction_Reset {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	
	//remote start transaction
	
			@And("^I select ConnectorId2 '(.*)'$")
			public void Select_ConnectorId2(String connectorID2) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(connectorID2.equalsIgnoreCase("Not for a specific connector")) {
					new Select(operations.GetconnectorId2()).selectByValue("0");
				}else if(connectorID2.equalsIgnoreCase("1")) {
					new Select(operations.GetconnectorId2()).selectByValue("1");
				}else if(connectorID2.equalsIgnoreCase("2")) {
					new Select(operations.GetconnectorId2()).selectByValue("2");
				}
				
				//Thread.sleep(1000);

			}
			
			@And("^I select OCPP ID Tag'(.*)'$")
			public void Select_OCPP_ID_Tag(String ocppId) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(ocppId.equalsIgnoreCase("040f0032")) {
					new Select(operations.GetidTagId()).selectByValue("040f0032");
				}else if(ocppId.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
					new Select(operations.GetidTagId()).selectByValue("7250939c52dc4d7cb59c");
				}else if(ocppId.equalsIgnoreCase("5c5e6ada")) {
					new Select(operations.GetidTagId()).selectByValue("5c5e6ada");
				}else if(ocppId.equalsIgnoreCase("9c756eda")) {
					new Select(operations.GetidTagId()).selectByValue("9c756eda");
				}
				
				//Thread.sleep(1000);

			}
			
			@And("^I click get remote start transaction$")
			public void get_remote_start_transaction() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetremotestarttransactionButton().click();
				Thread.sleep(1000);

			}
			
			@And("^I select ID of the Active Transaction '(.*)'$")
			public void Select_ID_Active_Transaction(String activeTransaction) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(activeTransaction.equalsIgnoreCase("")) {
					new Select(operations.GettransactionId()).selectByValue("");
				}
				
				//Thread.sleep(1000);

			}
			
			@And("^I click get remote stop transaction$")
			public void get_remote_stop_transaction() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetremotestoptransactionButton().click();
				//Thread.sleep(1000);

			}
			
			
			
			@And("^I click remote start transaction perform button$")
			public void click_remote_start_transaction_perform_button() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				//Thread.sleep(5000);

			}
			
			@And("^I click remote stop transaction perform button$")
			public void click_remote_stop_transaction_perform_button() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				//Thread.sleep(5000);

			}
			
			
			//Reset 
			
			@And("^I select Reset Type'(.*)'$")
			public void Select_Reset_Type(String resetType) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(resetType.equalsIgnoreCase("HARD")) {
					new Select(operations.GetresetTypeId()).selectByValue("HARD");
				}else if(resetType.equalsIgnoreCase("SOFT")) {
					new Select(operations.GetresetTypeId()).selectByValue("SOFT");
				}
				
				//Thread.sleep(1000);

			}
			
			
			

			@And("^I click get remote reset$")
			public void get_reset() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetresetButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I click reset perform button$")
			public void click_reset_perform_button() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				//Thread.sleep(5000);

			}
			

}

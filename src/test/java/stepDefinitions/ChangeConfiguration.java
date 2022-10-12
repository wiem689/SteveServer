package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class ChangeConfiguration {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	
	//change configuration 
	
			@And("^I select Key Type '(.*)'$")
			public void Select_Key_type(String keytype) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(keytype.equalsIgnoreCase("Predefined")) {
					new Select(operations.GetkeyTypeId()).selectByValue("PREDEFINED");
				}else if(keytype.equalsIgnoreCase("Custom")) {
					new Select(operations.GetkeyTypeId()).selectByValue("CUSTOM");
				}
				
				//Thread.sleep(1000);

			}
			
			@And("^I select Configuration Key '(.*)'$")
			public void Select_Configuration_Key(String configkey) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(configkey.equalsIgnoreCase("AllowOfflineTxForUnknownId")) {
					new Select(operations.GetconfKeyId()).selectByValue("AllowOfflineTxForUnknownId");
				}else if(configkey.equalsIgnoreCase("AuthorizationCacheEnabled")) {
					new Select(operations.GetconfKeyId()).selectByValue("AuthorizationCacheEnabled");
				}else if(configkey.equalsIgnoreCase("AuthorizeRemoteTxRequests")) {
					new Select(operations.GetconfKeyId()).selectByValue("AuthorizeRemoteTxRequests");
				}else if(configkey.equalsIgnoreCase("BlinkRepeat")) {
					new Select(operations.GetconfKeyId()).selectByValue("BlinkRepeat");
				}else if(configkey.equalsIgnoreCase("ClockAlignedDataInterval")) {
					new Select(operations.GetconfKeyId()).selectByValue("ClockAlignedDataInterval");
				}else if(configkey.equalsIgnoreCase("ConnectionTimeOut")) {
					new Select(operations.GetconfKeyId()).selectByValue("ConnectionTimeOut");
				}else if(configkey.equalsIgnoreCase("ConnectorPhaseRotation")) {
					new Select(operations.GetconfKeyId()).selectByValue("ConnectorPhaseRotation");
				}else if(configkey.equalsIgnoreCase("HeartbeatInterval")) {
					new Select(operations.GetconfKeyId()).selectByValue("HeartbeatInterval");
				}else if(configkey.equalsIgnoreCase("LightIntensity")) {
					new Select(operations.GetconfKeyId()).selectByValue("LightIntensity");
				}else if(configkey.equalsIgnoreCase("LocalAuthListEnabled")) {
					new Select(operations.GetconfKeyId()).selectByValue("LocalAuthListEnabled");
				}else if(configkey.equalsIgnoreCase("LocalAuthorizeOffline")) {
					new Select(operations.GetconfKeyId()).selectByValue("LocalAuthorizeOffline");
				}else if(configkey.equalsIgnoreCase("LocalPreAuthorize")) {
					new Select(operations.GetconfKeyId()).selectByValue("LocalPreAuthorize");
				}else if(configkey.equalsIgnoreCase("MaxEnergyOnInvalidId")) {
					new Select(operations.GetconfKeyId()).selectByValue("MaxEnergyOnInvalidId");
				}else if(configkey.equalsIgnoreCase("MeterValueSampleInterval")) {
					new Select(operations.GetconfKeyId()).selectByValue("MeterValueSampleInterval");
				}else if(configkey.equalsIgnoreCase("MeterValuesAlignedData")) {
					new Select(operations.GetconfKeyId()).selectByValue("MeterValuesAlignedData");
				}else if(configkey.equalsIgnoreCase("MeterValuesSampledData")) {
					new Select(operations.GetconfKeyId()).selectByValue("MeterValuesSampledData");
				}else if(configkey.equalsIgnoreCase("MinimumStatusDuration")) {
					new Select(operations.GetconfKeyId()).selectByValue("MinimumStatusDuration");
				}else if(configkey.equalsIgnoreCase("ResetRetries")) {
					new Select(operations.GetconfKeyId()).selectByValue("ResetRetries");
				}else if(configkey.equalsIgnoreCase("StopTransactionOnEVSideDisconnect")) {
					new Select(operations.GetconfKeyId()).selectByValue("StopTransactionOnEVSideDisconnect");
				}else if(configkey.equalsIgnoreCase("StopTransactionOnInvalidId")) {
					new Select(operations.GetconfKeyId()).selectByValue("StopTransactionOnInvalidId");
				}else if(configkey.equalsIgnoreCase("StopTxnAlignedData")) {
					new Select(operations.GetconfKeyId()).selectByValue("StopTxnAlignedData");
				}else if(configkey.equalsIgnoreCase("StopTxnSampledData")) {
					new Select(operations.GetconfKeyId()).selectByValue("StopTxnSampledData");
				}else if(configkey.equalsIgnoreCase("TransactionMessageAttempts")) {
					new Select(operations.GetconfKeyId()).selectByValue("TransactionMessageAttempts");
				}else if(configkey.equalsIgnoreCase("TransactionMessageRetryInterval")) {
					new Select(operations.GetconfKeyId()).selectByValue("TransactionMessageRetryInterval");
				}else if(configkey.equalsIgnoreCase("UnlockConnectorOnEVSideDisconnect")) {
					new Select(operations.GetconfKeyId()).selectByValue("UnlockConnectorOnEVSideDisconnect");
				}else if(configkey.equalsIgnoreCase("WebSocketPingInterval")) {
					new Select(operations.GetconfKeyId()).selectByValue("WebSocketPingInterval");
				}
				
				
				
				//Thread.sleep(1000);

			}
			
			
			
			@And("^I enter Value '(.*)'$")
			public void enter_value(String value) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetvalueId().sendKeys(value);
				//Thread.sleep(1000);

			}
			
			@And("^I enter Custom Configuration Key '(.*)'$")
			public void enter_costum_config_key(String constumConfig) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetcustomConfKeyId().sendKeys(constumConfig);
				//Thread.sleep(1000);
	       
			}
			
			@And("^I click change configuration$")
			public void change_configuration() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetchangeConfigButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I click perform button change configuration$")
			public void click_perform_button_change_configuration() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}
			

}

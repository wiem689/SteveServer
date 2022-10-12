package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class DataTransfer_GetConfiguration {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	//Data Transfer 
	
			@And("^I Enter Vendor ID '(.*)'$")
				public void Select_vendor_id(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);                    
					operations.GetvendorId().sendKeys(ID);
					//Thread.sleep(1000);
		 
				}
			
			@And("^I Enter Message ID '(.*)'$")
				public void Select_Message_id(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetmessageId().sendKeys(ID);
					//Thread.sleep(1000);

				}
				
			@And("^I Enter Data '(.*)'$")
				public void Select_Data(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetdataId().sendKeys(ID);
					//Thread.sleep(1000);

				}
				
			@And("^I click data transfer$")
				public void get_data_transfer() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetDataTransferButton().click();         
					//Thread.sleep(1000);

				}
			
			@And("^I click perform button data transfer$")
			public void click_perform_button_data_transfer() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}
				
				//Get Configuration
				
			@And("^I click get configuration$")
				public void get_configuration() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetConfigurationButton().click();         
					//Thread.sleep(1000);

				}
				
			@And("^I click all parameters$")
				public void Select_parameters() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetSelectAllButton2().click();
					//Thread.sleep(1000);
				
				}
				
			@And("^I click none parameters$")
				public void Select_none_parameters() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetSelectNoneButton2().click();
					//Thread.sleep(1000);

				}
				
			@And("^I select parameters '(.*)'$")
				public void Select_Parameters_List(String parametersSelectList) throws InterruptedException {
				
					Operations operations =new Operations(driver);
					if(parametersSelectList.equalsIgnoreCase("AllowOfflineTxForUnknownId")) {
						new Select(operations.GetconfKeyListId()).selectByValue("AllowOfflineTxForUnknownId"); 
					
					}if(parametersSelectList.equalsIgnoreCase("AuthorizationCacheEnabled")) {
						new Select(operations.GetconfKeyListId()).selectByValue("AuthorizationCacheEnabled"); 
					
					}if(parametersSelectList.equalsIgnoreCase("AuthorizeRemoteTxRequests")) {
						new Select(operations.GetconfKeyListId()).selectByValue("AuthorizeRemoteTxRequests"); 
					
					}if(parametersSelectList.equalsIgnoreCase("BlinkRepeat")) {
						new Select(operations.GetconfKeyListId()).selectByValue("BlinkRepeat"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ChargeProfileMaxStackLevel")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ChargeProfileMaxStackLevel"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ChargingScheduleAllowedChargingRateUnit")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ChargingScheduleAllowedChargingRateUnit"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ChargingScheduleMaxPeriods")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ChargingScheduleMaxPeriods"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ClockAlignedDataInterval")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ClockAlignedDataInterval"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ConnectionTimeOut")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ConnectionTimeOut"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ConnectorPhaseRotation")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ConnectorPhaseRotation"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ConnectorPhaseRotationMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ConnectorPhaseRotationMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ConnectorSwitch3to1PhaseSupported")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ConnectorSwitch3to1PhaseSupported"); 
					
					}if(parametersSelectList.equalsIgnoreCase("GetConfigurationMaxKeys")) {
						new Select(operations.GetconfKeyListId()).selectByValue("GetConfigurationMaxKeys"); 
					
					}if(parametersSelectList.equalsIgnoreCase("HeartbeatInterval")) {
						new Select(operations.GetconfKeyListId()).selectByValue("HeartbeatInterval"); 
					
					}if(parametersSelectList.equalsIgnoreCase("LightIntensity")) {
						new Select(operations.GetconfKeyListId()).selectByValue("LightIntensity"); 
					
					}if(parametersSelectList.equalsIgnoreCase("LocalAuthListEnabled")) {
						new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthListEnabled"); 
					
					}if(parametersSelectList.equalsIgnoreCase("LocalAuthListMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthListMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("LocalAuthorizeOffline")) {
						new Select(operations.GetconfKeyListId()).selectByValue("LocalAuthorizeOffline"); 
					
					}if(parametersSelectList.equalsIgnoreCase("LocalPreAuthorize")) {
						new Select(operations.GetconfKeyListId()).selectByValue("LocalPreAuthorize"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MaxChargingProfilesInstalled")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MaxChargingProfilesInstalled"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MaxEnergyOnInvalidId")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MaxEnergyOnInvalidId"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MeterValueSampleInterval")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MeterValueSampleInterval"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MeterValuesAlignedData")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesAlignedData"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MeterValuesAlignedDataMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesAlignedDataMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MeterValuesSampledData")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesSampledData"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MeterValuesSampledDataMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MeterValuesSampledDataMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("MinimumStatusDuration")) {
						new Select(operations.GetconfKeyListId()).selectByValue("MinimumStatusDuration"); 
					
					}if(parametersSelectList.equalsIgnoreCase("NumberOfConnectors")) {
						new Select(operations.GetconfKeyListId()).selectByValue("NumberOfConnectors"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ReserveConnectorZeroSupported")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ReserveConnectorZeroSupported"); 
					
					}if(parametersSelectList.equalsIgnoreCase("ResetRetries")) {
						new Select(operations.GetconfKeyListId()).selectByValue("ResetRetries"); 
					
					}if(parametersSelectList.equalsIgnoreCase("SendLocalListMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("SendLocalListMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTransactionOnEVSideDisconnect")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTransactionOnEVSideDisconnect"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTransactionOnInvalidId")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTransactionOnInvalidId"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTxnAlignedData")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTxnAlignedData"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTxnAlignedDataMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTxnAlignedDataMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTxnSampledData")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTxnSampledData"); 
					
					}if(parametersSelectList.equalsIgnoreCase("StopTxnSampledDataMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("StopTxnSampledDataMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("SupportedFeatureProfiles")) {
						new Select(operations.GetconfKeyListId()).selectByValue("SupportedFeatureProfiles"); 
					
					}if(parametersSelectList.equalsIgnoreCase("SupportedFeatureProfilesMaxLength")) {
						new Select(operations.GetconfKeyListId()).selectByValue("SupportedFeatureProfilesMaxLength"); 
					
					}if(parametersSelectList.equalsIgnoreCase("SupportedFileTransferProtocols")) {
						new Select(operations.GetconfKeyListId()).selectByValue("SupportedFileTransferProtocols"); 
					
					}if(parametersSelectList.equalsIgnoreCase("TransactionMessageAttempts")) {
						new Select(operations.GetconfKeyListId()).selectByValue("TransactionMessageAttempts"); 
					
					}if(parametersSelectList.equalsIgnoreCase("TransactionMessageRetryInterval")) {
						new Select(operations.GetconfKeyListId()).selectByValue("TransactionMessageRetryInterval"); 
					
					}if(parametersSelectList.equalsIgnoreCase("UnlockConnectorOnEVSideDisconnect")) {
						new Select(operations.GetconfKeyListId()).selectByValue("UnlockConnectorOnEVSideDisconnect"); 
					
					}if(parametersSelectList.equalsIgnoreCase("WebSocketPingInterval")) {
						new Select(operations.GetconfKeyListId()).selectByValue("WebSocketPingInterval"); 
					
					}
					
					
					//Thread.sleep(1000);

				}
				
			@And("^I Enter Custom Config Key '(.*)'$")
				public void Select_Custom_Config(String ID) throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetcommaSeparatedCustomConfKeysId().sendKeys(ID);
					//Thread.sleep(1000);

				}
				
			@And("^I click perform button get Configuration$")
			public void click_perform_button_get_configuration() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}
				

}

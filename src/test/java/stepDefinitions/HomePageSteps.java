package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.Data_Management;
import pageObjects.HomePage;
import pageObjects.Operations;
import pageObjects.Settings;

public class HomePageSteps {
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;

	
	//Login
	
	
	@Given("^user is on login Page$")
	public void user_is_on_login_Page() throws Throwable {

		pageObjectManager = new PageObjectManager(driver);
		driver = pageObjectManager.getDriver();
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();
	}
	
	
	
	@When("^the user put username$")
	public void the_user_put_username() throws Throwable {
		homePage.enter_Username();
	}

	@And("^enter password$")
	public void Enterpassword() throws InterruptedException {
		homePage.GetPasswordInput().sendKeys("1234");
		Thread.sleep(2000);

	}
	
	
	@And("^I click singnin button$")
	public void click_signIn_Button() throws Throwable {
	  homePage.GetSigninButton();
	}
    
	@Then("^the user is connected$")
	public void VerifyUserConnected() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.GettileWrapperExist());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}
	
	
	//LogOut
	
	@And("^I click LogOut$")
	public void Click_Logout() throws InterruptedException {
     
		HomePage homePage =new HomePage(driver);
		homePage.GetsignOutButton().click();
		Thread.sleep(1000);

	}
	

	@Then("^verify signOut$")
	public void verify_singOut() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.GetuserInputExist());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}
	
	@Then("^user connetcted and verify logOut exist$")
	public void verify_singOut_Exist() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.GetsignOutButtonsExist());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}
	
	
	
	//About
	
	
	@And("^I click about button$")
	public void Click_about_button() throws InterruptedException {
     
		HomePage homePage =new HomePage(driver);
		homePage.GetaboutButton().click();
		Thread.sleep(1000);

	}
	
	
	@Then("^display the about interface$")
	public void display_about_interface() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.GetcontentExist());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	
	}
	

	
	
	//operations
	
		//change availability 
		
	@And("^I click on operations V1.6 button$")
		public void Click_operation_button() throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			Actions actions = new Actions(driver);

			actions.moveToElement(operations.GetaOperationButton1());
			actions.perform();
			operations.GetaOperationButton().click();
			//Thread.sleep(1000);

		}
		
	@And("^I select charge point '(.*)'$")
		public void Select_charge_point_list(String chargePointSelectList) throws InterruptedException {
		
			Operations operations =new Operations(driver);
			if(chargePointSelectList.equalsIgnoreCase("wiem")) {
				new Select(operations.GetchargePointSelectListId()).selectByValue("JSON;wiem;-"); 
			
			}
			
			//Thread.sleep(1000);

		}
		
	@And("^I click all charge point$")
		public void Select_charge_point() throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			operations.GetSelectAllButton().click();
			//Thread.sleep(1000);

		}
		
	@And("^I click none charge point$")
		public void Select_none_charge_point() throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			operations.GetSelectNoneButton().click();
			//Thread.sleep(1000);

		}
		
	@And("^I select connecter ID '(.*)'$")
		public void Select_connector_id(String ID) throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			operations.GetconnectorId().sendKeys(ID);
			//Thread.sleep(1000);

		}
		
	@And("^I select availability Type '(.*)'$")
		public void Select_availability_type(String availtype) throws InterruptedException {
		
			Operations operations =new Operations(driver);
			if(availtype.equalsIgnoreCase("INOPERATIVE")) {
				new Select(operations.GetavailType()).selectByValue("INOPERATIVE");
			}else if(availtype.equalsIgnoreCase("OPERATIVE")) {
				new Select(operations.GetavailType()).selectByValue("OPERATIVE");
			}
			
			//Thread.sleep(1000);

		}
		
	@And("^I click perform button$")
		public void click_perform_button() throws InterruptedException {
		
			Operations operations =new Operations(driver);
			operations.Getsubmitbutton().click();
			Thread.sleep(5000);

		}
		
		
		@Then("^User is on the task result$")
	  public void VerifyUserOnTaskResult() throws InterruptedException {
			Thread.sleep(5000);
			Operations operations = new Operations(driver);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Assert.assertTrue(operations.GetcpdExist());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		

		}
		
		
		
		
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
		
		
		//unlock connector
		
		@And("^I click get Unlock Connector$")
		public void get_Unlock_Connector() throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			operations.GetUnlockConnectorButton().click();
			//Thread.sleep(1000);

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
			
			// Reservation Now 
			
		@And("^I click reservation now$")
			public void get_Reservation_Now() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetReserveNowButton().click();
				//Thread.sleep(1000);

			}
			
		@And("^I enter expiry Date '(.*)'$")
			public void enter_Expiry_Date(String expiryDate) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetexpiryId().sendKeys(expiryDate);
				//Thread.sleep(1000);

			}
			
		@And("^I click cancel reservation$")
			public void get_Cancel_Reservation() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetCancelReservationButton().click();
				//Thread.sleep(1000);

			}
			
		@And("^I select Existing Reservation '(.*)'$")
			public void Select_Existing_Reservation(String existingReservation) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(existingReservation.equalsIgnoreCase("")) {
					new Select(operations.GetreservationId()).selectByValue("");
				}
				
				//Thread.sleep(1000);

			}
		
		
		@And("^I click perform reservation button$")
		public void perform_Button_Reservation() throws InterruptedException {
	     
			Operations operations =new Operations(driver);
			operations.GetperformReservationButton().click();
			Thread.sleep(1000);

		}
		
		
			
			
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
			
			
			//Get Local List Version 
			
		@And("^I click get Local List Version$")
			public void get_Local_List() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetLocalListVersionButton().click();         
				//Thread.sleep(1000);

			}
			
			//set local list version 
			
		@And("^I click set Local List Version$")
			public void set_Local_List() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.SetLocalListVersionButton().click();         
				//Thread.sleep(1000);

			}
			

		@And("^I Enter List Version '(.*)'$")
			public void Select_List_Version(String ID) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetlistVersionId().sendKeys(ID);
				//Thread.sleep(1000);

			}
			
		@And("^I select Get Update Type'(.*)'$")
			public void Select_Update_Type(String updateType) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(updateType.equalsIgnoreCase("DIFFERENTIAL")) {
					new Select(operations.GetupdateTypeId()).selectByValue("DIFFERENTIAL");
				}else if(updateType.equalsIgnoreCase("FULL")) {
					new Select(operations.GetupdateTypeId()).selectByValue("FULL");
				}
				
				//Thread.sleep(1000);

			}
			
		@And("^I select Add Update List '(.*)'$")
			public void Select_Add_Update_list(String addUpdaterList) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(addUpdaterList.equalsIgnoreCase("040f0032")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("040f0032"); 
				
				}if(addUpdaterList.equalsIgnoreCase("4b1f32bb")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("4b1f32bb"); 
				
				}if(addUpdaterList.equalsIgnoreCase("5392461f")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("5392461f"); 
					
				
				}if(addUpdaterList.equalsIgnoreCase("5c5e6ada")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("5c5e6ada"); 
					
				
				}if(addUpdaterList.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("7250939c52dc4d7cb59c"); 
					
				
				}if(addUpdaterList.equalsIgnoreCase("9c756eda")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("9c756eda"); 
					
				
				}if(addUpdaterList.equalsIgnoreCase("A0-00-00-00")) {
					new Select(operations.GetaddUpdateListId()).selectByValue("A0-00-00-00"); 
					
				
				}
				
				
				//Thread.sleep(1000);

			}
			
		@And("^I select Delete List '(.*)'$")
			public void Select_Delete_list(String deleteList) throws InterruptedException {
			
				Operations operations =new Operations(driver);
				if(deleteList.equalsIgnoreCase("040f0032")) {
					new Select(operations.GetdeleteListId()).selectByValue("040f0032"); 
				
				}if(deleteList.equalsIgnoreCase("4b1f32bb")) {
					new Select(operations.GetdeleteListId()).selectByValue("4b1f32bb"); 
				
				}if(deleteList.equalsIgnoreCase("5392461f")) {
					new Select(operations.GetdeleteListId()).selectByValue("5392461f"); 
					
				
				}if(deleteList.equalsIgnoreCase("5c5e6ada")) {
					new Select(operations.GetdeleteListId()).selectByValue("5c5e6ada"); 
					
				
				}if(deleteList.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
					new Select(operations.GetdeleteListId()).selectByValue("7250939c52dc4d7cb59c"); 
					
				
				}if(deleteList.equalsIgnoreCase("9c756eda")) {
					new Select(operations.GetdeleteListId()).selectByValue("9c756eda"); 
					
				
				}if(deleteList.equalsIgnoreCase("A0-00-00-00")) {
					new Select(operations.GetdeleteListId()).selectByValue("A0-00-00-00"); 
					
				
				}
				
				
				//Thread.sleep(1000);

			}
			
		@And("^I click send empty list$")
			public void send_Empty_List() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetsendEmptyListWhenFullId().click();
				//Thread.sleep(1000);

			}
		
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
		 
		 
		 
		 
		 
		 //Data_Management
		 
		 @And("^I click on data management charge points button$")
			public void Click_management_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetmanagementButton().click();
				//Thread.sleep(1000);

			}
		 
		 
		 
		 @And("^I enter ChargeBox ID '(.*)'$")
			public void enter_value_charge_box(String chargeBox) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetchargeBoxId().sendKeys(chargeBox);
				Thread.sleep(1000);

			}
		
		
		 @And("^I enter Description '(.*)'$")
			public void enter_description(String description) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetdescriptionId().sendKeys(description);
				Thread.sleep(1000);

			}
		
			
			
		 @And("^I select Ocpp Version '(.*)'$")
			public void Select_OcppVersion(String ocppVersion) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(ocppVersion.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetocppVersionId()).selectByValue("");
				}
				if(ocppVersion.equalsIgnoreCase("ocpp1.2")) {
					new Select(dataManagement.GetocppVersionId()).selectByValue("V_12");
				}if(ocppVersion.equalsIgnoreCase("ocpp1.5")) {
					new Select(dataManagement.GetocppVersionId()).selectByValue("V_15");
				}if(ocppVersion.equalsIgnoreCase("ocpp1.6")) {
					new Select(dataManagement.GetocppVersionId()).selectByValue("V_16");
				}
				
				Thread.sleep(1000);

			}
		 
		 @And("^I select heartbeatPeriod '(.*)'$")
			public void Select_heartbeatPeriod(String heartbeatPeriod) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(heartbeatPeriod.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("ALL");
				}
				if(heartbeatPeriod.equalsIgnoreCase("Today")) {
					new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("TODAY");
				}if(heartbeatPeriod.equalsIgnoreCase("Yesterday")) {
					new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("YESTERDAY");
				}if(heartbeatPeriod.equalsIgnoreCase("Earlier")) {
					new Select(dataManagement.GetheartbeatPeriodId()).selectByValue("EARLIER");
				}
				
				Thread.sleep(1000);

			}
			
			
			
		 @And("^I click Get button$")
			public void click_get_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetButton().click();
				Thread.sleep(5000);

			}
			
			
			@Then("^User in charge point result$")
		  public void VerifyUserOnChargePointResult() throws InterruptedException {
				Thread.sleep(5000);
				Data_Management dataManagement =new Data_Management(driver);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertTrue(dataManagement.GetresActionExist());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			

			}
			
			@And("^I click AddNew button$")
			public void click_AddNew_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetAddNewButton().click();
				Thread.sleep(5000);

			}
			
			
			@Then("^User in add charge point result$")
		  public void VerifyUserOnAddChargerPointResult() throws InterruptedException {
				Thread.sleep(5000);
				Data_Management dataManagement =new Data_Management(driver);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertTrue(dataManagement.GetuserInputExist());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			

			}
			
			
		//Add new Charge point 
			
			
			@And("^I click Insert connector status$")
			public void click_insert_connector_status() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetinsertConnectorStatusAfterTransactionMsg1Id().click();
				Thread.sleep(5000);

			}
			
			
			@And("^I select Registration status '(.*)'$")
			public void Select_RegistrationStatus(String registrationStatus) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(registrationStatus.equalsIgnoreCase("Accepted")) {
					new Select(dataManagement.GetregistrationStatusId()).selectByValue("Accepted");
				}
				if(registrationStatus.equalsIgnoreCase("Rejected")) {
					new Select(dataManagement.GetregistrationStatusId()).selectByValue("Rejected");
				}
				
				Thread.sleep(1000);

			}
			
			@And("^I enter Street '(.*)'$")
			public void enter_Street(String street) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddressStreetId().sendKeys(street);
				Thread.sleep(1000);

			}
			
			@And("^I enter House Number '(.*)'$")
			public void enter_House_Number(String houseNumber) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddressHouseNumberId().sendKeys(houseNumber);
				Thread.sleep(1000);

			}

		
			@And("^I enter Zip code '(.*)'$")
			public void enter_Zip_Code(String zipCode) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddressZipCodeId().sendKeys(zipCode);
				Thread.sleep(1000);

			}
			
			@And("^I enter City '(.*)'$")
			public void enter_City(String City) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddressCityId().sendKeys(City);
				Thread.sleep(1000);

			}
			
			@And("^I select Country '(.*)'$")
			public void Select_Country(String country) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(country.equalsIgnoreCase("Afghanistan")) {
					new Select(dataManagement.GetaddressCountryId()).selectByValue("AF");
				}
				if(country.equalsIgnoreCase("American Samoa")) {
					new Select(dataManagement.GetaddressCountryId()).selectByValue("AS");
				}if(country.equalsIgnoreCase("Albania")) {
					new Select(dataManagement.GetaddressCountryId()).selectByValue("AL");
				}
				
				
				Thread.sleep(1000);

			}
			
			@And("^I enter Admin Address '(.*)'$")
			public void enter_Admin_Address(String adminAdress) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetadminAddressId().sendKeys(adminAdress);
				Thread.sleep(1000);

			}
			
			@And("^I enter Latitude '(.*)'$")
			public void enter_Latitude(String latitude) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetlocationLatitudeId().sendKeys(latitude);
				Thread.sleep(1000);

			}
			
			@And("^I enter Longitude '(.*)'$")
			public void enter_Longitude(String longitude) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetlocationLongitudeId().sendKeys(longitude);
				Thread.sleep(1000);

			}
			
			@And("^I enter Additional Note '(.*)'$")
			public void enter_Additional_Note(String additionalNote) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetnoteId().sendKeys(additionalNote);
				Thread.sleep(1000);

			}
			
			@And("^I click Add button$")
			public void click_Add_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetAddButton().click();
				Thread.sleep(5000);

			}
			
			@And("^I click Add New Charge points button$")
			public void click_Add_New_Charge_Points_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetAddNewChargePointsButton().click();
				Thread.sleep(5000);

			}
			
			
			@And("^I click Back To Overview button$")
			public void click_Back_To_Overview_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetbackToOverviewButton().click();
				Thread.sleep(5000);

			}
			
			
			@And("^I click Delete button$")
			public void click_Delete_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetredSubmitButton().click();
				Thread.sleep(5000);

			}
			
			//Occp Tags 
			
			@And("^I click on data management Occp Tags  button$")
			public void Click_management_Occp_Tags_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetoccpButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I select Id Tag '(.*)'$")
			public void Select_Id_Tag(String idTag) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(idTag.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetidTagId()).selectByValue("");
					
				}if(idTag.equalsIgnoreCase("040f0032")) {
					new Select(dataManagement.GetidTagId()).selectByValue("040f0032");
				}if(idTag.equalsIgnoreCase("4b1f32bb")) {
					new Select(dataManagement.GetidTagId()).selectByValue("4b1f32bb");
				}if(idTag.equalsIgnoreCase("5392461f")) {
					new Select(dataManagement.GetidTagId()).selectByValue("5392461f");
				}if(idTag.equalsIgnoreCase("5c5e6ada")) {
					new Select(dataManagement.GetidTagId()).selectByValue("5c5e6ada");
				}if(idTag.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
					new Select(dataManagement.GetidTagId()).selectByValue("7250939c52dc4d7cb59c");
				}if(idTag.equalsIgnoreCase("9c756eda")) {
					new Select(dataManagement.GetidTagId()).selectByValue("9c756eda");
				}if(idTag.equalsIgnoreCase("A0-00-00-00")) {
					new Select(dataManagement.GetidTagId()).selectByValue("A0-00-00-00");
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Parent ID Tag '(.*)'$")
			public void Select_Parent_Id_Tag(String idParentTag) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(idParentTag.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetparentIdTagId()).selectByValue("");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Expired '(.*)'$")
			public void Select_Expired(String expired) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(expired.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetExpiredId()).selectByValue("ALL");
					
				}if(expired.equalsIgnoreCase("True")) {
					new Select(dataManagement.GetExpiredId()).selectByValue("TRUE");
				}if(expired.equalsIgnoreCase("False")) {
					new Select(dataManagement.GetExpiredId()).selectByValue("FALSE");
				}
				
				
				
				Thread.sleep(1000);

			}
			
			
			@And("^I select In Transaction '(.*)'$")
			public void Select_In_Transaction(String inTransaction) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(inTransaction.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetinTransactionId()).selectByValue("ALL");
					
				}if(inTransaction.equalsIgnoreCase("True")) {
					new Select(dataManagement.GetinTransactionId()).selectByValue("TRUE");
				}if(inTransaction.equalsIgnoreCase("False")) {
					new Select(dataManagement.GetinTransactionId()).selectByValue("FALSE");
				}
				
				
				
				Thread.sleep(1000);

			}
			
			
			@And("^I select Blocked '(.*)'$")
			public void Select_Blocked(String blocked) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(blocked.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetblockedId()).selectByValue("ALL");
					
				}if(blocked.equalsIgnoreCase("True")) {
					new Select(dataManagement.GetblockedId()).selectByValue("TRUE");
				}if(blocked.equalsIgnoreCase("False")) {
					new Select(dataManagement.GetblockedId()).selectByValue("FALSE");
				}
				
				
				
				Thread.sleep(1000);

			}
			
			//add new occp form
			
			
			@Then("^User in add Occp$")
		  public void VerifyUserOnAddOccp() throws InterruptedException {
				Thread.sleep(5000);
				Data_Management dataManagement =new Data_Management(driver);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertTrue(dataManagement.GetocppTagFormIdExist());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			

			}
			
			
			
			@And("^I enter new idTag '(.*)'$")
			public void enter_new_idTag(String newIdTag) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetidTagId().sendKeys(newIdTag);
				Thread.sleep(1000);

			}
			
			
			@And("^I enter New Expiry Date Time '(.*)'$")
			public void enter_new_Expiry_Date_Time (String newExpiryDateTime) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetexpirationId().sendKeys(newExpiryDateTime);
				Thread.sleep(1000);

			}
			
			
			@And("^I enter New Max Active Transaction Count '(.*)'$")
			public void enter_new_Max_Active_Transaction (String newActiveTransaction) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetmaxActiveTransactionCountId().sendKeys(newActiveTransaction);
				Thread.sleep(1000);

			}
			
			
			@And("^I click ADD occp button$")
			public void click_Add_OCCP_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddOccpButton().click();
				Thread.sleep(5000);

			}
			
			
			//Users 
			
			@And("^I click on data management Users button$")
			public void Click_management_Users_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetusersManagementButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I enter User ID '(.*)'$")
			public void enter_User_ID (String userId) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetuserPkId().sendKeys(userId);
				Thread.sleep(1000);

			}
			
			@And("^I enter Ocpp ID Tag '(.*)'$")
			public void enter_Occp_ID_Tag (String occpIdTag) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetocppIdTagId().sendKeys(occpIdTag);
				Thread.sleep(1000);

			}
			
			
			@And("^I enter name '(.*)'$")
			public void enter_Name (String name) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetnameId().sendKeys(name);
				Thread.sleep(1000);

			}
			
		
			
			
			@And("^I enter email '(.*)'$")
			public void enter_Email (String email) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetemailId().sendKeys(email);
				Thread.sleep(1000);

			}
			 
	              //same button GET
			      //same Add Button
			
			
			//Add New User Form 
			
			@And("^I enter firstName '(.*)'$")
			public void enter_FirstName (String firstName) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetfirstNameId().sendKeys(firstName);
				Thread.sleep(1000);

			}
			 
			@And("^I enter Last name '(.*)'$")
			public void enter_Last_Name (String lastName) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetlastNameId().sendKeys(lastName);
				Thread.sleep(1000);

			}

			@And("^I enter Birthday '(.*)'$")
			public void enter_Birthday (String birthday) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetbirthDayId().sendKeys(birthday);
				Thread.sleep(1000);

			}
			
			
			@And("^I select Sex '(.*)'$")
			public void Select_Sex(String sex) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(sex.equalsIgnoreCase("Female")) {
					new Select(dataManagement.GetsexId()).selectByValue("FEMALE");
					
				}if(sex.equalsIgnoreCase("Male")) {
					new Select(dataManagement.GetsexId()).selectByValue("MALE");
				}if(sex.equalsIgnoreCase("Other")) {
					new Select(dataManagement.GetsexId()).selectByValue("OTHER");
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I enter phone '(.*)'$")
			public void enter_Phone (String phone) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetphoneId().sendKeys(phone);
				Thread.sleep(1000);

			}
			
			@And("^I enter E-mail '(.*)'$")
			public void enter_E_mail(String email) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GeteMailId().sendKeys(email);
				Thread.sleep(1000);

			}
			
			//same note and adress infos 
			
			@And("^I select OccpTagIdUser '(.*)'$")
			public void Select_Occp_Tag_Id_User(String OccpTagId) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(OccpTagId.equalsIgnoreCase("-- Empty --")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("");
					
				}if(OccpTagId.equalsIgnoreCase("4b1f32bb")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("4b1f32bb");
					
				}if(OccpTagId.equalsIgnoreCase("040f0032")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("040f0032");
					
				}if(OccpTagId.equalsIgnoreCase("5392461f")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("5392461f");
					
				}if(OccpTagId.equalsIgnoreCase("5c5e6ada")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("5c5e6ada");
					
				}if(OccpTagId.equalsIgnoreCase("7250939c52dc4d7cb59c")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("7250939c52dc4d7cb59c");
					
				}if(OccpTagId.equalsIgnoreCase("A0-00-00-00")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("A0-00-00-00");
					
				}if(OccpTagId.equalsIgnoreCase("9c756eda")) {
					new Select(dataManagement.GetocppIdTagId()).selectByValue("9c756eda");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			//Same buttons  add and overtoview
			

			
			
			
			//Charging profile 
			
			@And("^I click on data management Charging Profiles button$")
			public void Click_management_Charging_Profile_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetChargingProfilesButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I enter Charging Profile Id '(.*)'$")
			public void enter_Charging_Profile_Id(String chargingProfileId) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetchargingProfilePkId().sendKeys(chargingProfileId);
				Thread.sleep(1000);

			}
			
			
			
			
			@And("^I enter Stack Level '(.*)'$")
			public void enter_Stack_Level(String stackLevel) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetstackLevelId().sendKeys(stackLevel);
				Thread.sleep(1000);

			}
			
			@And("^I select Profile Purpose '(.*)'$")
			public void Select_Profile_Purpose(String profilePurpose) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(profilePurpose.equalsIgnoreCase("-- Empty --")) {
					new Select(dataManagement.GetprofilePurposeId()).selectByValue("");
					
				}if(profilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
					new Select(dataManagement.GetprofilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE");
					
				}if(profilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
					new Select(dataManagement.GetprofilePurposeId()).selectByValue("TX_DEFAULT_PROFILE");
					
				}if(profilePurpose.equalsIgnoreCase("TX_PROFILE")) {
					new Select(dataManagement.GetprofilePurposeId()).selectByValue("TX_PROFILE");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Profile Kind '(.*)'$")
			public void Select_Profile_Kind(String profileKind) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(profileKind.equalsIgnoreCase("-- Empty --")) {
					new Select(dataManagement.GetprofileKindId()).selectByValue("");
					
				}if(profileKind.equalsIgnoreCase("ABSOLUTE")) {
					new Select(dataManagement.GetprofileKindId()).selectByValue("ABSOLUTE");
					
				}if(profileKind.equalsIgnoreCase("RECURRING")) {
					new Select(dataManagement.GetprofileKindId()).selectByValue("RECURRING");
					
				}if(profileKind.equalsIgnoreCase("RELATIVE")) {
					new Select(dataManagement.GetprofileKindId()).selectByValue("RELATIVE");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			
			
			@And("^I select Recurrency Kind '(.*)'$")
			public void Select_Recurrency_Kind(String profileKind) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(profileKind.equalsIgnoreCase("-- Empty --")) {
					new Select(dataManagement.GetrecurrencyKindId()).selectByValue("");
					
				}if(profileKind.equalsIgnoreCase("DAILY")) {
					new Select(dataManagement.GetrecurrencyKindId()).selectByValue("DAILY");
					
				}if(profileKind.equalsIgnoreCase("WEEKLY")) {
					new Select(dataManagement.GetrecurrencyKindId()).selectByValue("WEEKLY");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I enter Valid From '(.*)'$")
			public void enter_Valid_From(String validForm) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetvalidFromId().sendKeys(validForm);
				Thread.sleep(1000);

			}
			
			
			@And("^I enter Valid To '(.*)'$")
			public void enter_Valid_To(String validFormTo) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetvalidToId().sendKeys(validFormTo);
				Thread.sleep(1000);

			}
			//same get button and addnew
			
			@And("^I click get charging profile button$")
			public void click_Get_Charging_Profile_button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetChargingProfilesGetButton().click();
				Thread.sleep(5000);

			}
			
			
			//Add New Charging Profiles
			
			
			@And("^I select Charging Profile Purpose2 '(.*)'$")
			public void Select_Charging_Profile_Purpose2(String chargingProfilePurpose) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(chargingProfilePurpose.equalsIgnoreCase("CHARGE_POINT_MAX_PROFILE")) {
					new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("CHARGE_POINT_MAX_PROFILE");
					
				}if(chargingProfilePurpose.equalsIgnoreCase("TX_DEFAULT_PROFILE")) {
					new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("TX_DEFAULT_PROFILE");
					
				}if(chargingProfilePurpose.equalsIgnoreCase("TX_PROFILE")) {
					new Select(dataManagement.GetchargingProfilePurposeId()).selectByValue("TX_PROFILE");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Charging Profile Kind '(.*)'$")
			public void Select_Charging_Profile_Kind(String chargingProfileKind) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(chargingProfileKind.equalsIgnoreCase("ABSOLUTE")) {
					new Select(dataManagement.GetchargingProfileKindId()).selectByValue("ABSOLUTE");
					
				}if(chargingProfileKind.equalsIgnoreCase("RECURRING")) {
					new Select(dataManagement.GetchargingProfileKindId()).selectByValue("RECURRING");
					
				}if(chargingProfileKind.equalsIgnoreCase("RELATIVE")) {
					new Select(dataManagement.GetchargingProfileKindId()).selectByValue("RELATIVE");
					
				}
				
				
				
				Thread.sleep(1000);

			}
		
			@And("^I enter Duration '(.*)'$")
			public void enter_Duration(String duration) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetdurationInSecondsId().sendKeys(duration);
				Thread.sleep(1000);

			}
			
			@And("^I enter Start Schedule '(.*)'$")
			public void enter_Start_Schedule(String startSchedule) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetstartScheduleId().sendKeys(startSchedule);
				Thread.sleep(1000);

			}
			
			
			@And("^I select Charging Rate Unit2 '(.*)'$")
			public void Select_Charging_Rate_Unit2(String chargingRateUnit) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(chargingRateUnit.equalsIgnoreCase("A")) {
					new Select(dataManagement.GetchargingRateUnitId()).selectByValue("A");
					
				}if(chargingRateUnit.equalsIgnoreCase("W")) {
					new Select(dataManagement.GetchargingRateUnitId()).selectByValue("W");
					
				}
				
				Thread.sleep(1000);

			}
			
			@And("^I enter Min Charging Rate  '(.*)'$")
			public void enter_Min_Charging_Rate (String minChargingRate) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetminChargingRateId().sendKeys(minChargingRate);
				Thread.sleep(1000);

			}
			
			@And("^I click Add Period$")
			public void click_Add_Period() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetaddRowIdButton().click();
				Thread.sleep(5000);

			}
			
			@And("^I enter Start Period  '(.*)'$")
			public void enter_Start_Period (String startPeriod) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetscheduleStartPeriod().sendKeys(startPeriod);
				Thread.sleep(1000);

			}
			
			
			@And("^I enter Power Limit  '(.*)'$")
			public void enter_Power_Limit (String powerLimit) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetschedulePeriodMapzz1662475491343PowerLimitId().sendKeys(powerLimit);
				Thread.sleep(1000);

			}
		
			
			@And("^I enter Number Phases  '(.*)'$")
			public void enter_Number_Phases (String numberPhases) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetschedulePeriodMapzz1662475491343NumberPhasesId().sendKeys(numberPhases);
				Thread.sleep(1000);

			}
			
			@And("^I click Delete Period$")
			public void click_Delete_Period() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetremoveRowButton().click();
				Thread.sleep(5000);

			}
			
			//same buttons add and back
			
			
			//Management Reservations
		
			@And("^I click on data management Reservation button$")
			public void Click_management_Reservations_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetmanagementReservationsButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I select Charge Box Id '(.*)'$")
			public void Select_Charge_Box_Id(String chargeBoxId) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(chargeBoxId.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("");
					
				}if(chargeBoxId.equalsIgnoreCase("local")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("local");
					
				}if(chargeBoxId.equalsIgnoreCase("jaime")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("jaime");
					
				}if(chargeBoxId.equalsIgnoreCase("luke")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("luke");
					
				}if(chargeBoxId.equalsIgnoreCase("wiem")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("wiem");
					
				}if(chargeBoxId.equalsIgnoreCase("wiem1")) {
					new Select(dataManagement.GetchargeBoxIdId()).selectByValue("wiem1");
					
				}
				
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Reservation Status '(.*)'$")
			public void Select_Reservation_Status(String reservStatus) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(reservStatus.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetReservationsButton()).selectByValue("");
					
				}if(reservStatus.equalsIgnoreCase("WAITING")) {
					new Select(dataManagement.GetReservationsButton()).selectByValue("WAITING");
					
				}if(reservStatus.equalsIgnoreCase("ACCEPTED")) {
					new Select(dataManagement.GetReservationsButton()).selectByValue("ACCEPTED");
					
				}if(reservStatus.equalsIgnoreCase("USED")) {
					new Select(dataManagement.GetReservationsButton()).selectByValue("USED");
					
				}if(reservStatus.equalsIgnoreCase("CANCELLED")) {
					new Select(dataManagement.GetReservationsButton()).selectByValue("CANCELLED");
					
				}
				
				
				Thread.sleep(1000);

			}
			
			@And("^I select Period Type '(.*)'$")
			public void Select_Period_Type(String periodType) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(periodType.equalsIgnoreCase("Active")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("ACTIVE");
					
				}if(periodType.equalsIgnoreCase("From/To")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("FROM_TO");
					
				}
				
				Thread.sleep(1000);

			}
			@And("^I enter From  '(.*)'$")
			public void enter_From (String form) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetintervalPeriodTypeFromId().sendKeys(form);
				Thread.sleep(1000);

			}
			
			@And("^I enter FromTo  '(.*)'$")
			public void enter_From_To (String formTo) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetintervalPeriodTypeToId().sendKeys(formTo);
				Thread.sleep(1000);

			}
			//same button get 
			
			
			
			//Management Transactions
			
			@And("^I click on data management Transactions button$")
			public void Click_management_Transactions_button() throws InterruptedException {
		     
			 Data_Management dataManagement =new Data_Management(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(dataManagement.GetmanagementButton1());
				actions.perform();
				dataManagement.GetmanagementTransactionsButton().click();
				//Thread.sleep(1000);

			}
			
			@And("^I enter Transaction ID  '(.*)'$")
			public void enter_Transaction_ID (String transactionId) throws InterruptedException {
		     
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GettransactionPkId().sendKeys(transactionId);
				Thread.sleep(1000);

			}
			
			
			@And("^I select Transaction Type '(.*)'$")
			public void Select_Transaction_Type(String transactionType) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(transactionType.equalsIgnoreCase("All")) {
					new Select(dataManagement.GettypeId()).selectByValue("ALL");
					
				}if(transactionType.equalsIgnoreCase("Active")) {
					new Select(dataManagement.GettypeId()).selectByValue("ACTIVE");
					
				}
				
				Thread.sleep(1000);

			}
			
			
			
			
			@And("^I select Period Type Transactions'(.*)'$")
			public void Select_Period_Type_Transaction(String periodTypetrans) throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				if(periodTypetrans.equalsIgnoreCase("All")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("ALL");
					
				}if(periodTypetrans.equalsIgnoreCase("Today")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("TODAY");
					
				}if(periodTypetrans.equalsIgnoreCase("Last 10 days")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_10");
					
				}if(periodTypetrans.equalsIgnoreCase("Last 30 days")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_30");
					
				}if(periodTypetrans.equalsIgnoreCase("Last 90 days")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("LAST_90");
					
				}if(periodTypetrans.equalsIgnoreCase("From/To")) {
					new Select(dataManagement.GetperiodTypeSelectId()).selectByValue("FROM_TO");
					
				}
				
			
				
				Thread.sleep(1000);

			}
			
			@And("^I click Get as CSV? button$")
			public void click_Get_CSV_Button() throws InterruptedException {
			
				Data_Management dataManagement =new Data_Management(driver);
				dataManagement.GetreturnCSV1Id().click();
				Thread.sleep(5000);

			}
			
			
			
			

}

	
	
	




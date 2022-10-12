package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import managers.PageObjectManager;
import pageObjects.Data_Management;
import pageObjects.HomePage;
import pageObjects.Utils;

public class DataManagementDefinition {
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	ObjectMapper objectMapper = new ObjectMapper();
	JsonNode Data;
	 
	 String left_connector = "";
	 String right_connector = "";
	 String device_id ="";
	
	

	//Data_Management
	 
	 @And("^I click on data management charge points button$")
		public void Click_management_button() throws InterruptedException {
	     
		 Data_Management dataManagement = new Data_Management(driver);
			Actions actions = new Actions(driver);

			actions.moveToElement(dataManagement.GetmanagementButton1());
			actions.perform();
			dataManagement.GetmanagementButton().click();
			//Thread.sleep(1000);

		}
	
	 
	 
	 @And("^I select '(.*)'$")
		public void select(String chargeBox) throws InterruptedException {
	     
			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='overview']/table/tbody/tr"));
			// Table Size
			System.out.println("Table size :"+ rows.size());
			// Table First Column : Chargebox ID
			for (WebElement row : rows) {
				if(row.findElement(By.xpath("td[1]/a")).getText().equals(chargeBox))
				{
					device_id=chargeBox;
					row.findElement(By.xpath("td[1]/a")).click();
					Thread.sleep(500);
					WebElement S = driver.findElement(By.xpath("//*[@id=\'chargePointForm\']/table[1]/tbody/tr[6]/td[2]"));
					String serials = S.getText().replaceAll("\\s", "");
					serials = serials.replaceAll("\\s", "");
					String[] chargers_ids =  serials.split("-");
				    left_connector = chargers_ids[0];
				    right_connector = chargers_ids[1];
					break;
				}
			}
			Thread.sleep(200);

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




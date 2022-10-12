package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class Reservation {
	
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	

	
	
	
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
			
			@And("^I click perform cancel reservation button$")
			public void perform_Button_Cancel_Reservation() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetperformCancelReservationButton().click();
				Thread.sleep(1000);

			}
			
			
}

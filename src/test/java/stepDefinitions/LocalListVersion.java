package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import managers.PageObjectManager;
import pageObjects.HomePage;
import pageObjects.Operations;

public class LocalListVersion {
	
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	
	
	//Get Local List Version 
	
			@And("^I click get Local List Version$")
				public void get_Local_List() throws InterruptedException {
			     
					Operations operations =new Operations(driver);
					operations.GetLocalListVersionButton().click();         
					//Thread.sleep(1000);

				}
			
			@And("^I click perform button get local list version$")
			public void click_perform_button_get_local_list_version() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

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
			
			
			@And("^I click perform button set local list version$")
			public void click_perform_button_set_local_list_version() throws InterruptedException {
			
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				Thread.sleep(5000);

			}

}

package stepDefinitions;

import java.io.IOException;
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
import pageObjects.HomePage;
import pageObjects.Operations;
import pageObjects.Utils;

public class operationsChangeAvailability {
	
	
	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	 ObjectMapper objectMapper = new ObjectMapper();
	JsonNode Data;
	 String availType="";
	 String left_connector = "";
	 String right_connector = "";
	 String device_id ="";

	
	

			
		@And("^I click on operations V1.6 button$")
			public void Click_operation_button() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				Actions actions = new Actions(driver);

				actions.moveToElement(operations.GetaOperationButton1());
				actions.perform();
				operations.GetaOperationButton().click();

			}
			
		@And("^I select charge point '(.*)'$")
			public void Select_charge_point_list(String chargePointSelectList) throws InterruptedException, JsonMappingException, JsonProcessingException, IOException {
			
				Operations operations =new Operations(driver);
				if(chargePointSelectList.equalsIgnoreCase("wiem")) {
					new Select(operations.GetchargePointSelectListId()).selectByValue("JSON;wiem;-"); 
				
				}

			}
			
		@And("^I click all charge point$")
			public void Select_charge_point() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetSelectAllButton().click();

			}
			
		@And("^I click none charge point$")
			public void Select_none_charge_point() throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetSelectNoneButton().click();
			}
			
		@And("^I select connecter ID '(.*)'$")
			public void Select_connector_id(String ID) throws InterruptedException {
		     
				Operations operations =new Operations(driver);
				operations.GetconnectorId().sendKeys(ID);
			}
			
		@And("^I select availability Type '(.*)'$")
			public void Select_availability_type(String availtype) throws InterruptedException {
			
			
			this.availType=availtype;
				Operations operations =new Operations(driver);
				if(availtype.equalsIgnoreCase("INOPERATIVE")) {
					new Select(operations.GetavailType()).selectByValue("INOPERATIVE");
				}else if(availtype.equalsIgnoreCase("OPERATIVE")) {
					new Select(operations.GetavailType()).selectByValue("OPERATIVE");
				}
			}
		
		
			
		@And("^I click perform button change availability with Initial State 0$")
			public void click_perform_button_change_availability_0() throws InterruptedException, IOException {
			
			WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement l = wait.until(ExpectedConditions.elementToBeClickable(By.id("connectorId")));
			 l.click();
		      String connector_id = l.getAttribute("value");
		      
		      
		      
		        JsonNode Data_left = objectMapper.readTree(Utils.getReported(left_connector)); 
				JsonNode Data_right = objectMapper.readTree(Utils.getReported(right_connector)); 
				
				String locked_left = Data_left.get("locked").asText(); 
				String locked_right = Data_right.get("locked").asText(); 
			 
			 
			 if(connector_id.equals("") )
			 {
				 if(availType.equals("OPERATIVE"))
				 {	
						if(locked_left.equals("0") && locked_right.equals("0"))
						{
							
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("0"))
						{
							Utils.lockDevice(left_connector,false);
							Thread.sleep(5000);
							
						}
						if(locked_left.equals("0") && locked_right.equals("1"))
						{
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
				                }
						
						if(locked_left.equals("1") && locked_right.equals("1"))
						{
							Utils.lockDevice(left_connector,false);
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						} 
					
				 }else
				 {
					 if(locked_left.equals("0") && locked_right.equals("0"))
						{
							Thread.sleep(5000);
							
						}
						if(locked_left.equals("1") && locked_right.equals("0"))
						{
							Utils.lockDevice(left_connector,false);
							Thread.sleep(5000);
							
						}
						if(locked_left.equals("0") && locked_right.equals("1"))
						{
							
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("1"))
						{
							Utils.lockDevice(left_connector,false);
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						} 
				 }
					
	          
				 
			 }
			 
			 
			 
			 if(connector_id.equals("0"))
			 {
				 if(availType.equals("OPERATIVE"))
				 {	
					 if(locked_left.equals("0") && locked_right.equals("0"))
						{
							
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("0"))
						{
							Utils.lockDevice(left_connector,false);
							Thread.sleep(5000);
						}
						if(locked_left.equals("0") && locked_right.equals("1"))
						{
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("1"))
						{
							Utils.lockDevice(left_connector,false);
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						} 
					
				 }else
				 {
					 if(locked_left.equals("0") && locked_right.equals("0"))
						{
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("0"))
						{
							Utils.lockDevice(left_connector,false);
						    Thread.sleep(5000);
							
						}
						if(locked_left.equals("0") && locked_right.equals("1"))
						{
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						}
						if(locked_left.equals("1") && locked_right.equals("1"))
						{
							Utils.lockDevice(left_connector,false);
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);
						} 
				 }
			 }
			 
			
			 if(connector_id.equals("1"))
			 {
				 if(availType.equals("OPERATIVE"))
				 {	
						if(locked_left.equals("0") )
						{
							Thread.sleep(5000);
						}
						if(locked_left.equals("1"))
						{
							Utils.lockDevice(left_connector,false);
							Thread.sleep(5000);
						}
						
				 }else
				 {
					 if(locked_left.equals("0") )
						{
							Thread.sleep(5000);
							
						}
						if(locked_left.equals("1") )
						{
							Utils.lockDevice(left_connector,false);
							Thread.sleep(5000);
							
						}
						
				 }
			 }
			 
			 
			 if(connector_id.equals("2"))
			 {
				 if(availType.equals("OPERATIVE"))
				 {	
						if(locked_right.equals("0"))
						{
							Thread.sleep(5000);
						}
						
						if(locked_right.equals("1"))
						{
							Utils.lockDevice(right_connector,false);
							Thread.sleep(5000);	
						}
						
				 }else
				 {
					 if(locked_right.equals("0"))
						{
							Thread.sleep(5000);
							
						}
						
						if( locked_right.equals("1"))
						{
							Utils.lockDevice(right_connector,false);
							Thread.sleep(2500);
							
						}
						
				 } 
			 }
			 Thread.sleep(5000);
			 
				Operations operations =new Operations(driver);
				operations.Getsubmitbutton().click();
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				Thread.sleep(5000);
				
				
				
				//compare with getreported
				
				JsonNode Data_left1 = objectMapper.readTree(Utils.getReported(left_connector)); 
				JsonNode Data_right1 = objectMapper.readTree(Utils.getReported(right_connector)); 
				
				String locked_left1 = Data_left1.get("locked").asText(); 
				String locked_right1 = Data_right1.get("locked").asText();  
				
				if(availType.equals("OPERATIVE")) {
					if(connector_id.equals("0")  ) {
						
						if(locked_left1.equals("0") && locked_right1.equals("0")){
							System.out.println("correct result ");	
						}
						
						else {
							System.out.println("incorrect result ");
							
						}
						
					}
					
	                  if(connector_id.equals("")  ) {
						
						if(locked_left1.equals("0") && locked_right1.equals("0")){
							System.out.println("correct result ");	
						}
						
						else {
							System.out.println("incorrect result ");
							
						}
						
					}
					
					if(connector_id.equals("1")  ) {
						
						if(locked_left1.equals("0")){
							System.out.println("correct result ");	
						}
						
						else {
							System.out.println("incorrect result ");
							
						}
					}
	                  if(connector_id.equals("2")  ) {
						
						if(locked_right1.equals("0")){
							System.out.println("correct result ");	
						}
						
						else {
							System.out.println("incorrect result ");
							
						}
					}
				}
	                  
	                  
	                  //INOPERATIVE
	                  
	                  else {
	                	  
	                	  if(connector_id.equals("0")  ) {
	      					
	      					if(locked_left1.equals("1") && locked_right1.equals("1")){
	      						System.out.println("correct result ");	
	      					}
	      					
	      					else {
	      						System.out.println("incorrect result ");
	      						
	      					}
	      					
	      				}
	      				
	                        if(connector_id.equals("")  ) {
	      					
	      					if(locked_left1.equals("1") && locked_right1.equals("1")){
	      						System.out.println("correct result ");	
	      					}
	      					
	      					else {
	      						System.out.println("incorrect result ");
	      						
	      					}
	      					
	      				}
	      				
	      				if(connector_id.equals("1")  ) {
	      					
	      					if(locked_left1.equals("1")){
	      						System.out.println("correct result ");	
	      					}
	      					
	      					else {
	      						System.out.println("incorrect result ");
	      						
	      					}
	      				}
	                        if(connector_id.equals("2")  ) {
	      					
	      					if(locked_right1.equals("1")){
	      						System.out.println("correct result ");	
	      					}
	      					
	      					else {
	      						System.out.println("incorrect result ");
	      						
	      					}
	                	   
	                  }	  
	                	  
				}

			}
		
		
		
		
		@And("^I click perform button change availability with Initial State 1$")
		public void click_perform_button_change_availability_1() throws InterruptedException, IOException {
		
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement l = wait.until(ExpectedConditions.elementToBeClickable(By.id("connectorId")));
		 l.click();
	      String connector_id = l.getAttribute("value");
	      
	      
	      
	      JsonNode Data_left = objectMapper.readTree(Utils.getReported(left_connector)); 
			JsonNode Data_right = objectMapper.readTree(Utils.getReported(right_connector)); 
			
			String locked_left = Data_left.get("locked").asText(); 
			String locked_right = Data_right.get("locked").asText(); 
		 
		 
		 if(connector_id.equals("") )
		 {
			 if(availType.equals("OPERATIVE"))
			 {	
					if(locked_left.equals("0") && locked_right.equals("0"))
					{
						Utils.lockDevice(left_connector,true);
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
					}
					if(locked_left.equals("0") && locked_right.equals("1"))
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("1"))
					{
						Thread.sleep(5000);
					} 
				
			 }else
			 {
				 if(locked_left.equals("0") && locked_right.equals("0"))
					{
						Utils.lockDevice(left_connector,true);
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
					}
					if(locked_left.equals("0") && locked_right.equals("1"))
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);	
					}
					if(locked_left.equals("1") && locked_right.equals("1"))
					{
						Thread.sleep(5000);
					} 
			 }
			 
			 
			
		 
		 
		 if(connector_id.equals("0"))
		 {
			 if(availType.equals("OPERATIVE"))
			 {	
				 if(locked_left.equals("0") && locked_right.equals("0"))
					{
						Utils.lockDevice(left_connector,true);
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
					}
					if(locked_left.equals("0") && locked_right.equals("1"))
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("1"))
					{
						
						Thread.sleep(5000);
					} 
				
			 }else
			 {
				 if(locked_left.equals("0") && locked_right.equals("0"))
					{
						Utils.lockDevice(left_connector,true);
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") && locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("0") && locked_right.equals("1"))
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);	
					}
					if(locked_left.equals("1") && locked_right.equals("1"))
					{
						Thread.sleep(5000);
					} 
			 }
		 }
		 
		
		 if(connector_id.equals("1"))
		 {
			 if(availType.equals("OPERATIVE"))
			 {	
					if(locked_left.equals("0") )
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);
						}
					if(locked_left.equals("1"))
					{
						Thread.sleep(5000);
					}
					
			 }else
			 {
				 if(locked_left.equals("0") )
					{
						Utils.lockDevice(left_connector,true);
						Thread.sleep(5000);
						
					}
					if(locked_left.equals("1") )
					{
						Thread.sleep(5000);
					}
					
			 }
		 }
		 
		 
		 if(connector_id.equals("2"))
		 {
			 if(availType.equals("OPERATIVE"))
			 {	
					if(locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
					}
					
					if(locked_right.equals("1"))
					{
						Thread.sleep(5000);	
					}
					
			 }else
			 {
				 if(locked_right.equals("0"))
					{
						Utils.lockDevice(right_connector,true);
						Thread.sleep(5000);
						
					}
					
					if( locked_right.equals("1"))
					{
						Thread.sleep(5000);	
					}
					
			 } 
		 }
		 Thread.sleep(5000);
		 
			Operations operations =new Operations(driver);
			operations.Getsubmitbutton().click();
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			
			//compare with getreported
			
			JsonNode Data_left1 = objectMapper.readTree(Utils.getReported(left_connector)); 
			JsonNode Data_right1 = objectMapper.readTree(Utils.getReported(right_connector)); 
			
			String locked_left1 = Data_left1.get("locked").asText(); 
			String locked_right1 = Data_right1.get("locked").asText();  
			
			if(availType.equals("OPERATIVE")) {
				if(connector_id.equals("0")  ) {
					
					if(locked_left1.equals("0") && locked_right1.equals("0")){
						System.out.println("correct result ");	
					}
					
					else {
						System.out.println("incorrect result ");
						
					}
					
				}
				
               if(connector_id.equals("")  ) {
					
					if(locked_left1.equals("0") && locked_right1.equals("0")){
						System.out.println("correct result ");	
					}
					
					else {
						System.out.println("incorrect result ");
						
					}
					
				}
				
				if(connector_id.equals("1")  ) {
					
					if(locked_left1.equals("0")){
						System.out.println("correct result ");	
					}
					
					else {
						System.out.println("incorrect result ");
						
					}
				}
               if(connector_id.equals("2")  ) {
					
					if(locked_right1.equals("0")){
						System.out.println("correct result ");	
					}
					
					else {
						System.out.println("incorrect result ");
						
					}
				}
               
               
               //INOPERATIVE
               
               else {
             	  
             	  if(connector_id.equals("0")  ) {
   					
   					if(locked_left1.equals("1") && locked_right1.equals("1")){
   						System.out.println("correct result ");	
   					}
   					
   					else {
   						System.out.println("incorrect result ");
   						
   					}
   					
   				}
   				
                     if(connector_id.equals("")  ) {
   					
   					if(locked_left1.equals("1") && locked_right1.equals("1")){
   						System.out.println("correct result ");	
   					}
   					
   					else {
   						System.out.println("incorrect result ");
   						
   					}
   					
   				}
   				
   				if(connector_id.equals("1")  ) {
   					
   					if(locked_left1.equals("1")){
   						System.out.println("correct result ");	
   					}
   					
   					else {
   						System.out.println("incorrect result ");
   						
   					}
   				}
                     if(connector_id.equals("2")  ) {
   					
   					if(locked_right1.equals("1")){
   						System.out.println("correct result ");	
   					}
   					
   					else {
   						System.out.println("incorrect result ");
   						
   					}
             	  
             	  
             	  
               }
               
             	  
             	  
               }	  
             	  
			}
			 }
	 }

		
		
			@Then("^User is on the task result$")
		  public void VerifyUserOnTaskResult() throws InterruptedException {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				Operations operations = new Operations(driver);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				Assert.assertTrue(operations.GetcpdExist());
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
			
			

			}
			
			
			
			

}

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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.Data_Management;
import pageObjects.HomePage;



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
	
	
	
	

		 
}	 
		 
		 
		 
		 
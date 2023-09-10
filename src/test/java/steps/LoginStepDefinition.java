package steps;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.DatabasePage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase{
	
	LoginPage loginPage;
	DatabasePage databasePage;
	
	@Before
	public void setup() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		databasePage = new DatabasePage();
	}

	@Given ("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		takeScreenShot(driver);
		
	}
	
	@When ("User enters username as {string}")
	public void user_enters_username_as (String username) {
		loginPage.enterUserName(username);
	}
	
	@When("User enters {string} from MYSQL database")
	public void user_enters_from_mysql_database(String loginData) {
	   if(loginData.equalsIgnoreCase("username")) {
		loginPage.enterUserName(databasePage.getDataFromDb("username")); 
		System.out.println("Username from DB: " + databasePage.getDataFromDb("username"));
		
	   }else if(loginData.equalsIgnoreCase("password")) {
		 loginPage.enterPassword(databasePage.getDataFromDb("password")); 
		 System.out.println("Password from DB: " + databasePage.getDataFromDb("password"));
	   }else {
		  System.out.println("Unable to retrieve data from Database"); 
	   }
	}
	
	@When("User enters password as {string}")
	public void user_enters_password_as(String password) {
	 loginPage.enterPassword(password);
	}

	@When("User clicks on signin button")
	public void user_clicks_on_signin_button() {
	loginPage.clickSigninButton();
	}

	@Then("User should be land on dashboard page")
	public void user_should_be_land_on_dashboard_page() {
	 String expectedTitle= "Dashboard- iBilling";
	 String actualTitle = loginPage.getPageTitle();
	 Assert.assertEquals(expectedTitle, actualTitle);
	 takeScreenShot(driver);
	 
	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	
}

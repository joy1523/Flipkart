package org.testnew;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Amazonadd {
	static WebDriver driver;
	@Given("^The user is in Amazon HomePage$")
	public void the_user_is_in_Amazon_HomePage() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ebenezer\\eclipse-workspace\\JoyEbenezer\\SeleniumCucumber\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);}

	@When("^The user searches the product on search option and navigates to new page$")
	public void the_user_searches_the_product_on_search_option_and_navigates_to_new_page() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile",Keys.ENTER);
	}

	@When("^The user selects the choice of his/her mobile \"([^\"]*)\"$")
	public void the_user_selects_the_choice_of_his_her_mobile(String mobile) throws InterruptedException {
		//String locator="//li[@data-result-rank='1']";
		String locator="//li[@id='result_$']";
		 System.out.println(mobile);
		 System.out.println(locator);
		 Thread.sleep(4000);
         //Actions acc=new Actions(driver);
		 locator=locator.replace("$", mobile);
		 System.out.println(locator);
		 driver.findElement(By.xpath(locator)).click();
		 Thread.sleep(5000);
         driver.findElement(By.xpath(locator));
         //acc.moveToElement(clickMob).click();
		 WebDriverWait wait=new WebDriverWait(driver,100);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		 }
  

	@Then("^The selected mobile is added to the cart$")
	public void the_selected_mobile_is_added_to_the_cart() {
		System.out.println("The mobile is added to the cart");
		
	}


}

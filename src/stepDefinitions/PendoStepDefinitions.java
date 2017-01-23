package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PendoStepDefinitions {

	WebDriver driver;
	
	@Given("^Open chrome browser and navigate to google$")
	public void open_chrome_browser_and_navigate_to_google() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "/Users/smarti/Documents/Eclipse/drivers/chromedriver"); 
		
		//launch browser
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		//Login gmail
		driver.findElement(By.id("gb_70")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("automationmonkey1@gmail.com");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("automationmonkey");
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
		
	}

	@And("^Search for hacky sack$")
	public void search_for_hacky_sack() throws Throwable {
	
		//search hacky sack
		driver.findElement(By.id("lst-ib")).sendKeys("hacky sack");
	
		//click search
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@name=\"btnG\"]")).click();
		
	
	}
	@When("^On results page click shopping and choose fourth result$")
	public void on_results_page_click_shopping_and_choose_fourth_result() throws Throwable {
	    
		//click shopping
		driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div[2]")).click();
		Thread.sleep(1000);
		
		//choose fourth option
		driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[4]/div[1]/div[1]/a/div")).click();
		Thread.sleep(1000);
		
	}

	@Then("^Save to short list and add note$")
	public void click_save_to_short_list() throws Throwable {
	    
		// save to short list
		JavascriptExecutor jse_shortlist = (JavascriptExecutor)driver;
		jse_shortlist.executeScript("document.getElementsByClassName('gko-a ksb gko-add')[0].click();");
		Thread.sleep(1000);
		
		//click add a note
		WebElement element = driver.findElement(By.xpath("//*[@id=\"bubble-9\"]/div[2]/div[2]/div[2]/div[2]/div[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		Thread.sleep(1000);
		
		//add note 
		driver.findElement(By.xpath("//*[@id=\"bubble-9\"]/div[2]/div[3]/div/div[1]/textarea")).click();
		driver.switchTo().activeElement().sendKeys("Not too shabby for a rookie!");
		
		//save note
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"bubble-9\"]/div[2]/div[3]/div/div[2]/div[1]")).click();
		    
	}

	
}

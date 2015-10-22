package config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class presidentpage {

	WebDriver driver;
	
	By pageTitle = By.id("header");
	By searchbox = By.cssSelector("searchbox");
	By lastname = By.cssSelector("lastname");
	By firstname = By.cssSelector("searchbox");
	By middlename = By.cssSelector("firstname");
	By year = By.cssSelector("year");
	By partybox = By.cssSelector("party");
	By pie = By.cssSelector("chart");
	
	

		
	public presidentpage (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getpageTitle() {
		return driver.findElement(pageTitle).getText();
	}
	
	
	
	public String getSearchbox() {
		return driver.findElement(searchbox).getText();
	}
	
	public String getlastname() {
		return driver.findElement(lastname).getText();
	}
	
	public String getFirstname() {
		return driver.findElement(firstname).getText();
	}
	
	public String getMiddlename() {
		return driver.findElement(middlename).getText();
	}
	
	public String getYear() {
		return driver.findElement(year).getText();
	}
	
	public String getPartybox() {
		return driver.findElement(partybox).getText();
	}
		
		public String getPie() {
			return driver.findElement(pie).getText();
	}
	
	
	
	
}

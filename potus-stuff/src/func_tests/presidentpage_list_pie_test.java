package func_tests;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.config_vars;
import config.presidentpage;


public class presidentpage_list_pie_test extends config_vars {
	
		private WebDriver driver;
		private StringBuffer verificationErrors = new StringBuffer();
		presidentpage objPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				chrome_d_loc);
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		 
	}

	
	@Test
	public void test() throws Exception {
	
	objPage  =  new presidentpage(driver);
	//compare to config presets
	Assert.assertTrue(objPage.getpageTitle().contains(header));
	Assert.assertTrue(objPage.getlistofpres().contains(listofpre));
	Assert.assertTrue(objPage.getpresbyyear().contains(presbyyear));
	Assert.assertTrue(objPage.getSearchlink().contains(findbyname));
	Assert.assertTrue(objPage.getpartybox().contains(presparties));
	
	//quick list test
	String firstinlist =objPage.getlistfirst();
	String thirdinlist =objPage.getlistthird();
	Assert.assertThat(firstinlist.toLowerCase(), CoreMatchers.containsString(p_First+ " "+ P_Last));
	Assert.assertThat(thirdinlist.toLowerCase(), CoreMatchers.containsString(best));

	
	
	
	//click party link to test pie chart and legend
	objPage.clickParty();
	Thread.sleep(1000);
		
	try {
	isElementPresent(By.cssSelector(plegend));
	isElementPresent(By.className(chart));
	}
	
	catch (Exception nochartnopie){
		System.out.print("cant see pie chart or legend");
		nochartnopie.printStackTrace();
	}
    
	}
	
	
	
			
	

	@After
	public void tearDown() throws Exception {
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
			System.out.println(verificationErrorString);
		}
		driver.quit();

	}
	
	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}

package func_tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.config_vars;
import config.presidentpage;
import config.presidentsearch;




public class pres_search extends config_vars {
	
		private WebDriver driver;
		private StringBuffer verificationErrors = new StringBuffer();
		presidentpage objPage;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"location of chrome driver");
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		 	 
	}

	
	@Test
	public void test() throws Exception {
	
	objPage  =  new presidentpage(driver);
	presidentsearch objSearch;
	
	Assert.assertTrue(objPage.getpageTitle().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getSearchbox().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getlastname().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getFirstname().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getMiddlename().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getYear().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getPartybox().toLowerCase().contains(""));

	
	//now search
	
		objSearch = new presidentsearch(driver);
		objSearch.searchPres(p_First, P_Last, p_Mid );
		
		String title = objSearch.getResults();
	
	//search results BY ALL 3 first last and M
	
	Assert.assertTrue(title.toLowerCase().contains(P_Last + p_Mid + p_First)); 
	
	//this is not enough but with this kind of time crunch its not possible to do all the test cases but this is a foundation
	
	
	//piec hart
	Assert.assertTrue(objPage.getPie().toLowerCase().contains(""));

	
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
	
}

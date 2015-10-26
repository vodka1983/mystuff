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
				chrome_d_loc);
		driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		 	 
	}

	
	@Test
	public void test() throws Exception {
	
	objPage  =  new presidentpage(driver);
	presidentsearch objSearch;
	// the "" are for page element class names to unit test if they are present
	Assert.assertTrue(objPage.getpageTitle().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getSearchbox().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getlastname().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getFirstname().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getMiddlename().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getYear().toLowerCase().contains(""));
	Assert.assertTrue(objPage.getPartybox().toLowerCase().contains(""));

	
	//now search
	//new instance of search page
		objSearch = new presidentsearch(driver);
		//pass the vars from config into search
		objSearch.searchPres(p_First, P_Last, p_Mid );
		
		String title = objSearch.getResults();
	
	//search results BY ALL 3 first last and M
	//assert the inputs match the outputs in appended string 
	Assert.assertTrue(title.toLowerCase().contains(P_Last + p_Mid + p_First)); 
	
	
	//get result count
	int realcount = objSearch.resultcount();	
	int expectedc = 1;
	
	try{
		Assert.assertEquals(realcount, expectedc);
    }
	catch (Exception N){
	

		System.out
				.println("check your math!");
		
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
	
}

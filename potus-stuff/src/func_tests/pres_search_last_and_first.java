package func_tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import config.config_vars;
import config.presidentpage;
import config.presidentsearch;




public class pres_search_last_and_first extends config_vars {
	
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
	
	//now search
	//new instance of search page
		objSearch = new presidentsearch(driver);
		//pass the vars from config into search
		objSearch.searchPresboth(p_First, P_Last);
		
		
		Thread.sleep(1000);

		String title = objSearch.getfirstResultforwashington();
		
		
		//for debug
		Thread.sleep(1000);
		System.out.println(title);
		
		//check if this guy is exactly what we asked for
	Assert.assertThat(title.toLowerCase(), CoreMatchers.containsString(p_First+ " "+ P_Last));

	
	//get result count to be sure its 1 only
	int realcount = objSearch.resultcount();	
	int expectedc = 1;
	
	try{
		Assert.assertEquals(realcount, expectedc);
    }
	catch (Exception N){
	

		System.out
				.println("check your math! there should be only 1");
		
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

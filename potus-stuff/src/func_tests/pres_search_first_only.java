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




public class pres_search_first_only extends config_vars {
	
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
		objSearch.searchPres2(tworesulters);
		
		Thread.sleep(1000);
		String title1 = objSearch.getfirstResultforbush();
		String title2 = objSearch.getsecondResultforbush();
		
		//for debug
		Thread.sleep(1000);
		System.out.println(title1);
		System.out.println(title2);

		
		//check if both are right, should see 2 results
		
	Assert.assertThat(title1.toLowerCase(), CoreMatchers.containsString(tworesulters));
	Assert.assertThat(title2.toLowerCase(), CoreMatchers.containsString(tworesulters));


	
	//get result count to be sure its 2 only
	int realcount = objSearch.resultcount();	
	int expectedc = 2;
	
	try{
		Assert.assertEquals(realcount, expectedc);
    }
	catch (Exception N){
	

		System.out
				.println("check your math! there should be two results");
		
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

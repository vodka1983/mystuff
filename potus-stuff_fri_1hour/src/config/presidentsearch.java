package config;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;


public class presidentsearch extends config_vars {

	WebDriver driver;
	//basic page layout stuff
	By pageTitle = By.linkText("Presidents of the United States");
	By listofpres = By.cssSelector("a[href*='List of Presidents']");
	By presbyyear = By.cssSelector("a[href*='Presidents by year']");
	By searchbox = By.cssSelector("a[href*='/search-by-name']");	
	By searchbutton = By.cssSelector("#search-btn");
	By partybox = By.cssSelector("a[href*='Presidential parties']");
	By partylegend = By.cssSelector("#legend");
	By pie = By.className("col-2-3");
	//added to see the results from search and count #
	By results = By.cssSelector("#presidents");
	
	By lastname = By.cssSelector("lastname");
	By firstname = By.cssSelector("searchbox");
	By middlename = By.cssSelector("firstname");
	By year = By.cssSelector("year");
	
	
	
	

		
	public presidentsearch (WebDriver driver){
		this.driver = driver;
	}
	
	 public void setLastName(String last){
		 
	        driver.findElement(lastname).sendKeys(last);;
	 
	    }
	 
	     
	 
	 public void setFirstName(String first){
		 
	        driver.findElement(lastname).sendKeys(first);;
	 
	    }
	     
	 
	 public void setMiddleName(String middle){
		 
	        driver.findElement(lastname).sendKeys(middle);;
	 
	    }
	 
	    //Click
	 
	    public void clickSearch(){
	 
	            driver.findElement(searchbutton).click();
	 
	    }
	 
	    
	
	    
	 //added to get the number of results    
	 public int resultcount() {
		 List<WebElement> numpres = driver.findElements(results);
		 int count = numpres.size();
		 return count;
	 }
	 
	    public String getResults(){
	 
	     return    driver.findElement(results).getText();
	 
	    }
	 	   
	   	 
	    public void searchPres(String LastName,String FirstName, String MiddleName){
	 
	 
	    	 this.setLastName(LastName);
	 
	        this.setFirstName(FirstName);
	        
	        
	        this.setMiddleName(MiddleName);
	        
	        driver.findElement(searchbox).sendKeys( LastName, FirstName,  MiddleName);
	        	clickSearch();	

	 
	        this.getResults();        
	 
	         
	 
	    }
	
	    public void searchPres2(String LastName){
	   	 
	   	 
	   	 
	   	 
	    	 this.setLastName(LastName);
	    	 
		        driver.findElement(searchbox).sendKeys( LastName);
		        	clickSearch();	

	        
	          
	 
	        this.getResults();        
	    }
	         
	        
	        public void searchPres3(String FirstName){
	   	   	 
	   	   	 
	   	   	 
	   	   	 
		    	 this.setLastName(FirstName);
		    	 	driver.findElement(searchbox).sendKeys( FirstName);
			           	clickSearch();	
		          
		 
		        this.getResults();        
	 
	    }
	
	
	      
	        
	        
}

package config;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class presidentsearch extends config_vars {

	WebDriver driver;
	//basic page layout stuff
	By pageTitle = By.xpath("//h1[text() = 'Presidents of the United States']");
	By listofpres = By.linkText("List of Presidents");
	By presbyyear = By.cssSelector("a[href*='/search-by-year']");
	By yearbox =  By.cssSelector("#year");
	//By chosenyear =  By.cssSelector("#year");		
	By searchlink = By.cssSelector("a[href*='/search-by-name']");
	By partybox = By.cssSelector("a[href*='/parties']");
	By searchtxtbox = By.id("q");
	By searchbutton = By.cssSelector("#search-btn");
	By partylegend = By.cssSelector("#legend");
	By pie = By.className("col-2-3");
	
	
	//added to see the results from search and count #
	By results = By.className("president-detail");
	By oneresult = By.cssSelector("a[href*='president/1']");
	By tworesulta = By.cssSelector("a[href*='president/40']");
	By tworesultb = By.cssSelector("a[href*='president/42']");
	
	
	
	
	By lastname = By.cssSelector("lastname");
	By firstname = By.cssSelector("searchbox");
	By middlename = By.cssSelector("firstname");
	By year = By.cssSelector("year");
	
	
	
	

		
	public presidentsearch (WebDriver driver){
		this.driver = driver;
	}
	
	
	 //click Find president by name
	 	 public void clickFindPresByName(){
		 
        driver.findElement(searchlink).click();

}

	    //Click search button
	 	    public void clickSearch(){
	 
	            driver.findElement(searchbutton).click();
	 
	    }
	
	//set Last name
	 public void setLastName(String last){
		 
	        driver.findElement(searchtxtbox).sendKeys(last);;
	 
	    }
	 
	     
	 //set First name
	 public void setFirstName(String first){
		 
	        driver.findElement(searchtxtbox).sendKeys(first);;
	 
	    }
	
	 //get search results
	    public String getResults(){
	 
	     return    driver.findElement(results).getText();
	 
	    }  
	    
	    public String getfirstResultforwashington(){
		   	 
		     return    driver.findElement(oneresult).getText();
		 
		    }
	    
	    public String getfirstResultforbush(){
	   	 
		     return    driver.findElement(tworesulta).getText();
		 
		    }
	    
	    public String getsecondResultforbush(){
		   	 
		     return    driver.findElement(tworesultb).getText();
		 
		    }  
	    
	    public  void clicksearchbyyear(){
		   	 
		         driver.findElement(presbyyear).click();
		     
		 		    }  
	    
		public void selectmyyear (){
			 new Select(driver.findElement(yearbox)).selectByValue(myyear);
		}

	    
	    
	 //get the number of results    
	 public int resultcount() {
		 List<WebElement> numpres = driver.findElements(results);
		 int count = numpres.size();
		 return count;
	 }
	 
	 
	 //search for president by BOTH names
	    public void searchPresboth(String LastName,String FirstName){
	 
        	clickFindPresByName();

	    	
	    	 this.setLastName(LastName + " ");
	 
	        this.setFirstName(FirstName);
	        
	        
	        
	        driver.findElement(searchlink).sendKeys( LastName,  FirstName);
	        	clickSearch();	

	 
	        this.getResults();        
	 
	         
	 
	    }
	
	 //search for presidents by LAST name
	    public void searchPres2(String LastName){
	   	 
	   	 
        	clickFindPresByName();

	   	 
	    	 this.setLastName(LastName);
	    	 
		        driver.findElement(searchlink).sendKeys( LastName);
		        	clickSearch();	

	        
	          
	 
	        this.getResults();        
	    }
	         
     //search for presidents by FIRST name
       
	        public void searchPres3(String FirstName){
	   	   	    	
	        	clickFindPresByName();
	   	   	 
		    	 this.setLastName(FirstName);
		    	 	driver.findElement(searchtxtbox).sendKeys(FirstName);
			           	clickSearch();	
		          
		 
		        this.getResults();        
	 
	    }
	
	      
	        
	        
}

package config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class presidentsearch extends config_vars {

	WebDriver driver;
	
	By lastname = By.cssSelector("lastname");
	By firstname = By.cssSelector("searchbox");
	By middlename = By.cssSelector("firstname");
	By year = By.cssSelector("year");
	By partybox = By.cssSelector("party");
	By search = By.cssSelector("search");
	By resultheader = By.cssSelector("resultHeader");
	
	

		
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
	 
	    //Click on login button
	 
	    public void clickSearch(){
	 
	            driver.findElement(search).click();
	 
	    }
	 
	     
	 
	 
	    public String getResults(){
	 
	     return    driver.findElement(resultheader).getText();
	 
	    }
	 
	    /**
	 
	     * This POM method will be exposed in test case to login in the application
	 
	     * @param LastName
	 
	     * @param FirstName
	 
	     * @return
	 
	     */
	 
	    public void searchPres(String LastName,String FirstName, String MiddleName){
	 
	 
	    	 this.setLastName(LastName);
	 
	        this.setFirstName(FirstName);
	        
	        
	        this.setMiddleName(MiddleName);
	        
	 
	 
	        this.getResults();        
	 
	         
	 
	    }
	
	    public void searchPres2(String LastName){
	   	 
	   	 
	   	 
	   	 
	    	 this.setLastName(LastName);
	        
	        
	          
	 
	        this.getResults();        
	    }
	         
	        
	        public void searchPres3(String FirstName){
	   	   	 
	   	   	 
	   	   	 
	   	   	 
		    	 this.setLastName(FirstName);
		        
		        
		          
		 
		        this.getResults();        
	 
	    }
	
	
}

package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * W.a. TestNG program to use parameterized demo with multiple parameter of Facebook login with TestNG.
 */

public class Que17 {

	
	 WebDriver driver;

	    @BeforeMethod
	    public void setup() {

	        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize(); 
	    }
	    
	    @DataProvider(name = "loginData")
	    public Object[][] getLoginData() {
	        return new Object[][] {
	            { "user1@example.com", "password123" },  
	            { "user2@example.com", "password456" },  
	            { "user3@example.com", "password789" }   
	        };
	    }

	    
	    @Test(dataProvider = "loginData")
	    public void testLogin(String username, String password) {

	        driver.get("https://www.facebook.com");

	        // Locate the elements and perform login
	        driver.findElement(By.id("email")).sendKeys(username);
	        driver.findElement(By.id("pass")).sendKeys(password);
	        driver.findElement(By.name("login")).click();

	        String currentUrl = driver.getCurrentUrl();
	        assert currentUrl.contains("facebook.com");

	        System.out.println("Login successful for user: " + username);
	    }

	    @AfterMethod
	    public void close() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
}

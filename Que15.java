package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
 * W.a. TestNG program to perform test with webdriver to login process of facebook
 */

public class Que15 {

	WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        
        Thread.sleep(2000);
        
    }

    @Test
    public void testLogin() throws InterruptedException {

        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        emailField.sendKeys("your_email@example.com");  
        passwordField.sendKeys("your_password");     

        loginButton.click();
        
        Thread.sleep(2000);
        
    }
    
    @AfterClass
    public void close() {
        driver.close();
    }
	
}

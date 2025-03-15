package selenium.assignment;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * W.a. junit program to perform test with webdriver to login process of facebook
 */

public class Que12 {

	
	@Test
    public void testFacebookLogin() {
        
        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

        	WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();  
            driver.get("https://www.facebook.com/");

            
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordField = driver.findElement(By.id("pass"));
            WebElement loginButton = driver.findElement(By.name("login"));

        /*    emailField.sendKeys("your_email@example.com");

            passwordField.sendKeys("your_password");

        */
            emailField.sendKeys("hapatel646@gmail.com");

            passwordField.sendKeys("himanshu.patel@123");
            
            loginButton.click();

            WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Account']")));

            Assert.assertTrue("Login failed. Profile icon not found.", profileIcon.isDisplayed());
            System.out.println("Login successful!");
            
            driver.close();

    }
	
}

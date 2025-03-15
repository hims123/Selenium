package selenium.assignment;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * W.a. junit program to use parameterized demo with multiple parameter of Facebook login in junit.

 */

public class Que14 {

	@ParameterizedTest
    @CsvSource({
        "testuser1, password1", 
        "testuser2, password2", 
        "testuser3, password3"
    })
    void testFacebookLogin(String username, String password) throws InterruptedException {
        
        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        WebElement usernameField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("pass"));
        WebElement loginButton = driver.findElement(By.name("login"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        loginButton.click();
        Thread.sleep(2000);
        
        driver.close();
        
        
	}
}

package selenium.assignment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * W.a. junit program to check gmail login using with @before,@after,@Test
 */

public class Que13 {

	WebDriver driver;
	
	@Before
    public void setUp() throws InterruptedException {
		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
        driver.get("https://accounts.google.com/ServiceLogin");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
    }

    @Test
    public void testGmailLogin() {
    	
        WebElement emailField = driver.findElement(By.id("identifierId"));
        emailField.sendKeys("your_email@gmail.com");

        driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
      //  WebElement nextButton = driver.findElement(By.id("identifierNext"));
      //  nextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("your_password");

        WebElement passwordNextButton = driver.findElement(By.id("passwordNext"));
        passwordNextButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Compose']")));

        WebElement composeButton = driver.findElement(By.xpath("//div[text()='Compose']"));
        Assert.assertTrue("Login failed. Compose button not found.", composeButton.isDisplayed());

        System.out.println("Login Successful!");
    }

    @After
    public void close() {
       
        if (driver != null) {
            driver.quit();
        }
    }
	
}

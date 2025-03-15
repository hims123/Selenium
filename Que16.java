package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
 * W.a. TestNG program to check gmail login using with @beforetest,@aftertest,@Test
 */

public class Que16 {

	WebDriver driver;

    @BeforeTest
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.google.com/");
        Thread.sleep(2000);
    }

    @Test
    public void testGmailLogin() throws InterruptedException {
  
        driver.findElement(By.id("identifierId")).sendKeys("himanshu.patel@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("Himspatel@1234");
        driver.findElement(By.id("passwordNext")).click();

        Thread.sleep(5000); 

        boolean isLoggedIn = driver.findElements(By.xpath("//div[@aria-label='Inbox']")).size() > 0;

        Assert.assertTrue(isLoggedIn, "Login failed or Inbox not found");
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
	
}

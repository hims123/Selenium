package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * w.a. TestNG program to create data provider.
 */

public class Que19 {

	WebDriver driver;

    // Setup method to initialize WebDriver
    @BeforeClass
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @DataProvider(name = "loginData")
    public Object[][] createLoginData() {
        return new Object[][] {
            { "standard_user", "secret_sauce" },   
            { "locked_out_user", "secret_sauce" }, 
            { "problem_user", "secret_sauce" }     
        };
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        
        String pageTitle = driver.getTitle();
        System.out.println("Page title after login: " + pageTitle);

    }

    @AfterClass
    public void close() {
        if (driver != null) {
            driver.quit(); 
        }
    }
	
}

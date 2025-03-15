package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * W.A.J.Script To use Mouse and Keyboard event using Action class
 */

public class Que8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		Actions actions = new Actions(driver);

        
        WebElement menuItem = driver.findElement(By.xpath("//a[normalize-space()='Widgets']"));

        actions.moveToElement(menuItem).perform(); 
        System.out.println("Hovered over Widgets to reveal the submenu.");

        Thread.sleep(2000);

        WebElement subMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Datepicker']"));

        actions.moveToElement(subMenuItem).click().perform(); 
        System.out.println("Clicked on datepicker.");
        Thread.sleep(2000);
        
       // driver.findElement(By.name("Register")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();
        Thread.sleep(2000);
        
       // driver.findElement(By.className("form-control ng-pristine ng-untouched ng-invalid ng-invalid-required")).sendKeys("Hims");
       driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Himanshuu");
       WebElement webElement = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
       // actions.moveToElement(firstNameField).sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.CONTEXT_MENU).perform();
        Thread.sleep(2000);
      // actions.doubleClick(webElement);
       
      //  actions.sendKeys(org.openqa.selenium.Keys.ARROW_DOWN).sendKeys(org.openqa.selenium.Keys.PAGE_DOWN);
        actions.sendKeys(Keys.BACK_SPACE).perform();


        Thread.sleep(2000);
		driver.close();
		
	}

}

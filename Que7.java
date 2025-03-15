package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * W.A.J.Script To write a script for drop down. 
 */
public class Que7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		WebElement skillElement = driver.findElement(By.id("Skills"));

        Select select = new Select(skillElement);

        select.selectByVisibleText("Android");
        System.out.println("Selected option: Android");
        Thread.sleep(2000);
        
        
     //   /*
        	WebElement countryDropdown = driver.findElement(By.id("country"));

            
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", countryDropdown);

            
            Thread.sleep(2000);

            Select select1 = new Select(countryDropdown);
            
            
            select1.selectByVisibleText("India");
            System.out.println("Selected option: India");

            
            Thread.sleep(2000);

            
            select1.selectByIndex(4); 
            System.out.println("Selected option by index: " + select1.getFirstSelectedOption().getText());

           
            Thread.sleep(2000);

           
            select1.selectByValue("Australia");
            System.out.println("Selected option by value: " + select1.getFirstSelectedOption().getText());

            Thread.sleep(2000);
  //       */
        
        driver.close();
		
	}

}

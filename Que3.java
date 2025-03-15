package selenium.assignment;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

/*
 * W.A.J. script to use different methods to manage the windows-alerts and pop ups.
 */

public class Que3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		Thread.sleep(2000);
		
		//WebElement simpleAlertButton = driver.findElement(By.xpath("//button[text()='click the button to display an alert box']"));
		WebElement simpleAlertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an')]"));
        simpleAlertButton.click();
        Thread.sleep(2000); 
        Alert alert = driver.switchTo().alert(); 
        System.out.println("Simple Alert Text: " + alert.getText()); 
        alert.accept(); 
        System.out.println("Simple Alert accepted.");
        Thread.sleep(2000); 

        driver.findElement(By.xpath("//a[normalize-space()='Alert with OK & Cancel']")).click();
        Thread.sleep(2000); 
        WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[normalize-space()='click the button to display a confirm box']"));
        confirmationAlertButton.click();
        Thread.sleep(2000); 
        Alert confirmationAlert = driver.switchTo().alert(); 
        System.out.println("Confirmation Alert Text: " + confirmationAlert.getText());
        confirmationAlert.accept(); 
        System.out.println("Confirmation Alert accepted.");
        Thread.sleep(2000); 

        
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']"));
        promptAlertButton.click();
        Thread.sleep(2000); 
        Alert promptAlert = driver.switchTo().alert(); 
        promptAlert.sendKeys("Test input"); 
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.accept(); 
        System.out.println("Prompt Alert accepted with input.");
        Thread.sleep(2000); 
        
        Actions actions = new Actions(driver);

        
        WebElement menuItem = driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']"));

        actions.moveToElement(menuItem).perform(); 

        Thread.sleep(2000);

        WebElement subMenuItem = driver.findElement(By.xpath("//a[normalize-space()='Windows']"));
        actions.moveToElement(subMenuItem).click().perform(); 
        
        Thread.sleep(2000);
        
        WebElement openWindowButton = driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']"));
        openWindowButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

        String parentWindow = iterator.next(); 
        String childWindow = iterator.next();  

        
        driver.switchTo().window(childWindow);
        System.out.println("Switched to child window.");

       
        System.out.println("Title of the child window: " + driver.getTitle());

        
        Thread.sleep(2000);

        
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to the parent window.");

        
        Thread.sleep(2000);
        
        driver.close();
        driver.quit();
		
		
	}

}

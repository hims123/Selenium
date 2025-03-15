package selenium.assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * W.A.J. Script How to handled Alert in selenium 
 */

public class Que9 {

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
        
        driver.close();
		
	}

}

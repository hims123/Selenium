package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * W.A.J. script To write the script for image of logo facebook using xpath.
 * 
 */

public class Que6 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");
		Thread.sleep(2000);
		
	//	WebElement logoImage = driver.findElement(By.xpath("//img[contains(@src, 'facebook')]"));
		WebElement logoImage = driver.findElement(By.xpath("//div[@aria-label='Facebook']//*[name()='svg']"));

        System.out.println("Facebook Logo Image Source: " + logoImage.getAttribute("src"));

        logoImage.click();

        System.out.println("Successfully located the Facebook logo image.");
        
        Thread.sleep(2000);
        driver.close();
		
	}

}

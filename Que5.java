
package selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * W.A.J. Script To perform the radio button to select one by one in loop
 */

public class Que5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		List<WebElement> radioElements = driver.findElements(By.name("radiooptions"));
		
		for (WebElement webElement : radioElements) {
			webElement.click();
			Thread.sleep(2000);
		}
		
		System.out.println("radio button selected");
		
		Thread.sleep(5000);
		driver.close();
	}

}

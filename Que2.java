package selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * W.A.J.Script for Selecting multiple items in a drop dropdown
 */

public class Que2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		
		WebElement dropdown = driver.findElement(By.id("msdd"));
		
	//	Select select = new Select(dropdown);
		dropdown.click();
		Thread.sleep(2000);
		
	/*	if (select.isMultiple()) {
			
			select.selectByVisibleText("English");
			select.selectByVisibleText("Arabic");
			select.selectByIndex(15);
			select.selectByVisibleText("German");
			
			System.out.println("Selected languages :");
            List<WebElement> selectedOptions = select.getAllSelectedOptions();
            for (WebElement option : selectedOptions) {
                System.out.println(option.getText());
            }
		}else {
			System.out.println("dose not support multiple select!!");
			
		}
	*/
	//	List<WebElement> languageOptions = driver.findElements(By.xpath("//div[@class='dropdown-menu']//a"));
		List<WebElement> languageOptions = driver.findElements(By.xpath("//li[@class='ng-scope']"));
		
		for (WebElement option : languageOptions) {
            String optionText = option.getText();
            if (optionText.equals("English") || optionText.equals("Arabic") || optionText.equals("German") || optionText.equals("Hindi")) {
                option.click();
                System.out.println("Selected language : " + optionText);
            }
        }
		
		
		
		
		Thread.sleep(2000);
		driver.close();
		
	}

}

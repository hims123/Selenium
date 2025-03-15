package selenium.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * W.A.J. Script To find the total hyperlink from this web page
	https://qavbox.github.io/demo/webtable/

 */

public class Que10 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://qavbox.github.io/demo/webtable/");
		Thread.sleep(2000);
		
	/*	 WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));

         List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));

         int totalHyperlinks = hyperlinks.size();

         System.out.println("Total number of hyperlinks on the page: " + totalHyperlinks);

         // Optionally, print the text of all hyperlinks (optional)
         // for (WebElement link : hyperlinks) {
         //     System.out.println(link.getText());
         // }
	*/
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));

        long lastHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

        int totalHyperlinks = 0;

        while (true) {
            
            List<WebElement> hyperlinks = driver.findElements(By.tagName("a"));
            int currentHyperlinks = hyperlinks.size();

            
            if (currentHyperlinks > totalHyperlinks) {
                totalHyperlinks = currentHyperlinks;
            }

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

           
            Thread.sleep(2000);  

            long newHeight = (long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

            if (newHeight == lastHeight) {
                break;
            }
            
            lastHeight = newHeight;
        }

        System.out.println("Total number of hyperlinks on the page: " + totalHyperlinks);

        driver.close();
		
	}

}

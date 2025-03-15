package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * W.A.J.script to register your self in Gmail.
 */
public class Que4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

		Thread.sleep(2000);
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/lifecycle/steps/signup/name?continue=https://www.google.co.in/search?q%3Dgmail%2Bregistration%2Bform%26sca_esv%3D248c1a1232d6ce85%26source%3Dhp%26ei%3DT5zNZ4LVN8LS1e8PzrP04AU%26iflsig%3DACkRmUkAAAAAZ82qXz7yLS06TdEdRpYcdk2bpZkJhdDK%26oq%3Dgmail%2Bregistration%2B%26gs_lp%3DEgdnd3Mtd2l6IhNnbWFpbCByZWdpc3RyYXRpb24gKgIIADIFEAAYgAQyBRAAGIAEMgUQABiABDIFEAAYgAQyCxAAGIAEGIYDGIoFMgsQABiABBiGAxiKBTILEAAYgAQYhgMYigVIjWBQAFi-R3AAeACQAQCYAfYGoAHJFaoBCTAuNC41LjYtMbgBA8gBAPgBAZgCCqAC7BbCAhAQABiABBixAxhDGIMBGIoFwgIWEC4YgAQYsQMY0QMYQxiDARjHARiKBcICCxAAGIAEGLEDGIMBwgIIEAAYgAQYsQPCAg0QABiABBixAxhDGIoFwgIOEC4YgAQYsQMY0QMYxwHCAgoQABiABBhDGIoFwgIOEAAYgAQYkQIYsQMYigXCAgsQABiABBiRAhiKBcICBBAAGAOYAwCSBwswLjEuNy4xLjYtMaAHiDk%26sclient%3Dgws-wiz&ddm=1&dsh=S168405762:1741537660478523&ec=GAZAAQ&flowEntry=SignUp&flowName=GlifWebSignIn&hl=en&ifkv=ASSHykq_COTWZxuJy_PeO-GvOAQYO00LNV2QdsZsq09g4Y3tqP02whdRWyU2T0siqyE5Zmu1uXUlvQ&TL=ADgdZ7TsVWFuuqaKjbhtnF1366Raa0dPWxRpW6mY01yxHHVkBHqqSHwtQO47dJlh");
		Thread.sleep(5000);
		
		WebElement nameField = driver.findElement(By.id("firstName"));
        nameField.sendKeys("Hims");

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys("Patel");
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
		
		
		
		
		driver.close();
	}

}

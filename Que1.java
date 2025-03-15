package selenium.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*
 * W.A.J.Script for Locating links by linkText() and partialLinkText()
 */






public class Que1 {

public static void main(String[] args) throws InterruptedException {
	
	System.setProperty("webdriver.edge.driver","G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");

	Thread.sleep(2000);
	
	WebDriver driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.automationtesting.in/Register.html");
	Thread.sleep(2000);
	
	String string =	driver.findElement(By.linkText("Home")).getText();
	System.out.println("got by link text : "+string);
	
	String string1 = driver.findElement(By.partialLinkText("Reg")).getText();
	System.out.println("got by partial link text : "+string1);
	
	Thread.sleep(2000);
	driver.close();
	
	
	
}	

}

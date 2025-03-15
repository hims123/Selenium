package selenium.assignment;
/*
 * Que-18 : W.a. TestNG program to create group with testing.xml file
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
      WebDriver driver = new EdgeDriver();
      driver.manage().window().maximize(); 
      driver.get("https://www.facebook.com/");
  }
  
  
  @Test(groups = "sanity")
  public void test1() {
      System.out.println("Sanity Test 1");
  }

  @Test(groups = "regression")
  public void test2() {
      System.out.println("Regression Test 1");
  }

  @Test(groups = "smoke")
  public void test3() {
      System.out.println("Smoke Test");
  }
  
  
}

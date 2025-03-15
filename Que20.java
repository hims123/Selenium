package selenium.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import junit.framework.Assert;

/*
 *  W.a.framework program for data driven framework
-to get value from the excel and check into your website
https://demo.automationtesting.in/SignIn.html
Direct check with login which emaild through login successful or not.
 */

public class Que20 {

	///*
	 public String[][] readData() throws InvalidFormatException, IOException {
	        
		 	String[][] data = null;
	        String filepath = "G:\\New folder\\Study\\TOPS\\New folder\\Login.xlsx";

	        File file = new File(filepath);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        
	      //  Sheet sheet = (Sheet) workbook.getSheet("Sheet1");
	        Sheet sheet = workbook.getSheet("Sheet5");
	        
	        int nrow = sheet.getPhysicalNumberOfRows();
	        System.out.println("Number of rows: " + nrow);
	        
	        data = new String[nrow - 1][2]; 
	        
	        for (int i = 1; i < nrow; i++) {
	            Row row = sheet.getRow(i);
	            
	            int ncol = row.getPhysicalNumberOfCells();
	            System.out.println("Number of columns: " + ncol);
	            
	            for (int j = 0; j < ncol; j++) {
	                row.getCell(j).setCellType(CellType.STRING);
	                
	                data[i - 1][j] = row.getCell(j).getStringCellValue();
	            }
	        }
	        
	      //  workbook.close();
	        
	        return data;
	    }

	    WebDriver driver = null;

	   // @SuppressWarnings("deprecation")
		@Test
	    public void test() throws InterruptedException, InvalidFormatException, IOException {
	        // Fetch the data from Excel
	        String[][] data = readData();
	        
	        // Set up the WebDriver (EdgeDriver in this case)
	        System.setProperty("webdriver.edge.driver", "G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
	        
	        // Loop through the data and perform login for each set of credentials
	        for (int i = 0; i < data.length; i++) {
	            // Initialize the WebDriver and open the browser
	            driver = new EdgeDriver();
	            driver.manage().window().maximize();
	            
	            // Open the Automation Testing website's login page
	            driver.get("https://demo.automationtesting.in/SignIn.html");
	            Thread.sleep(2000);
	            
	            // Find the email field and enter the email from Excel
	           // WebElement emailField = driver.findElement(By.id("email"));
	            WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
	            emailField.sendKeys(data[i][0]);
	            Thread.sleep(2000);
	            
	            // Find the password field and enter the password from Excel
	           // WebElement passwordField = driver.findElement(By.id("passwd"));
	            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
	            passwordField.sendKeys(data[i][1]);
	            Thread.sleep(2000);
	            
	            // Find the Sign In button and click it
	            WebElement signInButton = driver.findElement(By.id("enterbtn"));
	            signInButton.click();
	            
	            Thread.sleep(2000);
	            
	            // Validation: Check for successful login
	            String pageTitle = driver.getTitle();
	            if (data[i][0].equals("rahul.sanghvi.mca@gmail.com") && data[i][1].equals("rahul12345")) {
	                // If login is successful, validate the page title or URL (you can customize it further based on behavior)
	                Assert.assertTrue(pageTitle.contains("Dashboard") || pageTitle.contains("Home"));
	                System.out.println("Login successful for: " + data[i][0]);
	            } else {
	                // If login is unsuccessful, validate if we're still on the sign-in page or an error message exists
	                Assert.assertTrue(pageTitle.contains("SignIn"));
	                System.out.println("Login failed for: " + data[i][0]);
	            }
	            
	            // Close the browser after each test
	            driver.close();
	        }
	    }
	//*/
	
	/*
	public String[][] readData() throws InvalidFormatException, IOException {
		String[][] data=null;
		//1.to select filepath
		String filepath="G:\\New folder\\Study\\TOPS\\New folder\\Login.xlsx";
		//2.to make file
		File file=new File(filepath);
		//3.to open excel workbook
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//4.to open a particular sheet
		//org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
		Sheet sheet=workbook.getSheet("Sheet5");
		
		//5. to get no of row
		int nrow= sheet.getPhysicalNumberOfRows();
		System.out.println("no of row is :"+nrow);
		
		data=new String[nrow][];
		
		for (int i = 0; i < data.length; i++) {
			//6.to select a particular row
			Row row=sheet.getRow(i);
			//7. to get no of col
			int ncol=row.getPhysicalNumberOfCells();
			System.out.println("no of col is :"+ncol);
			data[i] =new String[ncol];
			for (int j = 0; j < data[i].length; j++) {
				//8.to select a particular col
				//Cell cell=row.getCell(j);
				Cell cell = row.getCell(j);
				
				//9.to convert every cell value to string
				cell.setCellType(CellType.STRING);
				
				//10.to read data from the cell
				data[i][j]=cell.getStringCellValue();
				
			}
			
			
		}
		return data;
		
	}

	WebDriver driver=null;
	@Test
	public void test() throws InterruptedException, InvalidFormatException, IOException {
		String[][] data=readData();
		
		
		
		System.setProperty("webdriver.edge.driver",
				"G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
		
		
		for (int i = 0; i < data.length; i++) {
			 driver=new EdgeDriver();
			driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.id("user-name"))
		.sendKeys(data[i][0]);
		Thread.sleep(2000);
		
		driver.findElement(By.id("password"))
		.sendKeys(data[i][1]);
		Thread.sleep(2000);
		
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000);
		driver.close();
	}
	}
	*/
	
	
}

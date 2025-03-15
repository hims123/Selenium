package selenium.assignment;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
 * W.a.framework program for hybrid driven framework
-given below keyword and Data both which you get from the Excel and check into your web site
https://demo.automationtesting.in/SignIn.html
 */

public class Que22 {

	@DataProvider(name = "Himanshu")
	public Object[][] readData() throws InvalidFormatException, IOException {
		Object[][] data=null;
		//1.to select filepath
		String filepath="G:\\New folder\\Study\\TOPS\\New folder\\Login.xlsx";
		//2.to make file
		File file=new File(filepath);
		//3.to open excel workbook
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//4.to open a particular sheet
		//org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet("Sheet1");
		Sheet sheet=workbook.getSheet("Sheet7");
		
		//5. to get no of row
		int nrow= sheet.getPhysicalNumberOfRows();
		System.out.println("no of row is :"+nrow);
		
		data=new Object[nrow][];
		
		for (int i = 0; i < data.length; i++) {
			//6.to select a particular row
			Row row=sheet.getRow(i);
			//7. to get no of col
			int ncol=row.getPhysicalNumberOfCells();
			System.out.println("no of col is :"+ncol);
			data[i] =new Object[ncol];
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
	@Test(dataProvider = "Himanshu")
	public void test(String keyword,String data) throws InterruptedException, InvalidFormatException, IOException {
		//Object[][] data=readData();
		
		
		
		System.setProperty("webdriver.edge.driver",
				"G:\\New folder\\Study\\TOPS\\New folder\\edgedriver_win64\\msedgedriver.exe");
		
		
	//	for (int i = 0; i < data.length; i++) {
		
		if (keyword.equalsIgnoreCase("open browser")) {
			 driver=new EdgeDriver();
				driver.manage().window().maximize();
		}else if (keyword.equalsIgnoreCase("enter url")) {
			driver.get(data);
			Thread.sleep(2000);
		}else if (keyword.equalsIgnoreCase("enter email")) {
			driver.findElement(By.xpath("//input[@placeholder='E mail']")).sendKeys(data);
			Thread.sleep(2000);
		}else if (keyword.equalsIgnoreCase("enter password")) {
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data);
			Thread.sleep(2000);
		}else if (keyword.equalsIgnoreCase("click login")) {
			driver.findElement(By.id("enterbtn")).click();
			Thread.sleep(4000);
		
			
		}else if (keyword.equalsIgnoreCase("click logout")) {
			driver.findElement(By.id("errormsg"));
		}
		else if (keyword.equalsIgnoreCase("close browser")) {
			Thread.sleep(2000);
			driver.close();
		}
			
//	}
	}
	
}

package testUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import testBase.Xl_Reader;

public class TestUtils extends TestBase {

	public static void doLogin(String userName, String Password) {
		getObject(pro.getProperty("Web.username")).sendKeys(userName);
		getObject(pro.getProperty("Web.password")).sendKeys(Password);
		getObject(pro.getProperty("Web.click")).click();
	}

	public static boolean isSkip(String SheetName, String testcase) {
		for (int i = 0; i <= dataTable.getRowCount(SheetName); i++) {
			for (int j = 0; j < dataTable.getColumnCount(SheetName); j++) {
				if (testcase.equals(dataTable.getCellData(SheetName, j, i))) {
					if (dataTable.getCellData(SheetName, "RunMode", i).equals("Y")) {
						//System.out.println(dataTable.getCellData(SheetName, "RunMode", i));
						return false;
					} else {
						return true;
					}
				}
			}
		}
		return true;
	}
	
	public static String[][] getData(String SheetName){
		dataTable=new Xl_Reader("C:\\Users\\raguraman\\Desktop\\New folder\\Test.xlsx");
		int rows=dataTable.getRowCount(SheetName);
		int cols=dataTable.getColumnCount(SheetName);
		String datas[][]=new String[rows-1][cols];
		for(int rowNum=2;rowNum<=rows;rowNum++){
			
			for(int colNum=0;colNum<cols;colNum++){
	
				datas[rowNum-2][colNum]=dataTable.getCellData(SheetName, colNum, rowNum);
				System.out.println(datas[rowNum-2][colNum]);
			}
		}
		return datas;
		
	}
	
	public static void getAlert(){
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		System.out.println(text);
		alert.accept();
		
	}
	
	public static void Navigate(){
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
	}
	
	public static void mouseOverAction(WebElement mainElement,WebElement subElement){
		Actions action=new Actions(driver);
		action.moveToElement(mainElement).build().perform();
		if(subElement.equals("")){
			action.moveToElement(subElement).click();
		}
	}
	public static void getTable(){
		getObject(pro.getProperty("Web.product")).click();
		WebElement element=driver.findElement(By.xpath("html/body/form/table/tbody/tr/td[2]/div[2]/table"));
		List<WebElement> row=element.findElements(By.tagName("tr"));
		for(int i=0;i<row.size();i++){
			List<WebElement> header=driver.findElements(By.tagName("th"));
			for(int j=0;j<header.size();j++){
				String value=header.get(j).getText();
				System.out.print(value);
			}
		}
		for(int i=0;i<row.size();i++){
			List<WebElement> data=driver.findElements(By.tagName("td"));
			for(int k=0;k<data.size();k++){
				String values=data.get(k).getText();
				System.out.print(values);
			}
			System.out.println();
		}
	}
	
	public static void getOrder(String product,String Quantity,String CustomerName,String street,String City,String Zip,String CardNo,String ExpireDate) throws InterruptedException{
		getObject(pro.getProperty("Web.order")).click();
		getObject(pro.getProperty("Web.ProductList")).sendKeys(product);
		getObject(pro.getProperty("Web.qty")).sendKeys(Quantity);
		Thread.sleep(5000);
		getObject(pro.getProperty("Web.customername")).sendKeys(CustomerName);
		getObject(pro.getProperty("Web.Street")).sendKeys(street);
		getObject(pro.getProperty("Web.city")).sendKeys(City);
		//getObject(pro.getProperty("Web.state")).sendKeys(Quantity);
		getObject(pro.getProperty("Web.zip")).sendKeys(Zip);
		getObject(pro.getProperty("Web.card")).click();
		getObject(pro.getProperty("Web.cardno")).sendKeys(CardNo);
		getObject(pro.getProperty("Web.expiredate")).sendKeys(ExpireDate);
		Thread.sleep(5000);
		getObject(pro.getProperty("Web.process")).click();
		getObject(pro.getProperty("Web.allproduct")).click();

	}
	
	public static void draganddrop(String drag,String drop){
		Actions action =new Actions(driver);
		WebElement drags=getObject(drag);
		WebElement drops=getObject(drop);
		action.dragAndDrop(drags, drops);
	}
	
	public static void doLogout(){
		getObject(pro.getProperty("Web.logOut")).click();
	}
	public static void getScreenshot(String name) throws IOException{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\raguraman\\Desktop\\"+name+".png"));
	}
	public static void scrollDown(){
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,200)");
	}
	public static void iFrame(){
		driver.switchTo().frame(0);
		driver.switchTo().frame("iframe");
		driver.switchTo().frame(getObject(""));
	}
	public static void datepicker(){
		driver.findElement(By.xpath("")).sendKeys("");
		((JavascriptExecutor)driver).executeScript("document.getElementByid('datepicker').value='08/09/17'");
	}
	public static void implicitWait(int timeout){
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}
	public static void waitForElement(WebElement element){
		WebDriverWait wait=new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}

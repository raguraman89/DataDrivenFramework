package testBase;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static FileInputStream fis;
	public static Properties pro;
	public static WebDriver driver;
	public static Xl_Reader dataTable;
	public static void doInitialize(){
		try{
			 fis=new FileInputStream("F:\\Source\\MyFramework\\src\\config\\Object.properties");
			 pro=new Properties();
			 pro.load(fis);
			 if(pro.getProperty("Web.Browser").equalsIgnoreCase("chrome")){
				 System.setProperty("webdriver.chrome.driver","F:\\Ragu\\chromedriver.exe");
				  driver=new ChromeDriver();
			 }else if(pro.getProperty("Web.Browser").equalsIgnoreCase("firefox")){
				 System.setProperty("webdriver.gecho.driver", "F:\\Ragu\\geckodriver.exe");
				 driver=new FirefoxDriver();
			 }else{
				 System.out.println("No Initialization");
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		public static WebElement getObject(String xpathName){
			return driver.findElement(By.xpath(xpathName));
		}
		
	}



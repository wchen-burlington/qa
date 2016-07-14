package automation_framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Driver {

	@Test
	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("webdriver.chromedriver", "/usr/local/bin/");		 
		 File file = new File ("/Users/wan.chen/Documents/workspace/UI-testing/src/automation_framework/UI.properties");

		  FileInputStream propFile = null;
		  
		  try{
			  propFile = new FileInputStream(file);
		  }catch(FileNotFoundException e){
			  System.out.println("---CANNOT FIND PROP FILE---");
			  e.printStackTrace();
		  }
		  
		  Properties prop = new Properties();
		  
		  try{
			  prop.load(propFile);
		  }catch(IOException e){
			  System.out.println("---CANNOT LOAD PROPERTIES---");
			  e.printStackTrace();
		  }
		
		  WebDriver driver = new ChromeDriver();
		  
		  String url_home = prop.getProperty("INDEX_URL");
		  
		  driver.get(url_home);
		  Thread.sleep(5000);

		  //add new client
		  String addClient = url_home.concat("/add");
		  driver.get(addClient);
		  Thread.sleep(5000);
		  
		  String clientName = "hi1";
		  String subclientName = "jell";
		  
		  //check if clientName already exit in metadata
		  //https://54.191.25.50:8443/metadata/organizations
		  
		  
		  WebElement enter_Client = driver.findElement(By.id("orgName"));
		  enter_Client.sendKeys(clientName);
		  enter_Client.submit();
		  
		  System.out.println("checkpoint");
		  
		  
		  Alert alertOK = driver.switchTo().alert();
		  alertOK.accept();
		  
		  //add subclient
		  String addSub = url_home.concat("/addsub");
		  driver.get(addClient);
		  Thread.sleep(5000);
	  
		  driver.get(addSub);
		  Thread.sleep(5000);
		   
		  String addInput = url_home+"/"+clientName+"~2F".concat(subclientName)+"/addinput";
			  
		  driver.get(addInput);
		  Thread.sleep(5000);
		  
		  
		  //after Submit Input Detail, get input_definition id
		  
		  
		  
		  System.out.println(addInput);
		  driver.quit();
	}
	

}

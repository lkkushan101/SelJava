package SelPackage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import pages.HomePageObject;
import util.*;
import pages.LoginPageObject;

import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumClass {

	//comment the above line and uncomment below line to use Chrome
		@BeforeTest
	    public void setupDrivers() {
			DeployBrowserDrivers.setupChrome();
	    }
 
		@Test
		
		public void test() throws FileNotFoundException, IOException, ParseException
		{
		
			    JSONRead jsonreader= new JSONRead();
			    WebDriver driver;
			    driver = new ChromeDriver();
			    driver.get(jsonreader.jsonRead(".\\Data\\sel.json", "URL"));

			    LoginPageObject.using(driver)
			    .setUserName(jsonreader.jsonRead(".\\Data\\sel.json", "USER_NAME"))
			    .setPassword(jsonreader.jsonRead(".\\Data\\sel.json", "PASSWORD"))
			    .clickLoginButton();

			    assertThat(HomePageObject.using(driver).getTextUserName()).startsWith("Manger")
			    .contains("Manger")
			    .endsWith("123");
			
	           driver.close();
		}
	    


}

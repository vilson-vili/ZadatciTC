package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.SauceDemoLoginPage;

public class SauceDemoLoginTest {
	
	private static WebDriver driver = null;


@BeforeClass
public static void SauceDemoLogin() {
	
	String dir = System.getProperty("user.dir");
	System.setProperty("webdriver.chrome.driver", dir + "\\executable\\chromedriver.exe");
	
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//go to saucedemo.com
	driver.get("https://www.saucedemo.com/"); 
	
} 
@Test(priority=1)
public void textboxEmptyAndMessage() {
	
	SauceDemoLoginPage home = new SauceDemoLoginPage(driver);
	home.loginTextboxEmptyAndMessage();
	String message = home.getMessage();
	Assert.assertEquals(message, "Epic sadface: Username is required", "Message not found");
	Assert.assertEquals(home.getUrl(), "https://www.saucedemo.com/", "Wrong page");
	

}
@Test(priority=2)
public void usernameBoxEmptyAndMessage() {
	SauceDemoLoginPage home = new SauceDemoLoginPage(driver);
	home.loginUsernameBoxEmptyAndMessage();
	String message = home.getMessage();
	Assert.assertEquals(message, "Epic sadface: Username is required", "Message not found");
	Assert.assertEquals(home.getUrl(), "https://www.saucedemo.com/", "Wrong page");
}
@Test(priority=3)
public void passwordBoxEmptyAndMessage() {
	SauceDemoLoginPage home = new SauceDemoLoginPage(driver);
	home.loginPasswordBoxEmptyAndMessage();
	String message = home.getMessage();
	Assert.assertEquals(message, "Epic sadface: Password is required", "Message not found");
	Assert.assertEquals(home.getUrl(), "https://www.saucedemo.com/", "Wrong page");
	
}
@AfterMethod
public void stayOnLoginPage() {
	driver.get("https://www.saucedemo.com/");
}

@AfterClass
public void tearDown() {
	SauceDemoLoginPage home = new SauceDemoLoginPage(driver);
	home.tearDown();
}
	
}
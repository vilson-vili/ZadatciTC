package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {

	//private static WebElement element = null;
	
	private WebDriver driver;
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.className("btn_action");
	private By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");
	
	private String passwordForAll = "secret_sauce";
	private String usernameAccepted = "standard_user";
	
		// TODO Auto-generated constructor stub
	
	public SauceDemoLoginPage(WebDriver driver) {
	this.driver = driver;
}
	public void loginTextboxEmptyAndMessage() {
		driver.findElement(loginButton).click();

}
	public void loginUsernameBoxEmptyAndMessage() {
		driver.findElement(password).sendKeys(passwordForAll);
		driver.findElement(loginButton).click();
		
	}
	
	public void loginPasswordBoxEmptyAndMessage() {
		driver.findElement(username).sendKeys(usernameAccepted);
		driver.findElement(loginButton).click();
	}
public String getUrl() {
	// TODO Auto-generated method stub
	return driver.getCurrentUrl();

}
public String getMessage() {
	
	// TODO Auto-generated method stub
	return driver.findElement(errorMessage).getText(); 
}
public void tearDown () {
	driver.quit();
}
}
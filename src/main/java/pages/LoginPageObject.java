package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	   private final WebDriver driver;

	    @FindBy(name = "uid")
	    private WebElement userName;

	    @FindBy(name = "password")
	    private WebElement password;

	    @FindBy(name = "btnLogin")
	    private WebElement loginBtn;
	    
	    private LoginPageObject(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public static LoginPageObject using(WebDriver driver) {
	        return new LoginPageObject(driver);
	    }
	    
	    public LoginPageObject setUserName (String userName) {
	        this.userName.sendKeys(userName);
	        return this;
	    }
	    
	    public LoginPageObject setPassword (String password) {
	        this.password.sendKeys(password);
	        return this;
	    }
	    
	    public LoginPageObject clickLoginButton () {
	        this.loginBtn.click();
	        return this;
	    }

}

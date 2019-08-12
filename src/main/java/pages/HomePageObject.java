package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {
	 private final WebDriver driver;

	    @FindBy(xpath = "//table//tr[@class='heading3']")
	    private WebElement userNameHeader;

	 
	    
	    private HomePageObject(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public static HomePageObject using(WebDriver driver) {
	        return new HomePageObject(driver);
	    }
	    
	   
	    
	    public String getTextUserName () {
	        return  this.userNameHeader.getText();
	       
	    }
}

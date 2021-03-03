package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Basf.Form.Generic;


public class Login extends Generic{
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//input[@id='username']")
WebElement loginInput;
@FindBy(xpath="//input[@id='password']")
WebElement passwordInput;
@FindBy(xpath="//input[@class='btn btn-primary btn-block btn-lg']")
WebElement logIn;
public void enterLogin(String username) {
	loginInput.sendKeys(username);
}
public void enterPassword(String password) {
	passwordInput.sendKeys(password);
}
public void logIn() {
	logIn.click();
	}

}

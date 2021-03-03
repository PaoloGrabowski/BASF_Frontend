package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Basf.Form.Generic;



public class TermOfUse extends Generic{
	public TermOfUse(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//div[3]/div[1]/div[3]/div[1]/div[2]/div[1]")
WebElement secondCheckBox;
@FindBy(xpath="//div[3]/div[1]/div[3]/div[1]/div[1]/div[1]")
WebElement firstCheckBox;
@FindBy(xpath="//button[@class='button']")
WebElement proceedToQKnows;

public void uncheckSecondTerm() {
	secondCheckBox.click();
}
public void checkFirstTerm() {
	firstCheckBox.click();
}
public void proceed() {
	proceedToQKnows.click();
	}

}

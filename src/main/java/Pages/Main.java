package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Basf.Form.Generic;



public class Main extends Generic{
	public Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
@FindBy(xpath="//a[2]")
WebElement logo;  
@FindBy(xpath="//input[@id='searchbar-activeinput']")
WebElement searchBox;
@FindBy(xpath="//a[@id='searchbar-magnifier']")
WebElement searchButton;                          
@FindBy(xpath="//div[1]/div[@class='search-result']/div[@class='search-result-abstract']")
WebElement firstAbstract;
@FindBy(xpath="//div[2]/div[@class='search-result']/div[@class='search-result-abstract']")
WebElement secondAbstract;
@FindBy(xpath="//div[3]/div[@class='search-result']/div[@class='search-result-abstract']")
WebElement thirdAbstract;

public String getLogoName(){
    return logo.getText();
}
public void enterWord(String word) {
	searchBox.sendKeys(word);
}
public void search() {
	searchButton.click();
	}
public String checkFirstAbstract(){
    return firstAbstract.getText();
}
public String checkSecondAbstract(){
    return secondAbstract.getText();
}
public String checkThirdAbstract(){
    return thirdAbstract.getText();
}
public  WebElement waitForValidation() {
	 WebDriverWait wait = new WebDriverWait(driver, 5);
	 return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='search-result-numbering']")));
}
}
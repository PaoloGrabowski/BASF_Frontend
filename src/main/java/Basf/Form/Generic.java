package Basf.Form;

import java.net.MalformedURLException;
import java.util.List;


import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public abstract class Generic {
	
private final static Logger logger = Logger.getLogger(Generic.class);
	
protected WebDriver driver;

	@Before
	public void setup() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Programowanie\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://qknows-qa.basf.com/");
		logger.info("WebDriver used: " + driver);
		driver.manage().window().maximize();
		}

	@After
	public void tearDown() {
		if (null != driver) {
		driver.quit();
		}
		}
	
	
	protected List<WebElement> getOnlyVisible(List<WebElement> els) {
		if (null != els) {
			for (int i = els.size() - 1; i >= 0; i--) {
				if (!els.get(i).isDisplayed()) {
					els.remove(i);
				}
			}
		}
		return els;
	}

	protected void logHtml() {
		logger.info(driver.getPageSource());
	}

	protected void open(String url) {
		logger.info("Opening: " + url);
		driver.get(url);
		logger.info("Opened: " + url);
	}
		
	protected void openWindowByUrl(String partOfUrl) {
		logger.info("openWindowByUrl: " + partOfUrl + ", num of windows: " + driver.getWindowHandles().size());
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			String url = driver.getCurrentUrl();
			logger.info("Analyzing window.url: " + url);
			if (url.contains(partOfUrl)) {
				return;
			}
		}
		throw new IllegalArgumentException("Did not find window with partial url: " + partOfUrl);
	}

	protected void openWindowByTitle(String partOfTitle) {
		logger.info("openWindowByTitle: " + partOfTitle + ", num of windows: " + driver.getWindowHandles().size());
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
			String title = driver.getTitle();
			logger.info("Analyzing window.title: " + title);
			if (title.contains(partOfTitle)) {
				return;
			}
		}
		throw new IllegalArgumentException("Did not find window with partial title: " + partOfTitle);
	}

	protected void sleep(long millis) {
		logger.info("sleep: " + millis);
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			Assert.fail(e.getMessage());
		}
	}

}


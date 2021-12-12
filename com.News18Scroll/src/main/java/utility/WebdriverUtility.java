package utility;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import pomRepository.Homepage;


public class WebdriverUtility {
	/**
	 * this method wait for 20 sec for page loading
	 * @param driver
	 */
	public static void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	/**
	 * this method wait for the element to visible
	 * @param driver
	 * @param element
	 */
	public static void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait  wait=new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method wait for the element to be clicked
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<40) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * this method enables user to handle dropdown using visible text
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element,String option) {
		Select select=new Select(element);
		select.selectByVisibleText(option);
	}

	/**
	 * this method enables user to  handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method will perform mouse over action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this method perform right click operation
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * this method help to switch from one window to another
	 * @param driver
	 * @param partialwinTitle
	 */
	public void switchToWindow(WebDriver driver,String partialwinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialwinTitle)) {
				break;
			}
		}
	}
	/**
	 * accept alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();

	}
	/**
	 * cancel alert
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method used for scrolling action in webpage
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	public static void scrollToLast(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollDown(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)  driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}
	
	public static void scroll(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
	}
	
	public static void scrollLittle(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
	}
	
	public static void scrollLittleUP(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
	}
	
	public static void scrollUP(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
	}
	
	public static void delay(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.err.println("InterruptedException occured when waiting for " + time + " milliseconds");
		}
	}
	
//	public static void continuousScroll(WebDriver driver) {
//		Homepage hp=new Homepage(driver);
//		long end = System.currentTimeMillis() + 180000;
//		while (!(WebdriverUtility.waitForElementVisibility(driver, hp.getEnglishFooter()))) {
//			if (System.currentTimeMillis() < end) {
//				WebdriverUtility.scrollUP(driver);
//				WebdriverUtility.delay(1000);
//			} else {
//				break;
//			}
//		}
//	}
	
}

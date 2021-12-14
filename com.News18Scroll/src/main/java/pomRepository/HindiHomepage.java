package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebdriverUtility;

public class HindiHomepage extends WebdriverUtility {
	WebDriver driver;
	
	public HindiHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//div[@class='jsx-2997171482 globalhd large dflex justify-space-betwwen']//a[.=\"मनी\"]")
	private WebElement Money;
	
	@FindBy(xpath="//ul[@class='jsx-3482196704 naukrinews-left']li")
	private WebElement MoneyCon;
	
	@FindBy(xpath="//ul[@class='jsx-3482196704 naukrinews-left']/li[\"+i+\"]//h2")
	private WebElement MoneyContent;
	
	@FindBy(xpath="//ul[@class='jsx-3482196704 naukrinews-left']/li[\"+i+\"]//a")
	private WebElement MoneyContentLink;

}
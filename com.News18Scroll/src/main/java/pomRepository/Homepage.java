package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.WebdriverUtility;

public class Homepage extends WebdriverUtility {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//span[@class='ob-grid-header-text']")
	private WebElement PromotedContent;
	
	@FindBy(xpath="//section[@class='bottom_footer']")
	private WebElement EnglishFooter;
	
	@FindBy(xpath="//div[@class='linner']")
	private WebElement ChangeLanguage;
	
	@FindBy(xpath="//div[@class='linner']//a[contains(@href,'hindi')]")
	private WebElement HindiLanguage;
	
	
	public WebElement getChangeLanguage() {
		return ChangeLanguage;
	}

	public WebElement getHindiLanguage() {
		return HindiLanguage;
	}

	public WebElement getPromotedContent() {
		return PromotedContent;
	}

	public WebElement getEnglishFooter() {
		return EnglishFooter;
	}
}
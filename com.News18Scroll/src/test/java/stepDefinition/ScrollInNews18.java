package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pomRepository.Homepage;
import utility.ExcelUtility;
import utility.WebdriverUtility;

public class ScrollInNews18 {
	public WebDriver driver;
	ExcelUtility eu=new ExcelUtility();
	@Given("^open browser$")
	public void open_browser() throws Throwable {

		System.out.println("Launching Browser :-");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

	}

	@When("^Navigate to News18 Page \"([^\"]*)\" from sheet \"([^\"]*)\"$")
	public void navigate_to_News_Page_from_sheet(String arg1, String arg2) throws Throwable {
		System.out.println("navigate to News 18");
		System.out.println(arg1);
		System.out.println(arg2);
		if(arg1.equals("EngUrl")) {
			String url = eu.getExcelData(arg2, 1, 1);
			System.out.println(url);
			driver.get(url);
		}else
			if(arg1.equals("HindiUrl")) {
				String url = eu.getExcelData(arg2, 2, 1);
				System.out.println(url);
				driver.get(url);
			}
			else {
				String url = eu.getExcelData(arg2, 1, 1);
				System.out.println(url);
				driver.get(url);
			}
	}

	@Then("^Scroll Down till last and find last section in English Homepage$")
	public void scroll_Down_till_last_and_find_last_section_in_English_Homepage() throws Throwable {
		Homepage hp=new Homepage(driver);
		System.out.println("scroll");
		//WebdriverUtility.waitForElementVisibility(driver,hp.getEnglishFooter());
		Thread.sleep(120000);
		WebdriverUtility.scrollToLast(driver);
		//WebdriverUtility.waitForElementVisibility(driver,hp.getEnglishFooter());
		
		
	}


}

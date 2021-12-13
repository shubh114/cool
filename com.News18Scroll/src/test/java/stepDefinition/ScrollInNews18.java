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
	Homepage hp=new Homepage(driver);
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

	@When("^Scroll Down till last and find last section in English Homepage$")
	public void scroll_Down_till_last_and_find_last_section_in_English_Homepage() throws Throwable {
//		Homepage hp=new Homepage(driver);
		System.out.println("scroll");
		//WebdriverUtility.waitForElementVisibility(driver,hp.getEnglishFooter());
		WebdriverUtility.scroll(driver);
		WebdriverUtility.continuousScroll(driver,hp.getEnglishFooter());
       WebdriverUtility.mouseOver(driver, hp.getPromotedContent());		
       String text=hp.getPromotedContent().getText();
       System.out.println(text);
		
	}

	@When("^Scroll up and change to hindi language$")
	public void scroll_up_and_change_to_hindi_language() throws Throwable {
		WebdriverUtility.scrollToP(driver, 0, 0);
		WebdriverUtility.mouseOver(driver, null);
	}

	@When("^Scroll to half select one section$")
	public void scroll_to_half_select_one_section() throws Throwable {

	}

	@When("^CLick on (\\d+)th link on that section$")
	public void click_on_th_link_on_that_section(int arg1) throws Throwable {

	}

	@Then("^Scroll down print all element present in footer$")
	public void scroll_down_print_all_element_present_in_footer() throws Throwable {

	}

}

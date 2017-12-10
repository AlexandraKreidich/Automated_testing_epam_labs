package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Object;


public class BookFlightsPage extends Page {

    private final String BASE_URL = "http://www.airarabia.com/en/book-flight";

    private final Logger logger   = LogManager.getRootLogger();

    public BookFlightsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    /*--------------- For Searching hotels -------------*/
    @FindBy(className = "tab-hotels")
    private WebElement hotelsBtn;

    @FindBy(id = "b_destination")
    private WebElement input;

    @FindBy(className = "b-aff__submit--button")
    private WebElement searchBtn;

    @FindBy(xpath = "//iframe[@title='Найти варианты размещения в любой точке мира']")
    private WebElement iframe;
    /*--------------------------------------------------*/

    /*------------------- Related Pages  -------------*/
    @FindBy(linkText = "FIND OUT MORE")
    WebElement findMore;

    @FindBy(xpath = "//div[@id='popup-buttons']/button[@class='agree-button']")
    WebElement cookieBtn;
    /*--------------------------------------------------*/

    /*------- * ------------*/
    /*--------------------------------------------------*/

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Book Flights page opened");
    }

    public void searchHotel(String place){
        hotelsBtn.click();
        logger.info("hotels button is clicked");
        Driver.getDriver().switchTo().frame(iframe);
        logger.info("switched to the iframe");
        input.sendKeys(place);
        searchBtn.click();
        logger.info("search hotel performed");
    }

    public void openRelatedPage(){
        cookieBtn.click();
        logger.info("the cookie btn was clicked");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        findMore.click();
        logger.info("find more button was clicked");
    }

}

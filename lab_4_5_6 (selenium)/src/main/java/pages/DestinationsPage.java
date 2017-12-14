package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import java.lang.*;


public class DestinationsPage extends Page {
    private final Logger logger   = LogManager.getRootLogger();
    private final String BASE_URL = "http://www.airarabia.com/en/destinations";

    public DestinationsPage(WebDriver webDriver) {
        super(webDriver);

        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Destination page opened");
    }

    /*-------Choose Country For Journey---------*/
    @FindBy(className = "coupon-inner")
    WebElement countryToTravel;
    /*------------------------------------------*/

    /*-------------Show News--------------------*/
    @FindBy(xpath = "//ul[@id='rss-news']/li/a")
    WebElement newsLink;

    @FindBy(xpath = "//div[@id='popup-buttons']/button[@class='agree-button']")
    WebElement cookieBtn;
    /*------------------------------------------*/

    /*--------------Click On Twitter----------------*/
    @FindBy(xpath = "//a[@itemprop='sameAs']")
    WebElement icon;
    /*------------------------------------------*/

    //more code here

    public WebElement getNewsLink(){
        return newsLink;
    }

    public void chooseWhereToFly(){
        countryToTravel.click();
    }

    public void readNews(){
        cookieBtn.click();
        logger.info("the cookie btn was clicked");
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        newsLink.click();
        logger.info("the link was clicked");
    }

    public void openFaceBook(){
        cookieBtn.click();
        logger.info("the cookie btn was clicked");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        icon.click();
    }
}

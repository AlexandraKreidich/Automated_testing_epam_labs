package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;


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
    /*------------------------------------------*/

    /*-------------Show News--------------------*/
    /*------------------------------------------*/

    /*--------------Click On Map----------------*/
    /*------------------------------------------*/

    //more code here
}

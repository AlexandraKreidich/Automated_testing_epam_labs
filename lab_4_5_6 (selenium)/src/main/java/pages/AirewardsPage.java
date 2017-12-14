package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AirewardsPage extends Page {

    private final String BASE_URL = "https://airewards.airarabia.com/portal/";

    private final Logger logger   = LogManager.getRootLogger();

    public AirewardsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Airewards page opened");
    }

    /*-------------- Read about airewards-----------*/
    @FindBy(id = "dyLinks1")
    WebElement readBtn;
    /*----------------------------------------------*/

    /*------------ family accounts -----------------*/
    @FindBy(id="dyLinks4")
    WebElement learnMoreBtn;
    /*----------------------------------------------*/

    public void readAboutAirewards(){
        readBtn.click();
    }

    public void LearnMoreAbotFamilyAccounts(){ learnMoreBtn.click(); }

}

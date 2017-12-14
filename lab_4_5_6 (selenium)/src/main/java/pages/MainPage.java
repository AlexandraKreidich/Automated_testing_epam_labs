package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends Page{
    private final Logger logger   = LogManager.getRootLogger();

    private final String BASE_URL = "http://www.airarabia.com/ru";

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    /*----------------For Sign In --------------*/
    @FindBy(id = "loginlink")
    private WebElement signInBtn;

    @FindBy(id = "edit-email")
    private WebElement inputLogin;

    @FindBy(id = "edit-password")
    private WebElement inputPassword;

    @FindBy(id = "edit-submit")
    private WebElement signInSubmitBtn;
    /*------------------------------------------*/

    /*------------------For Schedule ------------*/
    @FindBy(className = "ui-airportfield")
    private List<WebElement> inputs;

    @FindBy(className = "search-button")
    private WebElement scheduleSubmitBtn;

    @FindBy(className = "hasDatepicker")
    private List <WebElement> flightDate;
    /*-------------------------------------------*/

    /*-----------For Language Changing ----------*/
    @FindBy(id="user_languages")
    WebElement changeLangeageBtn;

    @FindBy(xpath = "//li[@data-title='Deutsch']")
    WebElement languageToChoose;
    /*-------------------------------------------*/

    /*----------- For Searching Cars ------------*/
    @FindBy(xpath = "//li[@aria-labelledby='ui-id-3']")
    WebElement tabLink;

    @FindBy(id = "pickupDate")
    WebElement pickUpDate;

    @FindBy(id="returnDate")
    WebElement returnDate;

    @FindBy(className = "carsearchbutton")
    WebElement searchInput;
    /*-------------------------------------------*/

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
        logger.info("Main page opened");
    }

    public void login(String username, String password) {
        signInBtn.click();
        inputLogin.sendKeys(username);
        inputPassword.sendKeys(password);
        signInSubmitBtn.submit();
        logger.info("Sign In performed");
    }

    public void search(String from, String to, String date) {
        inputs.get(1).sendKeys(from);
        inputs.get(2).sendKeys(to);
        flightDate.get(1).sendKeys(date);
        scheduleSubmitBtn.submit();
    }

    public void changeLanguage(){
        changeLangeageBtn.click();
        logger.info("click on dropdown to change language");
        languageToChoose.click();
        Driver.getDriver().manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        logger.info("choose language");
    }

    public void searchCar(String _picUpDate, String _returnDate){
        tabLink.click();
        (new WebDriverWait(Driver.getDriver(), 10)).until(ExpectedConditions.visibilityOf(searchInput));
        pickUpDate.sendKeys(_picUpDate);
        returnDate.sendKeys(_returnDate);
        searchInput.submit();
    }
}

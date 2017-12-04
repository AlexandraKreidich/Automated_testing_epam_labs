package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SchedulePage extends Page {

    private final String BASE_URL = "http://www.airarabia.com/ru";

    public SchedulePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "ui-airportfield")
    private  List <WebElement>  inputs;

    @FindBy(className = "search-button")
    private WebElement buttonSubmit;

    @FindBy(className = "hasDatepicker")
    private List <WebElement> flightDate;

    @Override
    public void open() {
        webDriver.navigate().to(BASE_URL);
    }

    public void search(String from, String to, String date) {
        inputs.get(1).sendKeys(from);
        inputs.get(2).sendKeys(to);
        flightDate.get(1).sendKeys(date);
        buttonSubmit.submit();
    }
}

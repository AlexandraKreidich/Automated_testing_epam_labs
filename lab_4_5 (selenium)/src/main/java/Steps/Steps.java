package steps;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.MainPage;
import pages.BookFlightsPage;
import pages.DestinationsPage;

import java.util.concurrent.TimeUnit;

public class Steps {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser() {
        driver = Driver.getDriver();
    }

    public void closeDriver() {
        Driver.closeDriver();
    }

    public void searchPath(String from, String to, String date) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.search(from, to, date);
    }

    public void isOnSchedulePage() {
        BookFlightsPage schedulePage = new BookFlightsPage(driver);
        Assert.assertTrue("title should start with IBE Flight Booking",
                driver.getTitle().startsWith("IBE Flight Booking"));
    }

    public void signIn(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.login(email, password);
    }

    public boolean isSignedIn() {
        DestinationsPage signInPage = new DestinationsPage(driver);
        WebElement logOutBtn = driver.findElement(By.id("logoutlink"));
        if(logOutBtn != null)
            return true;
        return false;
    }

    public void searchHotel(String place){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.searchHotel(place);
    }

    public void isOnHotelsPage(){
        Assert.assertTrue("title should contain Air Arabia: Отели в",
                driver.getTitle().contains("Air Arabia: Отели в"));
    }

    public void changeLanguage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.changeLanguage();
    }

    public void isLanguageChanged(){
        WebElement bodyTag = driver.findElement(By.xpath("//body"));
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        Assert.assertTrue("Language should be Deutsch",
                bodyTag.getAttribute("data-lang").equals("de"));
    }

    public void chooseWhereToFly(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.chooseWhereToFly();
    }

    public void isOnCountryToFly(){
        Assert.assertTrue("title should be equals Flights to Abadan | Air Arabia",
                driver.getTitle().equals("Flights to Abadan | Air Arabia"));
    }

    public WebElement readNews(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.readNews();
        WebElement link = destinationsPage.getNewsLink();
        return link;
    }

    public void isOnNewsPage(WebElement link){
        Assert.assertTrue("title should be equals with the link text",
                link.getText().equals(driver.getTitle()));
    }

    public void openFaceBook(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.openFaceBook();
    }

    public void isOnFaceBookPage(){
        Assert.assertTrue("title should contain Air Arabia - Главная",
                driver.getTitle().contains("Air Arabia - Главная"));
    }

    public void openRelatedPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.openRelatedPage();
    }

    public void isOnRelatedPage(){
        Assert.assertTrue("title should contain Payment options | Air Arabia",
                driver.getTitle().contains("Payment options | Air Arabia"));
    }
}

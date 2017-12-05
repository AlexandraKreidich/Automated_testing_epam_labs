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
        Assert.assertTrue("Langeage should be Deutsch",
                bodyTag.getAttribute("data-lang").equals("de"));
    }
}

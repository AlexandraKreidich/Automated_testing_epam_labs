package steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;

import pages.MainPage;

public class MainPageSteps extends Steps {

    public void initBrowser(){
        super.init();
    }

    public void searchPath(String from, String to, String date) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.search(from, to, date);
    }

    public void isOnSchedulePage() {
        Assert.assertTrue("title should start with IBE Flight Booking",
                driver.getTitle().startsWith("IBE Flight Booking"));
    }

    public void signIn(String email, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.login(email, password);
    }

    public boolean isSignedIn() {
        WebElement logOutBtn = driver.findElement(By.id("logoutlink"));
        if(logOutBtn != null)
            return true;
        return false;
    }

    public void searchCar(String pickUpDate, String returnDate){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.searchCar(pickUpDate, returnDate);
    }

    public void isOnCarsPage(){
        Assert.assertTrue("title should contain Car hire",
                driver.getTitle().contains("Car hire"));
    }

    public void openMainPage(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
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

}

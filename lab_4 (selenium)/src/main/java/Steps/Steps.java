package Steps;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SchedulePage;

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
        SchedulePage schedulePage = new SchedulePage(driver);
        schedulePage.open();
        schedulePage.search(from, to, date);
    }

    public void isOnSchedulePage() {
        SchedulePage schedulePage = new SchedulePage(driver);
        Assert.assertTrue("title should start with IBE Flight Booking",
                driver.getTitle().startsWith("IBE Flight Booking"));
    }
}

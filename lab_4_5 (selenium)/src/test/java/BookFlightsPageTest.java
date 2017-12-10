import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import steps.Steps;
import driver.Driver;

import java.util.concurrent.TimeUnit;

public class BookFlightsPageTest {
    private Steps steps;

    private final String PLACE = "Ереван, Армения";

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void performSearchHolel() {
        steps.searchHotel(PLACE);
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set <String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                steps.isOnHotelsPage();
            }
        }

    }

    @Test
    public void performSearchFlight(){
        steps.openRelatedPage();
        steps.isOnRelatedPage();
    }

    @Test
    public void performOpenHelpPage(){
        steps.openHelpPage();
        steps.isOnHelpPage();
    }

    @Test
    public void testLoadingPage(){
        steps.openBookFlightsPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}

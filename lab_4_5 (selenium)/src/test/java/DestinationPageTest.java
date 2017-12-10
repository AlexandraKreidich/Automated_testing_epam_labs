import driver.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import steps.Steps;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DestinationPageTest {

    private Steps steps;

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

    @Test
    public void performChooseCountryToFly(){
        steps.chooseWhereToFly();
        steps.isOnCountryToFly();
    }

    @Test
    public void performReadNews(){
        WebElement link = steps.readNews();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(31, TimeUnit.SECONDS);
                steps.isOnNewsPage(link);
            }
        }
    }

    @Test
    public void performOpenTwitter(){
        steps.openFaceBook();
        String parentWindow = Driver.getDriver().getWindowHandle();
        Set<String> handles =  Driver.getDriver().getWindowHandles();
        for(String windowHandle  : handles)
        {
            if(!windowHandle.equals(parentWindow))
            {
                Driver.getDriver().switchTo().window(windowHandle);
                Driver.getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
                steps.isOnFaceBookPage();
            }
        }
    }

    @Test
    public void testLoadingPage(){
        steps.openDestinationPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        long loadEventEnd = (Long) js.executeScript("return window.performance.timing.loadEventEnd;");
        long navigationStart = (Long) js.executeScript("return window.performance.timing.navigationStart;");
        logger.info("Page Load Time is " + (loadEventEnd - navigationStart)/1000 + " seconds.");
    }
}

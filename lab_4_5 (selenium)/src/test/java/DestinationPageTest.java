import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import steps.Steps;

public class DestinationPageTest {
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}

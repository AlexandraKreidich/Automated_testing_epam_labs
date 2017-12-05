import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Steps.Steps;

public class ScheduleTest {
    private Steps steps;

    private final String FROM_CITY           = "Баку";
    private final String TO_CITY             = "Бейрут (BEY)";
    private final String DATE = "07/12/2017";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void performSearch() {
        steps.searchPath(FROM_CITY, TO_CITY, DATE);
        steps.isOnSchedulePage();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}

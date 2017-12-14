import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.AirewardsPageSteps;

public class AirewardsPageTest  {

    private AirewardsPageSteps steps;

    private final Logger logger  = LogManager.getRootLogger();

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new AirewardsPageSteps();
        steps.initBrowser();
    }

    @Test
    public void performReadAboutAirewards(){
        steps.readAboutAirewards();
        steps.isOnAboutAirewardsPage();
    }

    @Test(description = "duration of the loading")
    public void performLoadingPage(){
        steps.loadPage();
    }

    @Test
    public void learnMoreAbutFamilyAccounts(){
        steps.learnMoreAboutFamilyAcoounts();
        steps.isOnFamilyAccountaPage();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

}

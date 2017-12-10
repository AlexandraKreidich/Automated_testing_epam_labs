import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import steps.Steps;
import driver.Driver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private Steps steps;

    private final String FROM_CITY           = "Баку";
    private final String TO_CITY             = "Бейрут (BEY)";
    private final String DATE                = "22/12/2017";

    private final String LOGIN               = "kreidichalexandra@gmail.com";
    private final String PASSWORD            = "SignInTest1";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void performSearchPath() {
        steps.searchPath(FROM_CITY, TO_CITY, DATE);
        steps.isOnSchedulePage();
    }

    @Test
    public void performSignIn() {
        steps.signIn(LOGIN, PASSWORD);
        steps.isSignedIn();
    }

    @Test
    public void performChangeLanguage(){
        steps.changeLanguage();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        steps.isLanguageChanged();
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }
}

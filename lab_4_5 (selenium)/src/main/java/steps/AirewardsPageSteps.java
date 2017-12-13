package steps;

import org.junit.Assert;
import pages.AirewardsPage;

public class AirewardsPageSteps extends Steps {

    public void initBrowser(){ super.init(); }

    public void readAboutAirewards(){
        AirewardsPage airewardsPage = new AirewardsPage(driver);
        airewardsPage.open();
        airewardsPage.readAboutAirewards();
    }

    public void isOnAboutAirewardsPage(){
        Assert.assertTrue("title should be equal Airewards",
                driver.getTitle().equals("Airewards"));
    }

    public void loadPage(){
        AirewardsPage airewardsPage = new AirewardsPage(driver);
        airewardsPage.loadPage();
    }

    public void learnMoreAboutFamilyAcoounts(){
        AirewardsPage airewardsPage = new AirewardsPage(driver);
        airewardsPage.open();
        airewardsPage.LearnMoreAbotFamilyAccounts();
    }

    public void isOnFamilyAccountaPage(){
        Assert.assertTrue("title should be equal Airewards",
                driver.getTitle().equals("Airewards"));
    }

}

package steps;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import pages.DestinationsPage;

public class DestinationPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void chooseWhereToFly(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.chooseWhereToFly();
    }

    public void isOnCountryToFly(){
        Assert.assertTrue("title should be equals Flights to Abadan | Air Arabia",
                driver.getTitle().equals("Flights to Abadan | Air Arabia"));
    }

    public WebElement readNews(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.readNews();
        WebElement link = destinationsPage.getNewsLink();
        return link;
    }

    public void isOnNewsPage(WebElement link){
        Assert.assertTrue("title should be equals with the link text",
                link.getText().equals(driver.getTitle()));
    }

    public void openFaceBook(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
        destinationsPage.openFaceBook();
    }

    public void isOnFaceBookPage(){
        Assert.assertTrue("title should contain Air Arabia - Главная",
                driver.getTitle().contains("Air Arabia - Главная"));
    }

    public void openDestinationPage(){
        DestinationsPage destinationsPage = new DestinationsPage(driver);
        destinationsPage.open();
    }

}

package steps;

import org.junit.Assert;

import pages.AirewardsPage;
import pages.BookFlightsPage;

public class BookFlightsPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void searchHotel(String place){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.searchHotel(place);
    }

    public void isOnHotelsPage(){
        Assert.assertTrue("title should contain Air Arabia: Отели в",
                driver.getTitle().contains("Air Arabia: Отели в"));
    }

    public void openRelatedPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.openRelatedPage();
    }

    public void isOnRelatedPage(){
        Assert.assertTrue("title should contain Payment options | Air Arabia",
                driver.getTitle().contains("Payment options | Air Arabia"));
    }

    public void openHelpPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.openHelpPage();
    }

    public void isOnHelpPage(){
        Assert.assertTrue("title should contain Contact Us | Air Arabia",
                driver.getTitle().contains("Contact Us | Air Arabia"));
    }

    public void openBookFlightsPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
    }

    public void loadPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.loadPage();
    }

}

package testCases.Search;

import Pages.IndexPage;
import Pages.SearchPage;
import TestComponents.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//Updated Comment - Added more details

public class SearchTest extends TestBase {
    public WebDriver driver;
    SearchPage searchPage;
    IndexPage indexPage;

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {
        searchPage = indexPage.searchForAProduct(dataProp.getProperty("validProduct"));
        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct(), "Valid product HP is not displayed in the search results");

    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {

        searchPage = indexPage.searchForAProduct(dataProp.getProperty("invalidProduct"));
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), "abcd", "No product message in search results is not displayed");

    }

    @Test(priority = 3, dependsOnMethods = {"verifySearchWithValidProduct", "verifySearchWithInvalidProduct"})
    public void verifySearchWithoutAnyProduct() {

        searchPage = indexPage.clickSearchButton();
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("NoProductTextInSearchResults"), "No product message in search results is not displayed");

    }

}

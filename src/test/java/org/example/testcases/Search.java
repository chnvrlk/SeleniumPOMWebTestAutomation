package org.example.testcases;

import org.example.base.BaseClass;
import org.example.pages.HomePage;
import org.example.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Search extends BaseClass {

    public Search(){
        super();
    }
    public WebDriver driver;
    SearchPage searchPage;
    HomePage homePage;

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {
        homePage.enterProductIntoSearchBoxField(dataProp.getProperty("validProduct"));
        searchPage = homePage.clickOnSearchButton();

        Assert.assertTrue(searchPage.displayStatusOfHPValidProduct());

    }


    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {
        homePage.enterProductIntoSearchBoxField(dataProp.getProperty("invalidProduct"));
        searchPage = homePage.clickOnSearchButton();

        Assert.assertEquals(searchPage.getInvalidProductWarningMessage(),dataProp.getProperty("noProductTextInSearchResults"));
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {
        homePage.enterProductIntoSearchBoxField("");
        searchPage = homePage.clickOnSearchButton();

        Assert.assertEquals(searchPage.getInvalidProductWarningMessage(),dataProp.getProperty("noProductTextInSearchResults"));
    }

}
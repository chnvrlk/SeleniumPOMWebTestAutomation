package org.example.testcases;

import org.example.base.BaseClass;
import org.example.pages.AccountPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends BaseClass {

    public Login(){
        super();
    }
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    @Parameters({"browser"})
    void setup(String browser){
        driver = initializeBrowserAndOpenApplicationURL(browser);
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.navigateToLoginPage();
    }

    @DataProvider(name="validCredentialsSupplier")
    public Object[][] supplyTestData(){
        Object[][] data =Utilities.getTestDataFromExcel("Login");
        return data;
    }

    @Test(priority = 1,dataProvider ="validCredentialsSupplier")
    void verifyLoginWithValidCredentials(String email,String password){
        AccountPage accountPage = loginPage.login(email,password);
        Assert.assertTrue(accountPage.getDisplayStatusEditYourAccountInfoOption());
    }

    @Test(priority = 2)
    void verifyLoginWithInvalidEmailandValidPassword(){

        AccountPage accountPage = loginPage.login(Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("invalidPassword"));

        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(loginPage.getEmailPasswordNotMatchMessage().contains(expectedWarningMessage));

    }

    @Test(priority = 3)
    void verifyLoginWithValidEmailandInvalidPassword(){

        AccountPage accountPage = loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword"));

        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(loginPage.getEmailPasswordNotMatchMessage().contains(expectedWarningMessage));
    }

    @Test(priority = 4)
    void verifyLoginWithoutProvidingCredentials(){
        loginPage.clickOnLoginButton();

        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(loginPage.getEmailPasswordNotMatchMessage().contains(expectedWarningMessage));
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}

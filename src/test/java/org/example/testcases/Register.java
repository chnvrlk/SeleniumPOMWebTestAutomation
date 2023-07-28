package org.example.testcases;

import org.example.base.BaseClass;
import org.example.pages.AccountSuccessPage;
import org.example.pages.HomePage;
import org.example.pages.RegisterPage;
import org.example.utilities.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register extends BaseClass {

    public Register(){
        super();
    }

    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;
    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        registerPage = homePage.navigateRegisterPage();
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void successRegister() throws InterruptedException {

        accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                Utilities.generateEmailWithTimeStamp(),
                dataProp.getProperty("telephone"),
                dataProp.getProperty("password"));

        String expectedSuccessRegisterMessage = dataProp.getProperty("accountSuccesfullyCreatedMessage");
        Assert.assertEquals(accountSuccessPage.getAccountSuccesMessage(),expectedSuccessRegisterMessage);
    }

    @Test(priority = 2)
    public void alreadyRegisterEmailScenario()  {

        accountSuccessPage = registerPage.registerWithMandatoryFields(dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                prop.getProperty("validEmail"),
                dataProp.getProperty("telephone"),
                dataProp.getProperty("password"));

        String expectedAlreadyEmailMessage = dataProp.getProperty("emailAlreadyRegisteredMessage");
        Assert.assertEquals(registerPage.getAlreadyEmailRegisteredWarningMessage(),expectedAlreadyEmailMessage);
    }

}

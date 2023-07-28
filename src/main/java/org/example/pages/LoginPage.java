package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id="input-email")
    private WebElement emailAdressField;

    @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
    private WebElement emailPasswordNoMatchWarningMessage;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void enterEmailAdress(String email){
        emailAdressField.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    public AccountPage login(String email,String password){
        emailAdressField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new AccountPage(driver);
    }

    public AccountPage clickOnLoginButton(){
        loginButton.click();
        return new AccountPage(driver);
    }

    public String getEmailPasswordNotMatchMessage(){
        return emailPasswordNoMatchWarningMessage.getText();
    }
}

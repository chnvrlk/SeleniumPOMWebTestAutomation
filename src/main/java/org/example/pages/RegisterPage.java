package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="input-firstname")
    private WebElement firstNameField;

    @FindBy(id="input-lastname")
    private WebElement lastNameField;

    @FindBy(id="input-email")
    private WebElement emailAdressField;

    @FindBy(id="input-telephone")
    private WebElement telephoneNumberField;

    @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(id="input-confirm")
    private WebElement passwordConfirmField;

    @FindBy(name="agree")
    private WebElement privacyPolicyField;

    @FindBy(css="input[value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath="//div[contains(@class, 'alert-danger')]")
    private WebElement alreadyEmailRegisteredWarningMessage;


    public void enterFirstName(String firstName){
        firstNameField.sendKeys(firstName);
    }
    public void enterLastName(String lastName){
        lastNameField.sendKeys(lastName);
    }
    public void enterEmailAdress(String emailAdress){
        emailAdressField.sendKeys(emailAdress);
    }

    public void enterTelephoneNumber(String telephoneNumber){
        telephoneNumberField.sendKeys(telephoneNumber);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void enterPasswordConfirm(String passwordConfirm){
        passwordConfirmField.sendKeys(passwordConfirm);
    }

    public void selectPrivacyPolicy(){
        privacyPolicyField.click();
    }

    public AccountSuccessPage clickOnContinueButton(){
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public String getAlreadyEmailRegisteredWarningMessage(){
       return alreadyEmailRegisteredWarningMessage.getText();
    }

    public AccountSuccessPage registerWithMandatoryFields(String firstName,String lastName, String emailAdress,String telephoneNumber,String passwordText){

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailAdressField.sendKeys(emailAdress);
        telephoneNumberField.sendKeys(telephoneNumber);
        passwordField.sendKeys(passwordText);
        passwordConfirmField.sendKeys(passwordText);
        privacyPolicyField.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }
}

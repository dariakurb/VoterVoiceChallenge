package net.votervoice.pages;

import net.votervoice.utilities.BrowserUtils;
import net.votervoice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertEquals;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='au-target']")
    public WebElement invalidCredErrorMessage;

    @FindBy(xpath = "//div[@class='error']")
    public WebElement usernameError;

    @FindBy(xpath = "(//div[@class='error'])[2]")
    public WebElement passwordError;



    public void login(String username, String password){
        BrowserUtils.waitForClickability(loginButton, 5);
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public void inputIntoField(String fieldName, String input){
        switch (fieldName.toLowerCase()){
            case "username":
                username.sendKeys(input);
                break;
            case "password":
                password.sendKeys(input);
                break;
        }
    }

    public void verifyErrorIsDisplayed(String errorType){
        switch (errorType.toLowerCase()){
            case "username/password combination":
                BrowserUtils.waitForTextToBePresentInElement(invalidCredErrorMessage, "Invalid UserName/Password Combination");
                assertEquals("Invalid UserName/Password Combination" ,invalidCredErrorMessage.getText());
                break;
            case "username":
                BrowserUtils.waitForTextToBePresentInElement(usernameError, "* Require User Name");
                assertEquals("* Require User Name" , usernameError.getText());
                break;
            case "password":
                BrowserUtils.waitForTextToBePresentInElement(passwordError, "* Require Password");
                assertEquals("* Require Password" ,passwordError.getText());
                break;
            case "username/password":
                BrowserUtils.waitForTextToBePresentInElement(passwordError, "* Require Password");
                assertEquals("* Require User Name" ,usernameError.getText());
                assertEquals("* Require Password" ,passwordError.getText());
                break;
        }
    }
}

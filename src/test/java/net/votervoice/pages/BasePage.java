package net.votervoice.pages;

import net.votervoice.utilities.BrowserUtils;
import net.votervoice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "adminLoggedIn")
    public WebElement adminOptions;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;

    public void logout(){
        adminOptions.click();
        logoutButton.click();
    }

    public void verifyTitle(String pageName){
        String actualTitle ="";
        String expectedTitle = "";
        switch (pageName.toLowerCase().replace(" ", "")){
            case "dashboard":
                BrowserUtils.waitForClickability(adminOptions, 3);
                actualTitle = Driver.getDriver().getTitle();
                expectedTitle = "Dashboard - VoterVoice Administrator Site";
                break;
            case "login":
                actualTitle = Driver.getDriver().getTitle();
                expectedTitle = "Login - VoterVoice Administrator Site";
                break;
        }
        assertEquals(expectedTitle, actualTitle);
    }


}

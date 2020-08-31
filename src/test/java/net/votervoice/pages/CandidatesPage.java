package net.votervoice.pages;

import net.votervoice.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class CandidatesPage {

    public CandidatesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="PreAddress_ZipCode")
    public WebElement zipCodeTab;

    @FindBy(id="forwardLink")
    public WebElement continueButton;

    @FindBy (id="Address_StreetAddress")
    public WebElement addressTab;

    @FindBy(linkText = "Register to Vote")
    public WebElement registerToVoteLink;

    @FindBy(linkText = "Find Your Polling Location")
    public WebElement findYourPollingLocationLink;

    @FindBy(linkText = "Additional Voter Resources")
    public WebElement additionalVoterResourcesLink;


   public void navigateToCandidatesPage(){
       Set<String> windowHandles = Driver.getDriver().getWindowHandles();
       for(String windowHandle : windowHandles){
           Driver.getDriver().switchTo().window(windowHandle);
           if (Driver.getDriver().getTitle().equals("Action Center")){
               break;
           }
       }
   }

   public void getWindow(String state, String linkType) {
       String title = "";
       switch(state.toLowerCase()){
           case "va":
               if(linkType.equals("registerToVote")){
                   title = "Citizen Portal - Virginia Department of Elections";
               }else if(linkType.equals("findYourPollingLocation")){
                   title = "Lookup";
               }else if(linkType.equals("additionalVoterResources")){
                   title = "Election and Voter FAQ - Virginia Department of Elections";
               }
           case "la":
               if(linkType.equals("registerToVote")){
                   title = "Online Voter Registration";
               }else if(linkType.equals("findYourPollingLocation")){
                   title = "Voter Portal";
               }else if(linkType.equals("additionalVoterResources")){
                   title = "Voter Portal";
               }
           case "ny":
               if(linkType.equals("registerToVote")){
                   title = "New York DMV | Register to Vote Online - Electronic Voter Registration Application";
               }else if(linkType.equals("findYourPollingLocation")){
                   title = "NYGov - navigation embed";
               }else if(linkType.equals("additionalVoterResources")){
                   title = "Register to Vote - New York State Board of Elections";
               }
           case "md":
               if(linkType.equals("registerToVote")){
                   title = "Voter Registration";
               }else if(linkType.equals("findYourPollingLocation")){
                   title = "";
               }else if(linkType.equals("additionalVoterResources")){
                   title = "Voting in Maryland";
               }
           case "dc":
               if(linkType.equals("registerToVote")){
                   title = "District of Columbia Board of Elections - Register/Update Voter Registration";
               }else if(linkType.equals("findYourPollingLocation")){
                   title = "District of Columbia Board of Elections - Check Your Voter Registration Status";
               }else if(linkType.equals("additionalVoterResources")){
                   title = "District of Columbia Board of Elections - Official Site";
               }

       }
       Set<String> windowHandles =  Driver.getDriver().getWindowHandles();
       for(String windowHandle : windowHandles){
           Driver.getDriver().switchTo().window(windowHandle);
           if (Driver.getDriver().getTitle().equals(title)){
               break;
           }
       }
   }

}

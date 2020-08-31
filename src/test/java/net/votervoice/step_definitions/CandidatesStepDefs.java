package net.votervoice.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.votervoice.pages.CandidatesPage;
import net.votervoice.utilities.ConfigurationReader;
import net.votervoice.utilities.Driver;

import java.util.Map;

import static org.junit.Assert.*;

public class CandidatesStepDefs {

      CandidatesPage candidatesPage = new CandidatesPage();

    @Given("I am on the Candidates Page as an unauthorized user")
    public void i_am_on_the_Candidates_Page_as_an_unauthorized_user()  {
        Driver.getDriver().get(ConfigurationReader.getProperty("candidatesUrl"));
        assertTrue(Driver.getDriver().getCurrentUrl().contains("Candidates"));
    }


    @When("I enter my address information for state {}")
    public void i_enter_my_address_information_for_state(String string, Map<String, String> addressInfo){
        candidatesPage.zipCodeTab.sendKeys(addressInfo.get("zipCode"));
        candidatesPage.continueButton.click();
        candidatesPage.addressTab.sendKeys(addressInfo.get("address"));
        candidatesPage.continueButton.click();
    }


    @Then("I verify {} Voter Resources")
    public void i_verify_Voter_Resources(String state, Map<String, String> resources){
        candidatesPage.registerToVoteLink.click();
        candidatesPage.getWindow(state, resources.get("registerToVote"));
        assertEquals(resources.get("registerToVote"), Driver.getDriver().getCurrentUrl());

        candidatesPage.navigateToCandidatesPage();
        candidatesPage.findYourPollingLocationLink.click();
        candidatesPage.getWindow(state, resources.get("findYourPollingLocation"));
        assertEquals(resources.get("findYourPollingLocation"),Driver.getDriver().getCurrentUrl());

        candidatesPage.navigateToCandidatesPage();
        candidatesPage.additionalVoterResourcesLink.click();
        candidatesPage.getWindow(state, resources.get("additionalVoterResources"));
        assertEquals("Link is different from what is expected", resources.get("additionalVoterResources"), Driver.getDriver().getCurrentUrl());

    }
}

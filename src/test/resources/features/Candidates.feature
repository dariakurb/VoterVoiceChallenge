@regression @smoke
Feature: Candidates page functionality

  @wip @VV-1896
  Scenario Outline: As a user I should see  Voter Resources links corresponding to my state
    Given I am on the Candidates Page as an unauthorized user
    When I enter my address information for state "<stateName>"
        |zipCode| <zipCode>|
        |address| <address>|
    Then Candidates page should be displayed
    And I verify "<stateName>" Voter Resources
      | registerToVote           | <registerToVote>           |
      | findYourPollingLocation  | <findYourPollingLocation>  |
      | additionalVoterResources | <additionalVoterResources> |


    Examples:

      | stateName | zipCode | address            | registerToVote                                                                         | findYourPollingLocation                                                   | additionalVoterResources                                            |
      | VA        | 22204   | 2200 Columbia Pike | https://www.elections.virginia.gov/citizen-portal/                                     | https://vote.elections.virginia.gov/VoterInformation/Lookup/polling       | https://www.elections.virginia.gov/registration/election-voter-faq/ |
      | LA        | 70130   | 711 Canal St       | https://www.sos.la.gov/ElectionsAndVoting/Pages/OnlineVoterRegistration.aspx           | https://voterportal.sos.la.gov/Home/AddressLogin                          | https://voterportal.sos.la.gov/                                     |
      | NY        | 10028   | 1499 3rd  Ave      | https://dmv.ny.gov/more-info/electronic-voter-registration-application                 | https://voterlookup.elections.ny.gov/                                     | https://www.elections.ny.gov/VotingRegister.html                    |
      | DC        | 20024   | 400 C St           | https://www.dcboe.org/Voters/Register-To-Vote/Register-to-Vote                         | https://dcboe.org/Voters/Register-To-Vote/Check-Voter-Registration-Status | https://www.dcboe.org/home                                          |


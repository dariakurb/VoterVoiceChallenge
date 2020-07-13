# VoterVoiceChallenge

# Setting up project
- Install Java
- Install Maven
- Clone repository or download zip.

# Running features 
- Go to project directory
- Use "mvn verify" command to run features.
- Use "mvn verify -Dcucumber.options.tags="@smoke"" command to run smoke suit tests.
- Use "mvn verify -Dcucumber.options.tags="@positive"" command to run positive tests.
- Use "mvn verify -Dcucumber.options.tags="@negative"" command to run negative tests.

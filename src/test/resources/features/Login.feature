Feature: Login
  As a user, T want to be able to login into Vytrack
  under different roles with username and password


  # Any step that was implemented before, can be used
  #If test steps has yellow background, that means it does not have implementation yet
  # Click command+option+L to organize code, save like in java
  #I had somewhere from 2 to 25 scenarios in every feature file
  #By passing parameters in "some word" we can reuse test steps
  #in my project, i was trying to keep steps short

  @store_manager
  Scenario: Login as store manager
    Given  user is on the login page
    Then user logs in as store manager
    And user verifies that "Dashboard" page subtitle is displayed


  @driver
  Scenario: Login as driver
    Given  user is on the login page
    Then user logs in as driver
    And user verifies that "Dashboard" page subtitle is displayed

   @sales_manager
  Scenario: Login as sales manager
    Given  user is on the login page
    Then user logs in as sales manager
    And user verifies that "Dashboard" page subtitle is displayed


  @negative_test
  Scenario: Verify that warning message is displayed when password is not correct
    Given user is on the login page
    Then user enters "storemanager85" username and "wrong" password
    And user verifies that "Invalid user name or password." message is displayed

  @negative_test
  Scenario: Verify that warning message is displayed when password is not correct
    Given user is on the login page
    Then user enters "wrong_username" username and "UserUser123" password
    And user verifies that "Invalid user name or password." message is displayed

  git remote add upstream "https://github.com/CybertekSchool/Summer2019OnlineCucumberSelenium.git"
  // then pull from either
  git pull upstream master  //or
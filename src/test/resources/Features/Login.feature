Feature: Login Functionalities

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser


  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser

  @scenarioOutline
#Parameterization/ Data Driven
  Scenario Outline: Login with multiple credentials using Scenatio Outline
  #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And Close the browser
  Examples:
    | username | password |
    | admin    | Hum@nhrm123 |
    | ADMIN    | Hum@nhrm123 |
    | Jason    | Hum@nhrm123 |

#data Table
  @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password    |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |




    #HOOKS: For defining pre and Post steps in any Cucumber framework
    #     : This is always created inside the StepDefinitions folder
    #     : This class cannot be inherited
    #     : Hooks will take care of pre and past conditions irrespective
    #     : of what goes in between


  # BACKGROUND :  It's the clubbing of common steps in different scenarios of a feature file until flow is not broken
  #1. Hard Code
  #2. Config file
  # ---------------- Cucumber itself provides multiple options through which we can feed data from feature file into Step Definitions
  #3. Regular Expressions
      #put the data in double quotes [""]

  #===================================PARAMETERIZATION================================
  # Executing the same test case with multiple data


  #hard Code
    # config file
    #Cucumber Expression [ limited set of test data]
    #Scenario Outline    [Parametrization],[Data Driven Testing][Browser will open and close number of times we have test data in Examples table]
    #data Table

    # Page Object Model : An object Repository [ It stores or holds all the webElements specific to a particular page]
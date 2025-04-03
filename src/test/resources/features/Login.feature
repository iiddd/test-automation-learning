Feature: Login

  Scenario: Login. Happy flow
    Given The User navigates to the Login page
    When The User inputs "admin" as a username
    And The User inputs "password" as a password
    And The User clicks Login button
    Then The User is on Dashboard page

  Scenario: Login. Empty login test
    Given The User navigates to the Login page
    When The User leaves the username field empty
    And The User inputs "password" as a password
    And The User clicks Login button
    Then The User stays on the Login page
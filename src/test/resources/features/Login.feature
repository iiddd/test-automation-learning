Feature: Login

  Scenario: Login. Happy flow
    Given The User navigates to the Login page
    When The User inputs "admin" as a username
    And The User inputs "password" as a password
    And The User clicks Login button
    Then The User is on Dashboard page

  Scenario: Login. Wrong credentials
    Given The User navigates to the Login page
    When The User enters a random 6 character text as username
    And The User enters a random 6 character text as password
    And The User clicks Login button
    Then The User sees the error message 'Please enter a correct username and password. Note that both fields may be case-sensitive'.
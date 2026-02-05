@Automation-Exercise
Feature: demo

  @TestCase-1
  Scenario Outline: Register User
    Given Navigate to Automation Exercise
    When Click on Signup/Login button
    Then "New User Signup!" heading is visible
    When Enter name "<name>" and email "<email>"
    And Click Signup button
    Then "Enter Account Information" heading is visible
    When Fill account details with title "<title>", name "<name>", password "<password>" and date of birth "<dob>"
    And Select checkbox "Sign up for our newsletter!"
    And Select checkbox "Receive special offers from our partners!"
    And Fill address details with First name "<firstName>", Last name "<lastName>", Company "<company>", Address "<address1>", Address2 "<address2>", Country "<country>", State "<state>", City "<city>", Zipcode "<zipcode>", Mobile Number "<mobile>"
    And Click Create Account button
    Then "Account Created!" heading is visible
    When Click Continue button
    Then "Logged in as <name>" label is visible
    When Click Delete Account button
    Then "Account Deleted!" heading is visible

    Examples:
      | title | name | email                | password | dob            | firstName | lastName | company | address1        | address2        | country | state   | city    | zipcode | mobile     |
      | Mrs   | Dan  | dan1211@yopmail.com  | 123456   | 1-January-2000 | Linh Dan  | Nguyen   | AGH     | 141 Chien Thang | 142 Chien Thang | Canada  | Ontario | Toronto | M5H2N2 | 1234567890  |

    @TestCase-2
    Scenario: Login User with correct email and password
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      Then "Login to your account" heading is visible
      When Login with email "dan2612026@yopmail.com" and password "123456"
      Then "Logged in as Danne" label is visible

    @TestCase-3
    Scenario: Login User with incorrect
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      Then "Login to your account" heading is visible
      When Login with email "dan2612026@yopmail.com" and password "123456khongtontai"
      Then Message "Your email or password is incorrect!" is visible

    @TestCase-4
    Scenario: Logout User
      Given Navigate to Automation Exercise
      When Click on Signup/Login button
      Then "Login to your account" heading is visible
      When Login with email "dan2612026@yopmail.com" and password "123456"
      Then "Logged in as Danne" label is visible
      When Click Logout button
      Then "Login to your account" heading is visible

    @TestCase-5 @existEmail
    Scenario:  Register User with existing email
      When Click on Signup/Login button
      Then "New User Signup!" heading is visible
      When Enter name Dann and email existEmail
      And Click Signup button
      Then Message "Email Address already exist!" is visible

    @TestCase-7
    Scenario: Verify Test Cases Page
      Given Navigate to Automation Exercise
      When Click Test Cases button
      Then "Test Cases" heading is visible






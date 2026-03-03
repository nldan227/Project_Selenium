Feature: Login

  Background:
    Given Call api Login with username "dan.linh.nguyen@agest.vn" and password "password102"
    Then Save Airu access token

  @API-TestCase-2
  Scenario: API Create User
    When Call API Create User
    Then The response data should match the created user

  @API-TestCase-3
  Scenario: API Create Agency
    When Call API Create Agency
    Then The response data should match the created agency

  @API-TestCase-4
  Scenario: API Get Agency
    Given Call API Create Agency
    When Call API Get Agency
    Then The response data should match the searched agency


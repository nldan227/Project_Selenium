Feature: Login

  Background:
    Given Call api Login with username "dan.linh.nguyen@agest.vn" and password "password102"
    Then Save Airu access token


  @TestCase-2
  Scenario: API Create User
    When Call API Create User
    Then The response data should match the created user

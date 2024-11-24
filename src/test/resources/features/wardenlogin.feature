Feature: Warden Login

  @Login
  Scenario: User Successful login with valid credentials

    Given The User is one the home Page of LMS
    When The User clicks on login button and logs in with role "warden" ,email "warden@gmail.com" and password "12345"
    Then The User should see the dashboard


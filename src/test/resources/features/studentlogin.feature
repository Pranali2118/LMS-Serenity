Feature: Student Login

  @Test1
  Scenario: User Successful login with valid credentials
    Given The User is one the home Page of LMS
    When The User clicks on login button and logs in with role "student" ,email "final@gmail.com" and password "1234"
    Then The User should see the dashboard
Feature: Student Login

  @Test
  Scenario: Student Successful login with valid credentials
    Given The student is one the home Page of LMS
    When The student clicks on login button and logs in with email "final@gmail.com" and password "1234"
    Then The student should see the dashboard
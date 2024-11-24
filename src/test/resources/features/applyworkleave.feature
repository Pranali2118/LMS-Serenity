Feature: Student Login

  @Test12
  Scenario: Student successfully apply working day leave

    Given The User is one the home Page of LMS
    When The User clicks on login button and logs in with role "student" ,email "final@gmail.com" and password "1234"
    Then The User should see the dashboard
    And The student applies working day leave by entering the details in the form The leave should be applied successfully
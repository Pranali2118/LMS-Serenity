Feature: Student Login

  @Test1
  Scenario: Student successfully apply working day leave

    Given The student is one the home Page of LMS
    When The student clicks on login button and logs in with email "siri@gmail.com" and password "1234"
    Then The student should see the dashboard
    And The student applies working day leave by entering the details in the form The leave should be applied successfully


Feature: Leave Request Management
  @LeaveRequest1
  Scenario: Warden logs in and approves a leave request
    Given The User is one the home Page of LMS
    When The User clicks on login button and logs in with role "warden" ,email "warden@gmail.com" and password "12345"
    Then The User should see the dashboard
    When The role "Warden" clicks on any leave request and updates the status from pending to approved
    Then The User should be able to update the status

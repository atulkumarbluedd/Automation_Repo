# login.feature
# here we want to repeat login 10 times using like below

Feature: Login functionality

  Scenario Outline: User login with valid credentials
    Given the user is on the login page
    When the user enters "<username>" and "<password>"
    And clicks the login button
    Then the user should be logged in

    Examples:
      | username   | password    |
      | user1      | password1   |
      | user2      | password2   |
      | user3      | password3   |
      | user4      | password4   |
      | user5      | password5   |
      | user6      | password6   |
      | user7      | password7   |
      | user8      | password8   |
      | user9      | password9   |
      | user10     | password10  |

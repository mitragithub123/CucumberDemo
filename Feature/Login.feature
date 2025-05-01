Feature: Login

  Scenario: Successful login with valid credentials
    Given User launches Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks the log out button
    Then Page title should be "Your store. Login"
    And Closes the browser

  Scenario Outline: Verifying login with valid & invalid credentials using data-driven testing
    Given User launches Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>"
    And User enters Password as "<password>"
    And Clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks the log out button
    Then Page title should be "Your store. Login"
    And Closes the browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | user@yourstore.com  | user     |

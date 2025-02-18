Feature: Login
	
  Scenario: Successful login with valid credentials
    Given User launch firefox browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Click on Login
    Then Page Title should "Dashboard / nopCommerce administration"
    When User clicks log out button
    Then Page title should be "Your store. Login"
    And close browser
	
  Scenario Outline: Verifying login through valid & invalid login credentials using data driven
    Given User launch firefox browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>"
    And User enters Password as "<password>"
    And Click on Login
    Then Page Title should "Dashboard / nopCommerce administration"
    When User clicks log out button
    Then Page title should be "Your store. Login"
    And close browser

    Examples: 
      | email               | password |
      | admin@yourstore.com | admin    |
      | user@yourstore.com  | user     |

Feature: Customer

  @sanity @smoke
  Scenario: Add a customer
    Given User launch firefox browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Click on Login
    Then Page Title should "Dashboard / nopCommerce administration"
    When user clicks on customers list item in left menu
    And clicks on customers option
    Then page title should show "Customers / nopCommerce administration"
    Then click on add new button
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

  @smoke
  Scenario: Search customer by email
    Given User launch firefox browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Click on Login
    Then Page Title should "Dashboard / nopCommerce administration"
    When user clicks on customers list item in left menu
    And clicks on customers option
    Then page title should show "Customers / nopCommerce administration"
    When user enters email in email search box
    And clicks on search button
    Then email id should found in table
    And close browser

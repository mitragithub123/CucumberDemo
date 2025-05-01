Feature: Customer Management

  @sanity @smoke
  Scenario: Add a customer
    Given User launches Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on the customers list item in the left menu
    And Clicks on the customers option
    Then Page title should be "Customers / nopCommerce administration"
    Then Clicks on the "Add New" button
    When User enters customer information
    And Clicks on the "Save" button
    Then User should see a confirmation message "The new customer has been added successfully."
    And Closes the browser

  @smoke
  Scenario: Search customer by email
    Given User launches Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com"
    And User enters Password as "admin"
    And Clicks on Login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User clicks on the customers list item in the left menu
    And Clicks on the customers option
    Then Page title should be "Customers / nopCommerce administration"
    When User enters an email in the email search box
    And Clicks on the "Search" button
    Then The email ID should be found in the table
    And Closes the browser

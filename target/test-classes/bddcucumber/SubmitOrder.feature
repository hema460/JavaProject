Feature: Purchase the order from Ecommerce website

Background: 
   Given I launch the browser and navigate to url

  Scenario Outline: positive test of submitting the order
   Given I logged in with username <username> and password <password>
    When I add the product <productName> to cart
    When checkout <productName> and submit the order
    Then verify the confirmation message "THANKYOU FOR THE ORDER." is diplayed

    Examples: 
      | username               | password     | productName   |
      | hemajayworld@gmail.com | Practice@123 | BANARSI SAREE |


  Scenario Outline: User is able to delete the product
    Given I logged in with username <username> and password <password>
    When I click on the order button
    When click on the delete button
   Then verify the confirmation message order deleted succefully is diplayed

    Examples: 
    | username               | password     |
     | hemajayworld@gmail.com | Practice@123 |
     

#Author: your.email@your.domain.com

@tag
Feature: To add Random Mobiles to the cart of Amazon
  @tag2
  Scenario Outline: Adding mobiles randomly to the cart
    Given The user is in Amazon HomePage
    When The user searches the product on search option and navigates to new page
    And The user selects the choice of his/her mobile "<mobile>"
    Then The selected mobile is added to the cart

    Examples: 
      | mobile |
      | 5 |   

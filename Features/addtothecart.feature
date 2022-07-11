@cart
Feature: Add to Cart

Scenario: Add one quantity from Store
Given I'm on Store Page
When I add a "Blue Shoes" to the cart
Then I should see 1 "Blue Shoes" in the cart

Scenario Outline: Add one quantity from Store - examples
Given I'm on Store Page
When I add a "<product-name>" to the cart
Then I should see 1 "<product-name>" in the cart
Examples:
|product-name|
|Anchor Bracelet|
|Basic Blue Jeans|
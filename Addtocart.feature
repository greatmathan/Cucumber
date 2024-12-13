Feature: BookCart application demo

Scenario Outline:   Add a Product To the cart

Given User Should Navigate To the Application
And User should login As "<username>" and "<password>"
And User search a book"<book>"
When User Add the book to the cart
Then The cart badge should be updated


    Examples:  
    |username|password|book|
    |Mathan|pass123|harry potter and the chamber of secrets|
    |Mathan|pass123|harry potter and the chamber of secrets|
    
    
    
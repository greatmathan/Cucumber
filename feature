Feature: BookCart application Demo


Scenario:  Login should be sucess
  
   
   Given User should navigate to the application 
   And User Clicks on the login links
   And User Enter The Name As Mathan 
   And User Should Enter The Password as pass1234
   When User Clicks The Login button
   Then Login Should be sucess
   
   
   Scenario: Login should be Failed
   
   Given User should navigate to the application 
   And User Clicks on the login links
   And User Enter The username As Mathanone 
   And User Should Enter The Passwordnegative as pass123
   
   When User Clicks The Login button
   But Login Should be Failed
    

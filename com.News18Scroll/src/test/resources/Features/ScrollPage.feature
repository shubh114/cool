Feature: Scroll Feature
Description: Program to find element after scrolling



#Scenario Outline: Scroll down find last Section in English News18 pages
#    Given open browser
#    When  Navigate to News18 Page "<url>" from sheet "<SheetName>"
#    Then Scroll Down till last and find last section in English Homepage
    
  #  Then Scroll up and change language
 
  # Examples: 
  #   | SheetName | url |
  #    | News18    | EngUrl |
      
      
   Scenario Outline: Scroll up and change language
      Given open browser
    When  Navigate to News18 Page "<url>" from sheet "<SheetName>"
    And Scroll Down till last and find last section in English Homepage
    And Scroll up and change to hindi language
    And Scroll to half select one section
    And CLick on 10th link on that section 
    Then Scroll down print all element present in footer
    
    Examples: 
     | SheetName | url |
      | News18    | EngUrl |
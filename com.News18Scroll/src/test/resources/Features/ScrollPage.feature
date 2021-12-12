Feature: Scroll Feature
Description: Program to find element after scrolling


@OpenBrowser
Scenario Outline: Scroll down find last Section in English News18 pages
    Given open browser
    When  Navigate to News18 Page "<url>" from sheet "<SheetName>"
    Then Scroll Down till last and find last section in English Homepage
 
    Examples: 
      | SheetName | url |
      | News18    | EngUrl |
# Created by Chris-Acer at 2019/11/13
@smoke
Feature: Validate the initial deposit amount
  As a Customer,
  I want to get the correct info after search "selenium" on google
  and click the first one can go to corresponding link.


  Scenario: search "selenium" on google and click the first one
    When navigate to google home page
    And input below text to search
      | text     |
      | selenium |
    And press enter to search
    Then can see the search result as below
      | first message contains |
      | selenium               |
    When customer click the first search result
    Then can see the page navigate to link
      | page title                              |
      | Selenium automates browsers. That's it! |



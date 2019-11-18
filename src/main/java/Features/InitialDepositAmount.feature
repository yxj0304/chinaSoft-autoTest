# Created by Chris-Acer at 2019/11/13
@smoke1
Feature: Validate the initial deposit amount
  As a Customer,
  I want to get the correct message when I input valid and value into initial deposit amount,
  also get the warning message when I input invalid value to this field.


  Scenario Outline: Input valid field
    When navigate to sfx-calculator page
    And input value to initial deposit amount filed as below
      | initial deposit amount   |
      | <initial deposit amount> |
    Then customer can see the info as below
      | tip message   | input amount   |
      | <tip message> | <input amount> |
    Examples:
      | initial deposit amount | tip message | input amount |
      | 1000                   | none        | 1,000        |
      | 25000                  | none        | 25,000       |
      | 250                    | none        | 250          |



  Scenario Outline: Input valid field
    When navigate to sfx-calculator page
    And input value to initial deposit amount filed as below
      | initial deposit amount   |
      | <initial deposit amount> |
    Then customer can see the info as below
      | tip message   | input amount   |
      | <tip message> | <input amount> |
    Examples:
      | initial deposit amount | tip message                         | input amount |
      | 100000                 | Enter a value between 250 and 25000 | 100,000      |
      | 249                    | Enter a value between 250 and 25000 | 249          |
      | 25001                  | Enter a value between 250 and 25000 | 25,001       |

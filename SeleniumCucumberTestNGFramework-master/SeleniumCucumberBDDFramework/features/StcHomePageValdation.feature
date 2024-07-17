Feature: STC TV Home page subscription type price validation for all countries

Scenario Outline: validating the price and subscription type
    Given Open Chrome browser with URL
    When Click the <country> to validate the currency detail for specific subscription 
    And Validate the subscription package type for each <country>
    Then Validate the <currency> detail for each <country> selected

     Examples:
      | country   |currency |
      | sa  	  |SAR	    |
      | bh        |BHD	    |
      | kw        |KWD	    |
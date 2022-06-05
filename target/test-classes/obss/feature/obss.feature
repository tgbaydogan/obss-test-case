Feature: Obss login

  Scenario: Scenario1: Case success
    Given open "chrome"
    And go to "https://obss.com.tr/en/"
    And accept cookies
    Then click search area
    Then search area write "Automation"
    Then verify that results are listed
    Then click the first
    Then verify that the page is out
    Then go to the bottom of the page
    Then verify obss footer

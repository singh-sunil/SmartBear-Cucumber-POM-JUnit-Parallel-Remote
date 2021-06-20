Feature: Login to Smart Bear Products individual sites

  @chrome @edge @firefox
  Scenario Outline: As a Smart Bear user I shall be able to visit to each offered Products Login site
    Given I clicked on Login button
    When I choose any "<Product>"
    Then I shall be redirected to that "<Product>" own login page

    Examples:
      | Product             |
      | AlertSite           |
      | CrossBrowserTesting |
      | CucumberStudio      |
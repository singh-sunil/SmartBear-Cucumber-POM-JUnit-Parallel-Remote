Feature: Login to A Single Smart Bear Product individual site

  @chrome
  Scenario: As a Smart Bear user I shall be able to visit to a given offered Product Login site
    Given I clicked on Login button at header
    When I choose following Product
      | AlertSite |
    Then I shall be redirected to that Product own login page

  @firefox
  Scenario: As a Smart Bear user I shall be able to visit to a given offered Product Login site
    Given I clicked on Login button at header
    When I choose following Product
      | CrossBrowserTesting |
    Then I shall be redirected to that Product own login page

  @edge
  Scenario: As a Smart Bear user I shall be able to visit to a given offered Product Login site
    Given I clicked on Login button at header
    When I choose following Product
      | CucumberStudio |
    Then I shall be redirected to that Product own login page
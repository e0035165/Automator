Feature:Open and setup GfGPage
  @GfgSetup
  Scenario:Go to GfG Website
    Given I am on google webpage
    When I search for GfG page
    Then I should arrive to the search page
    When I click on the GfG header link
    Then I should arrive to the GfG Website

    
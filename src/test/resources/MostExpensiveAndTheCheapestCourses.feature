@withdrawal33
Feature: Open browser which user select/type and find and open needed course

  Scenario: User open "OTUS" preparatory courses and find the most expensive and the cheapest course

    Given user starts browser 'chrome'

    Then user open preparatory courses

    Then user find the most expensive and the cheapest course
@check_date_course

Feature: Open browser which user select/type and find course

  Scenario: User open "OTUS" mainpage, search for courses starting on or after the specified date
    
    Given user starts browser 'chrome'

    Then user open main page

    Given some date value 21.01.2022
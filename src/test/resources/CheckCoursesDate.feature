@check_date_course

Feature: Open browser which user select/type and find course starting on or after the specified date

  Scenario: User open "OTUS" prepare courses page, search for courses starting on or after the specified date
    
    Given user starts browser 'chrome'
#
    Then user open main page

#    Given some date value 31 марта
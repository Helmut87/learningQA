@check_course_by_date

Feature: Open browser which user select/type and find course starting on or after the specified date

  Scenario: User open "OTUS" prepare courses page, search for courses starting on or after the specified date
    
    Given user starts browser 'chrome'

    Then user open main page

    Then user find course, witch start after 14 февраля

    Then user find course, witch start in 30 апреля

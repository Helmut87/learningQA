@find_course

Feature: Open browser which user select/type and find and open needed course

  Scenario: User open "OTUS" mainpage find and click on course

    Given user starts browser 'chrome'

    Then user open main page

    Then user find course with name 'Специализация QA Automation Engineer'
@find_course

Feature: Open browser which user select/type and find and open needed course

  Scenario: User open "OTUS" mainpage find and click on course

    Given user starts browser 'chrome'

    Then user open main page

    Then user find course with name 'Специализация QA Automation Engineer'





#  Реализовать выбор фабрики через фичу ("Я открываю браузер Chrome) check
#  Поиск указанного курса (название курса задается в фиче) и его выбора (в случае если несколько, то выбирается случайный) check

#  Поиск курсов, стартующих в указанную дату или позже указанной даты и вывод информации о них в консоль (название, дата старта)
#  Перейти в раздел Курсы > Подготовительные курсы, выбрать самый дорогой и самый дешевый курс при помощи filter и вывод информации о нем в консоль. check
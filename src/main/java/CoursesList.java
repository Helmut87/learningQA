public enum CoursesList {
    COURSE_HILOAD("Highload Architect"),
    COURSE_RANDOM_NAME("Случайный курс, которого нет"),
    COURSE_JS_DEV("JavaScript Developer. Professional"),
    COURSE_ANDROID_DEV("Специализация Android-разработчик"),
    COURSE_FULLSTACK("Специализация Fullstack Developer"),
    COURSE_QA_AUTOMATION("Специализация QA Automation Engineer"),
    COURSE_JAVA_DEV("Специализация Java-разработчик"),
    COURSE_DATA_SCIENCE("Специализация Data Scientist"),
    COURSE_RANDOM_RANDOM("Еще один случайный курс, которого нет"),
    COURSE_CSHARP_DEV("Специализация С#"),
    COURSE_LINUX_ADM("Специализация Administrator Linux"),
    ;

    private String coursename;

    CoursesList(String coursename) {
        this.coursename = coursename;
    }

    @Override
    public String toString() {
        return coursename;
    }
}

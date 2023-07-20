package org.example;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Student {
    private static final List<String> FIRST_NAMES= List.of("John","Emma","michael","sophia","David","Emily");
    private static final List<String> LAST_NAMES= List.of("smith","Johnson","Brown","Taylor","Miller","Davis");

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private static final List<String> COURSES= List.of("Math","Science","History","Geography","Music","Art");
    public Student() {
        this.firstName = FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size()));
        this.lastName = LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size()));
        this.coursesGrades=new HashMap<>();
        for (String courses:COURSES) {
            coursesGrades.put(courses,RANDOM.nextInt(101));
        }
        // COURSES.forEach(courses ->coursesGrades.put(courses,RANDOM.nextInt(101)));
    }
    private static final Random RANDOM =new Random();

    private final String firstName;
    private final   String lastName;
    private final Map<String,Integer> coursesGrades;

    public List getCourses(){
        return COURSES;
    }

    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", coursesGrades=" + coursesGrades +
                '}';
    }

    public Map<String, Integer> getCoursesGrades() {
        return coursesGrades;
    }

}

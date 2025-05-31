package hr.fer.oop;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws EnrollmentException {
        Course oop = new Course("OOP101", "Object Oriented Programming", 3);

        System.out.println(oop.getInfo());

        Student a = new Student("Student A", 11111);
        Student b = new Student("Student B", 22222);
        Student c = new Student("Student C", 33333);

        List<Student> studentsToEnroll = List.of(a, b, c);
        for (Student s : studentsToEnroll) {
            try {
                oop.enrollStudent(s);
            } catch (EnrollmentException e) {
                System.out.println("Error" + ": " + e.getMessage());
            }
        }
        System.out.println("Enrolled students in " + oop.getName() + ": " + oop.getEnrolledStudents());

// Enroll student d in advancedOopCourse (should fail due to missing prerequisite)
        Student d = new Student("Student D", 44444);
        Course advancedOopCourse = new Course("AOOP201", "Advanced OOP", 2);
        advancedOopCourse.addPrerequisite(oop);
        try {
            advancedOopCourse.enrollStudent(d);
        } catch (EnrollmentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
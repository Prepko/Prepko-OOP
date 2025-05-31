package hr.fer.oop;

import java.util.ArrayList;
import java.util.List;

public class Course extends GeneralInformation{

    protected int maxStudents;
    private List<Student> enrolledStudents;
    private List<Course> prerequisites;

    public Course(String id, String name, int maxStudents) {
        super(id, name);
        this.maxStudents = maxStudents;
        enrolledStudents = new ArrayList<Student>();
        prerequisites = new ArrayList<Course>();
    }

    public String getInfo(){
        return String.format("ID: %s, Name: %s, Max Students: %d", super.getId(), super.getName(), maxStudents);
    }

    public void addPrerequisite(Course course){
        prerequisites.add(course);
    }

    public boolean hasMetPrerequisites(Student student){
        for(Course course: prerequisites){
            if(!student.isEnrolledIn(course)){
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Course)) return false;

        Course c = (Course) obj;
        return c.getId().equals(this.getId()) &&
                c.getName().equals(this.getName());
    }

    @Override
    public void enrollStudent(Student student){
        if(maxStudents > enrolledStudents.size() && hasMetPrerequisites(student)){
            enrolledStudents.add(student);
            student.enrollInCourse(this);
        }
        else{
            throw new EnrollmentException("Student not enrolled in course his name is " + student.getStudentName());
        }
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Course> getPrerequisites() {
        return prerequisites;
    }
}

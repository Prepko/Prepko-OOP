package hr.fer.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STEMGames {
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(String name, int pointsEng, int pointsMath) {
        students.add(new Student(name, pointsEng, pointsMath));
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getTopMathStudentCount(int threshold){
        int count = 0;
        for(Student student : students){
            if(student.getPointsMath() >= threshold){
                count++;
            }
        }

        return count;
    }

    public int getTopEngStudentCount(int threshold){
        int count = 0;
        for(Student student : students){
            if(student.getPointsEng() >= threshold){
                count++;
            }
        }

        return count;
    }

    public int getTopTotalStudentCount(int threshold){
        int count = 0;
        for(Student student : students){
            if(student.getTotalPoints() >= threshold){
                count++;
            }
        }

        return count;
    }

    public Map<String, List<String>> getTopStudents(){
        int pragEngMath = 95;
        int pragTotal = 190;

        Map<String, List<String>> map = new HashMap<String, List<String>>();

        map.put("eng", new ArrayList<>());
        map.put("math", new ArrayList<>());
        map.put("total", new ArrayList<>());

        for(Student student : students){
            if(student.getPointsEng() >= pragEngMath){
                map.get("eng").add(student.getName());
            }
            if(student.getPointsMath() >= pragEngMath){
                map.get("math").add(student.getName());
            }
            if(student.getTotalPoints() >= pragTotal){
                map.get("total").add(student.getName());
            }
        }

        return map;
    }
}

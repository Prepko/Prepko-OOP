package hr.fer.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STEMGames {

    private List<Student> students = new ArrayList();

    public void addStudent(String name, int pointsEng, int pointsMath) {
        students.add(new Student(name, pointsEng, pointsMath));
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getHighestScoreInEng(){
        int highestScore = 0;
        for(Student student : students){
            if(student.getPointsEng() > highestScore){
                highestScore = student.getPointsEng();
            }
        }

        return highestScore;
    }

    public int getHighestScoreInMath(){
        int highestScore = 0;
        for(Student student : students){
            if(student.getPointsMath() > highestScore){
                highestScore = student.getPointsMath();
            }
        }

        return highestScore;
    }

    public int getHighestScoreInTotal(){
        int highestScore = 0;
        for(Student student : students){
            if(student.getTotalPoints() > highestScore){
                highestScore = student.getTotalPoints();
            }
        }

        return highestScore;
    }

    public Map<String, List<String>> getTopStudents(){
        Map<String, List<String>> topStudents = new HashMap();

        topStudents.put("eng", new ArrayList());
        topStudents.put("math", new ArrayList());
        topStudents.put("total", new ArrayList());

        int highestEng = getHighestScoreInEng();
        int highestMath = getHighestScoreInMath();
        int highestTotal = getHighestScoreInTotal();

        for(Student student : students){
            if(student.getPointsEng() == highestEng){
                topStudents.get("eng").add(student.getName());
            }
            if(student.getPointsMath() == highestMath){
                topStudents.get("math").add(student.getName());
            }
            if(student.getTotalPoints() == highestTotal){
                topStudents.get("total").add(student.getName());
            }
        }

        return topStudents;
    }
}

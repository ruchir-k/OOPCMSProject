package com.accounts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Instructor {
    String name;
    String userName;
    String password;
    Course course;

    HashMap<Student, List<Evaluative>> evalOfStudents;
    public Instructor(String name, String userName, String password, Course course) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.course = course;
        course.setIc(this);

        evalOfStudents = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean checkLoginInstructor(String userName, String password){
        if (this.getUserName().equals(userName) && this.getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }

    public void evaluate(){
        List<Student> students = course.getStudents();
        for(Student s : students){
            Evaluative e = new Evaluative(course, 70, 100, 123);
            s.notifyEval(new ReadOnlyEvalImpl(e));
            if(evalOfStudents.containsKey(s))
                evalOfStudents.get(s).add(e);
            else{
                evalOfStudents.put(s, new ArrayList<>());
                evalOfStudents.get(s).add(e);
            }
        }
    }

    public void evaluate(Student s, int marks, int id){
        Evaluative e = new Evaluative(course, marks, 100, id);
        s.notifyEval(new ReadOnlyEvalImpl(e));
        evalOfStudents.get(s).add(e);
    }


}

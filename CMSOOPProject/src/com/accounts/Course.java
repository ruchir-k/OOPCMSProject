package com.accounts;

import java.util.*;

public class Course {
    private List<Student> students;
    private Instructor ic;
    private String name;

    public Course(String name){
        this.name = name;
        students = new ArrayList<>();

    }

    public void setIc(Instructor ic){
        this.ic = ic;
    }

    public void addStudent(Student s){

        if(!students.contains(s)){
            students.add(s);
        }
        else{
            System.out.println("Student already exists");
        }
    }




    public void view(Student s, int eNum){
        // return grade corresponding to s and eNum
        for (Student s1: students){
            if (s1.equals(s)){
                for (ReadOnlyEval eval: s1.getEvals()){
                    if (Objects.equals(eval.getId(), eNum)){
                        System.out.println("Marks Scored by the Student: "+ eval.getMarks());
                        System.out.println("Maximum marks possible: "+eval.getMaxMarks());
                    }
                }
            }
        }

    }

    public Instructor getIc(){
        return ic;
    }
    public String getName(){
        return name;
    }

    public List<Student> getStudents(){
        return students;
    }
}

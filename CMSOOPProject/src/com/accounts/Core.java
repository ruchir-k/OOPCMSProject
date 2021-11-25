package com.accounts;

import java.util.ArrayList;
import java.util.List;

public class Core {
    private static Core instance = new Core();
    private List<Course> courses;
    private List<Student> students;
    private List<Instructor> instructors;

    private Core(){
        courses = new ArrayList<Course>();
        // Add courses
        students = new ArrayList<>();
        instructors = new ArrayList<>();
    }

    public static Core getInstance(){
        return instance;
    }

    public Course getCourse(String name){
        //Search from list of courses and return the course
        for (Course course:courses){
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }



    public void addCourse(Course c){
        courses.add(c);
    }
    public void addStudent(Student s1){
        students.add(s1);
    }
    public void addInstructor(Instructor i){
        instructors.add(i);
    }
    public List<Student> getStudents(){
        return students;
    }

    public List<Instructor> getInstructors(){
        return instructors;
    }
}

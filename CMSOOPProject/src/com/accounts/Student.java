package com.accounts;

import java.util.ArrayList;
import java.util.List;

public class Student implements Notifiable{

    String name;
    String userName;
    String password;
    String id;
    List<Course> courses;
    List<ReadOnlyEval> evals;

    public Student(String name, String userName, String password, String id) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.id = id;
        this.courses = new ArrayList<>();
        evals = new ArrayList<>();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean checkLoginStudent(String userName, String password){
        if (this.getUserName().equals(userName) && this.getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }


    public void addEvals(ReadOnlyEval e){
        evals.add(e);
    }

    public List<ReadOnlyEval> getEvals() {
        return evals;
    }

    public void viewMarks(int e){

        for(ReadOnlyEval eval : evals){
            if( eval.getId() == e){
                // print details
                System.out.println("Marks scored by student: "+eval.getMarks());
                System.out.println("Max Marks possible: "+eval.getMaxMarks());
                break;
            }
        }
    }

    public void viewAllMarks(){

        int counter =0;
        for (ReadOnlyEval eval : evals){
            System.out.println("Id of evaluative: "+eval.getId());
            System.out.println("Marks scored by student: "+eval.getMarks());
            System.out.println("Max Marks possible: "+eval.getMaxMarks());
            System.out.println();
            counter++;
        }
        if(counter==0){
            System.out.println("Evaluative does not exist");
        }

    }

    public void registerCourse(String name){
        Course course = Core.getInstance().getCourse(name);
        course.addStudent(this);
    }

    @Override
    public boolean equals(Object s2){

        if(s2 instanceof Student)
            return ((Student)s2).getId() == getId();
        else
            return false;
    }

    @Override
    public int hashCode(){
        return getId().hashCode();
    }

    @Override
    public void notifyEval(ReadOnlyEval e) {
        evals.add(e);
    }
}

package com.company;

import com.accounts.*;

import java.io.*;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Student s1 = new Student("Shyam Singh", "shyamsingh","123","1");
        Student s2 = new Student("Shyadsfsdfsdm Singh", "shyamsifdfdngh","14523","454");

        Core.getInstance().addStudent(s1);
        Core.getInstance().addStudent(s2);

        Course c1 = new Course("CSF21");
        Core.getInstance().addCourse(c1);

        s1.registerCourse("CSF21");
        s2.registerCourse("CSF21");
        Instructor i1 = new Instructor("KJ", "KJ22", "KJ22", c1);

        System.out.println("Welcome to Course Management System");

        Scanner sc = new Scanner(System.in);

        int opt;
        do{
            System.out.println("Enter 1 to access as Student or Enter 2 to access as Instructor or Enter 3 to exit: ");
            opt = sc.nextInt();
            switch (opt) {
                case 1 -> {
                    //Access as student
                    System.out.println("Enter 1 to access an existing account or Enter 2 to create a new account:");
                    int opt1 = sc.nextInt();
                    if (opt1 == 1) {
                        //check if account is present
                        System.out.println("UserName");
                        String uname = sc.next();
                        System.out.println("Password");
                        String pword = sc.next();

                        int opt3;

                        for (Student s : c1.getStudents()) {
                            if (s.checkLoginStudent(uname, pword)) {

                                do {
                                    System.out.println("Enter 1 to view marks or Enter 2 to view details or Enter 3 to exit:");
                                    opt3 = sc.nextInt();
                                    switch (opt3) {
                                        case 1 -> {
                                            //view marks
                                            int opt4;
                                            System.out.println("Enter 1 to view all marks or Enter 2 to view marks by Evaluative id:");
                                            opt4 = sc.nextInt();
                                            if (opt4 == 1) {
                                                s.viewAllMarks();
                                            } else if (opt4 == 2) {
                                                System.out.println("Enter Evaluative id:");
                                                int eid = sc.nextInt();
                                                s.viewMarks(eid);
                                            }
                                        }
                                        case 2 -> {
                                            //view details
                                            System.out.println("Name: " + s.getName());
                                            System.out.println("Id: " + s.getId());
                                        }
                                        case 3 -> System.out.println("Redirecting to main menu...");
                                        default -> System.out.println("Invalid input! Try again");
                                    }
                                } while (opt3 != 3);
                            }
                        }


                    } else if (opt1 == 2) {
                        System.out.println("Enter the details for creating a new student account");
                        System.out.println("UserName");
                        String uname = sc.next();
                        System.out.println("Password");
                        String pword = sc.next();
                        System.out.println("Name:");
                        String name = sc.next();
                        System.out.println("Id:");
                        String idnum = sc.next();

                        Student s = new Student(name, uname, pword, idnum);
                        Core.getInstance().addStudent(s);
                        s.registerCourse("CSF21");

                    }
                }
                case 2 -> {
                    //Access as instructor
                    System.out.println("UserName");
                    String uname = sc.next();
                    System.out.println("Password");
                    String pword = sc.next();
                    int opt2;
                    if (i1.checkLoginInstructor(uname, pword)) {
                        do {
                            System.out.println("Enter 1 to view students or Enter 2 to add Evaluative or Enter 3 to view Marks or Enter 4 to exit: ");
                            opt2 = sc.nextInt();

                            switch (opt2) {
                                case 1:
                                    //view students
                                    for (Student s : c1.getStudents()) {
                                        System.out.println("Name: " + s.getName());
                                        System.out.println("Id: " + s.getId());
                                    }

                                    break;

                                case 2:
                                    //add evaluative
                                    System.out.println("Enter student id to enter marks: ");
                                    String sid = sc.next();
                                    for (Student s : c1.getStudents()) {
                                        if (s.getId().equals(sid)) {
                                            System.out.println("Enter evaluative id: ");
                                            int eid = sc.nextInt();
                                            System.out.println("Enter marks scored: ");
                                            int mscored = sc.nextInt();
                                            System.out.println("Enter maximum marks");
                                            int maxmarks = sc.nextInt();
                                            Evaluative e = new Evaluative(c1, mscored,maxmarks,eid);
                                            ReadOnlyEval e1 = new ReadOnlyEvalImpl(e);
                                            s.addEvals(e1);
                                        }
                                    }
                                    break;


                                case 3:
                                    //view marks
                                    System.out.println("Enter student id to view their marks: ");
                                    String sid1 = sc.next();
                                    int count = 0;
                                    for (Student s : c1.getStudents()) {
                                        if (s.getId().equals(sid1)) {
                                            s.viewAllMarks();
                                            count++;
                                        }
                                    }
                                    if (count==0){
                                        System.out.println("Student with given id does not exist");
                                    }
                                    break;

                                case 4:
                                    System.out.println("Redirecting to main menu...");
                                    break;

                                default:
                                    System.out.println("Invalid input! Try again");
                                    break;

                            }

                        } while (opt2 != 4);
                    }
                }
                case 3 -> System.out.println("Thank you for using! Exiting....");
                default -> System.out.println("Invalid input! Please try again.");
            }
        }while(opt !=3);
        sc.close();
    }
}

package com.company;

import com.accounts.Course;
import com.accounts.Core;
import com.accounts.Instructor;
import com.accounts.Student;

public class Test {
    public static void main(String args[]){


        Student s1 = new Student("Shyam Singh", "shyamsingh","123","1");
        Student s2 = new Student("Shyadsfsdfsdm Singh", "shyamsifdfdngh","14523","454");

        Core.getInstance().addStudent(s1);
        Core.getInstance().addStudent(s2);

        Course c1 = new Course("CSF21");
        Core.getInstance().addCourse(c1);

        s1.registerCourse("CSF21");
        Instructor i1 = new Instructor("KJ", "KJ22", "KJ22", c1);

        i1.evaluate();
        s1.viewAllMarks();


    }
}

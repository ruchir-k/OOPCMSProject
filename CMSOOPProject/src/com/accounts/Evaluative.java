package com.accounts;

public class Evaluative {
    Course course;
    int marksScored;
    int maxMarks;
    int id;

    public Evaluative(Course course, int marksScored, int maxMarks, int id) {
        this.course = course;
        this.marksScored = marksScored;
        this.maxMarks = maxMarks;
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getMarksScored() {
        return marksScored;
    }

    public void setMarksScored(int marksScored) {
        this.marksScored = marksScored;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

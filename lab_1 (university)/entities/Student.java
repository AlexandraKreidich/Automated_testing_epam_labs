package entities;

import java.util.ArrayList;

public class Student {
    private int id;
    private ArrayList<Subject> attendingSubjects;
    private ArrayList<Mark> marks;

    public Student(int _id) {
        this.id = _id;
        this.attendingSubjects = new ArrayList<>();
        this.marks = new ArrayList<>();
    }

    public Student(int _id, ArrayList<Subject> _attendingSubjects, ArrayList<Mark> _marks) {
        this.id = _id;
        this.attendingSubjects = new ArrayList<>(_attendingSubjects);
        this.marks = new ArrayList<>(_marks);
    }

    public int getId() {
        return this.id;
    }

    public ArrayList<Subject> getAttendingSubjects() {
        return this.attendingSubjects;
    }

    public ArrayList<Mark> getMarks() {
        return this.marks;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public void addSubject(Subject _attendingSubject) {
        this.attendingSubjects.add(_attendingSubject);
    }

    public void addMark(Mark _mark) {
        this.marks.add(_mark);
    }
}

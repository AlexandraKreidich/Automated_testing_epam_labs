package entities;

import java.util.ArrayList;

public class Group {

    private int groupId;
    private ArrayList<Student> students;

    public Group(int _groupId) {
        this.groupId = _groupId;
        this.students = new ArrayList<>();
    }

    public Group(int _groupId, ArrayList<Student> _students) {
        this.groupId = _groupId;
        this.students = new ArrayList<>(_students);
    }

    public int getGroupId() {
        return this.groupId;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void setGroupId(int _groupId) {
        this.groupId = _groupId;
    }

    public void addStudent(Student _student) {
        this.students.add(_student);
    }
}

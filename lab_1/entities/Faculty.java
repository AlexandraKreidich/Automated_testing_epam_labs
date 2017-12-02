package entities;

import java.util.ArrayList;

public class Faculty {
    private int facultyId;
    private ArrayList<Group> groups;
    private String name;

    public Faculty(int _facultyId, String _name) {
        this.facultyId = _facultyId;
        this.name = _name;
        this.groups = new ArrayList<>();
    }

    public Faculty(int _facultyId, String _name, ArrayList<Group> _groups) {
        this.facultyId = _facultyId;
        this.name = _name;
        this.groups = new ArrayList<>(_groups);
    }

    public int getFacultyId() {
        return this.facultyId;
    }

    public String getFacultyName() {
        return this.name;
    }

    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    public void setFacultyId(int _facultyId) {
        this.facultyId = _facultyId;
    }

    public void setFacultyName(String _name) {
        this.name = _name;
    }

    public void addGroup(Group _group) {
        this.groups.add(_group);
    }
}

package entities;

import java.util.ArrayList;

public class University {
    private int universityId;
    private ArrayList<Faculty> faculties;
    private String name;

    public University(int _universityId, String _name) {
        this.universityId = _universityId;
        this.faculties = new ArrayList<>();
        this.name = _name;
    }

    public University(int _universityId, ArrayList<Faculty> _faculties, String _name) {
        this.universityId = _universityId;
        this.faculties = new ArrayList<>(_faculties);
        this.name = _name;
    }

    public int getUniversityId() {
        return this.universityId;
    }

    public ArrayList<Faculty> getFaculties() {
        return this.faculties;
    }

    public String getName() {
        return this.name;
    }

    public void setUniversityId(int _universityId) {
        this.universityId = _universityId;
    }

    public void setUnivsityName(String _name) {
        this.name = _name;
    }

    public void addFaculty(Faculty _faculty) {
        this.faculties.add(_faculty);
    }
}

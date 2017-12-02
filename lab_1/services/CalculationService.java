package services;

import entities.*;
import java.util.ArrayList;

public class CalculationService {

    public double getAverageMarksOfStudent(Student student) {
        double result = 0;
        ArrayList<Mark> marks = student.getMarks();

        int len = marks.size();

        for (int i = 0; i < len; ++i) {
            result += marks.get(i).getMark();
        }

        if (len > 0) {
            result = result / len;
        }

        return result;
    }

    public double getAverageMarksOfStudentBySubject(Student student, int subjectId) {
        double result = 0;
        ArrayList<Mark> marks = student.getMarks();

        int len = marks.size();

        for (int i = 0; i < len; ++i) {
            if (marks.get(i).getSubjectId() == subjectId) {
                result += marks.get(i).getMark();
            }
        }

        if (len > 0) {
            result = result / len;
        }

        return result;
    }

    public double getAverageMarksOfGroup(Group group) {
        double result = 0;
        ArrayList<Student> students = group.getStudents();

        int len = students.size();

        for (int i = 0; i < len; ++i) {
            result += this.getAverageMarksOfStudent(students.get(i));
        }

        if (len > 0) {
            result = result / len;
        }

        return result;
    }

    public double getAverageMarksOfFaculty(Faculty faculty) {
        double result  = 0;
        ArrayList<Group> groups = faculty.getGroups();

        int len = groups.size();

        for (int i = 0; i < len; ++i) {
            result += this.getAverageMarksOfGroup(groups.get(i));
        }

        if (len > 0) {
            result = result / len;
        }

        return result;
    }

    public double getAverageMarksOfUniversity(University university) {
        double result = 0;
        ArrayList<Faculty> faculties = university.getFaculties();

        int len = faculties.size();

        for (int i = 0; i < len; ++i) {
            result += this.getAverageMarksOfFaculty(faculties.get(i));
        }

        if (len > 0) {
            result = result / len;
        }

        return result;
    }

}

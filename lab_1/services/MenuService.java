package services;

import entities.Faculty;
import entities.Group;
import entities.Student;
import entities.University;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    private University university;

    public MenuService(University university) {
        this.university = university;
        this.showMenu();
        this.handleInput();
    }

    private void showMenu(){
        System.out.println("Available actions:");
        System.out.println("1) Show faculties;");
        System.out.println("2) Show groups;");
        System.out.println("3) Show students;");
        System.out.println("4) Calculate average marks for student;");
        System.out.println("5) Calculate average marks for group;");
        System.out.println("6) Calculate average marks for faculty;");
        System.out.println("7) Calculate average marks for university;");
        System.out.println("8) Exit");
    }

    private void handleInput() {
        while (true) {
            try {
                int option = new Scanner(System.in).nextInt();

                switch (option) {
                    case 1:
                        this.showFaculties(university.getFaculties());
                        this.showMenu();
                        break;

                    case 2:
                        this.showGroups(university.getFaculties());
                        this.showMenu();
                        break;

                    case 3:
                        this.showStudents(university.getFaculties());
                        this.showMenu();
                        break;

                    case 4:
                        this.calculateAverageForStudent(university.getFaculties());
                        this.showMenu();
                        break;

                    case 5:
                        this.calculateAverageForGroup(university.getFaculties());
                        this.showMenu();
                        break;

                    case 6:
                        this.calculateAverageForFaculty(university.getFaculties());
                        this.showMenu();
                        break;

                    case 7:
                        this.calculateAverageForUniversity(university);
                        this.showMenu();
                        break;

                    case 8:
                        return;

                    default:
                        System.out.println("Unknown parameter.");
                        this.showMenu();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void showFaculties(ArrayList<Faculty> faculties) {
        int len = faculties.size();
        System.out.println(len);
        for (int i = 0; i < len; ++i) {
            System.out.println("Faculty #" + faculties.get(i).getFacultyId());
        }
    }

    private void showGroups(ArrayList<Faculty> faculties) {
        this.showFaculties(faculties);
        System.out.println("Select faculty:");
        int facultyId = -1;

        try {
            facultyId = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            e.printStackTrace();
        }

        this.showGroupsOfFaculty(facultyId, faculties);
    }

    private void showGroupsOfFaculty(int facultyId, ArrayList<Faculty> faculties) {
        int len = faculties.size();
        for (int i = 0; i < len; ++i) {
            if (faculties.get(i).getFacultyId() == facultyId) {
                ArrayList<Group> groups = faculties.get(i).getGroups();

                System.out.println("Groups of faculty #" + facultyId);
                for (int j = 0; j < groups.size(); ++j) {
                    System.out.println("Group #" + groups.get(j).getGroupId());
                }
            }
        }

    }

    private void showStudents(ArrayList<Faculty> faculties) {
        int facultyId = -1;
        int groupId   = -1;

        try {
            this.showFaculties(faculties);
            System.out.println("Select faculty:");
            facultyId = new Scanner(System.in).nextInt();

            this.showGroupsOfFaculty(facultyId, faculties);

            System.out.println("Select group:");
            groupId   = new Scanner(System.in).nextInt();
        } catch(Exception e) {
            e.printStackTrace();
        }
        int lenF = faculties.size();
        for (int i = 0; i < lenF; ++i) {
            if (faculties.get(i).getFacultyId() == facultyId) {
                this.showStudentsOfGroup(groupId, faculties.get(i).getGroups());
            }
        }
    }

    private void showStudentsOfGroup(int groupId, ArrayList<Group> groups) {
        int lenG = groups.size();
        for (int i = 0; i < lenG; ++i) {
            if (groups.get(i).getGroupId() == groupId) {
                ArrayList<Student> students = groups.get(i).getStudents();
                int lenS = students.size();
                System.out.println("Students of group #" + groupId);
                for (int j = 0; j < lenS; ++j) {
                    System.out.println("Student #" + students.get(j).getId());
                }
            }
        }
    }

    private void calculateAverageForStudent(ArrayList<Faculty> faculties) {
        int facultyId = -1;
        int groupId   = -1;
        int studentId = -1;

        try {
            this.showFaculties(faculties);
            System.out.println("Enter faculty id:");
            facultyId = new Scanner(System.in).nextInt();
            int lenF = faculties.size();
            for (int i = 0; i < lenF; ++i) {
                if (faculties.get(i).getFacultyId() == facultyId) {
                    this.showGroupsOfFaculty(facultyId, faculties);
                    System.out.println("Enter group id:");
                    groupId = new Scanner(System.in).nextInt();
                    ArrayList<Group> groups = faculties.get(i).getGroups();
                    int lenG = groups.size();
                    for (int j = 0; j < lenG; ++j) {
                        if (groups.get(i).getGroupId() == groupId) {
                            this.showStudentsOfGroup(groupId, groups);
                            System.out.println("Enter student id:");
                            studentId = new Scanner(System.in).nextInt();
                            ArrayList<Student> students = groups.get(i).getStudents();
                            int lenS = students.size();
                            for (int k = 0; k < lenS; ++k) {
                                if (students.get(i).getId() == studentId) {
                                    System.out.println(
                                            "Average mark of student #" +
                                                    studentId +
                                                    " is: " +
                                                    new CalculationService().getAverageMarksOfStudent(students.get(k))
                                    );
                                }
                            }
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForGroup(ArrayList<Faculty> faculties) {
        int facultyId = -1;
        int groupId   = -1;

        try {
            this.showFaculties(faculties);
            System.out.println("Enter faculty id:");
            facultyId = new Scanner(System.in).nextInt();
            int lenF = faculties.size();
            for (int i = 0; i < lenF; ++i) {
                if (faculties.get(i).getFacultyId() == facultyId) {
                    this.showGroupsOfFaculty(facultyId, faculties);
                    System.out.println("Enter group id:");
                    groupId = new Scanner(System.in).nextInt();
                    ArrayList <Group> groups = faculties.get(i).getGroups();
                    int lenG = groups.size();
                    for (int j = 0; j < lenG; ++j) {
                        if (groups.get(j).getGroupId() == groupId) {
                            System.out.println(
                                    "Average mark of group #" +
                                            groupId +
                                            " is: " +
                                            new CalculationService().getAverageMarksOfGroup(groups.get(j))
                            );
                        }
                    }
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForFaculty(ArrayList<Faculty> faculties) {
        int facultyId = -1;

        try {
            this.showFaculties(faculties);
            System.out.println("Enter faculty id:");
            facultyId = new Scanner(System.in).nextInt();
            int lenF = faculties.size();
            for (int i = 0; i < lenF; ++i) {
                if (faculties.get(i).getFacultyId() == facultyId) {
                    System.out.println(
                            "Average mark of faculty #" +
                                    facultyId +
                                    " is: " +
                                    new CalculationService().getAverageMarksOfFaculty(faculties.get(i))
                    );
                }
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void calculateAverageForUniversity(University university) {
        System.out.println(
                "Average mark of university #" +
                        university.getUniversityId() +
                        " is: " +
                        new CalculationService().getAverageMarksOfUniversity(university)
        );
    }
}

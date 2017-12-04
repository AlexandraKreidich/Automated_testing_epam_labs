package services;

import entities.*;

public class CreatorService {

    public University CreateUniversity(){
        University bsu = new University(1, "BSU");
        Subject algebra = new Subject(001, "Algebra");
        Subject geometry = new Subject(002, "Geometry");
        Subject computerScience = new Subject(003, "Computer Science");
        Subject algorithms = new Subject(004, "Algorithms");
        Subject english = new Subject(005, "English");
        Student sasha = new Student(01);
        Student lera = new Student(02);
        Student diana = new Student(03);
        Student roma = new Student(04);
        Student dima = new Student(05);
        Student andrey = new Student(06);
        sasha.addSubject(algebra);
        sasha.addMark(new Mark(algebra.getId(), 9));
        sasha.addSubject(algorithms);
        sasha.addMark(new Mark(algorithms.getId(), 8));
        lera.addSubject(computerScience);
        lera.addMark(new Mark(computerScience.getId(), 8));
        andrey.addSubject(english);
        andrey.addMark(new Mark(english.getId(), 7));
        andrey.addSubject(geometry);
        andrey.addMark(new Mark(geometry.getId(), 6));
        diana.addSubject(english);
        diana.addMark(new Mark(english.getId(), 10));
        diana.addSubject(algebra);
        diana.addMark(new Mark(algebra.getId(), 8));
        roma.addSubject(english);
        roma.addMark(new Mark(english.getId(), 9));
        dima.addSubject(algebra);
        dima.addMark(new Mark(algebra.getId(), 6));
        dima.addSubject(algorithms);
        dima.addMark(new Mark(algorithms.getId(), 7));
        Group firstGroup = new Group(9);
        firstGroup.addStudent(sasha);
        firstGroup.addStudent(lera);
        Group secondGroup = new Group(7);
        secondGroup.addStudent(diana);
        secondGroup.addStudent(roma);
        Group thirdGroup = new Group(3);
        thirdGroup.addStudent(dima);
        thirdGroup.addStudent(andrey);
        Faculty mmf = new Faculty(11, "Mechanics and mathematics faculty");
        Faculty famcs = new Faculty(12, "Faculty of applied mathematics and computer science");
        mmf.addGroup(firstGroup);
        mmf.addGroup(secondGroup);
        famcs.addGroup(thirdGroup);
        bsu.addFaculty(mmf);
        bsu.addFaculty(famcs);
        return bsu;
    }

}

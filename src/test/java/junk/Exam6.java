package junk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam6 {
    public static void main(String[] args) {
        List<Students> listOfStud = new ArrayList<>();
        Students stud1 = new Students();
        stud1.name = "Name";
        stud1.surname = "Surn";
        stud1.birthYear = 1991;
        stud1.group = 3;
        stud1.course = 5;
        stud1.geography = 6;
        stud1.math = 9;

        listOfStud.add(stud1);

        Students stud2 = new Students("SURNAME2", "NAME1", 1988, 5, 2, 2, 4);
        listOfStud.add(stud2);
        Students stud3 = new Students("SURNAME22", "NAME12", 1997, 5, 2, 3, 6);
        listOfStud.add(stud3);
        Students stud6 = new Students("SURNAME22", "NAME12", 1999, 5, 6, 3, 6);
        listOfStud.add(stud6);

        Collections.sort(listOfStud, new StudentBirthComparator());
        System.out.println(listOfStud);

    }

}


//        Упорядочите студентов по курсу, причем студенты одного курса располагались в алфавитном порядке.
//        Найдите средний балл каждой группы по каждому предмету.
//        Определите самого старшего студента и самого младшего студентов.
//        Для каждой группы найдите лучшего с точки зрения успеваемости студента.
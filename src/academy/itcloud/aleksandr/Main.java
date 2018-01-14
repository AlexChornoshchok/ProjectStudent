package academy.itcloud.aleksandr;

import academy.itcloud.aleksandr.manage.*;
import academy.itcloud.aleksandr.model.*;


public class Main {

    public static void main(String... args) {

        ControlPerson.addTrener("Albert ", "Einstein", 139);
        ControlPerson.addStugent("Ivan", "Ivanov ", 27);
        ControlPerson.addStugent("Petr", "Petrov ", 25);
        ControlPerson.addStugent("Sidor", "Sidorov ", 22);
        ControlPerson.addStugent("Aleksandr", "Aleksandrov ", 24);
        ControlPerson.addTrener("Lev ", "Landau", 110);

//        ControlPerson.printTrainer();
//        ControlPerson.printStudent();

        ControlSubject controlSubject = new ControlSubject();
        controlSubject.createSubject("Basics of programming", "Learning the basics of programming", 1, "01.02.2018", "01.03.2018");
        controlSubject.changedaysOfTheWeeks(1, DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
        controlSubject.changePeriod(1, "03.02.2018", "01.03.2018");
        controlSubject.createSubject("Java of programming", "Learning the java of programming", 6, "12.02.2018", "01.04.2018");
        controlSubject.changedaysOfTheWeeks(2, DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
        controlSubject.printCourseList();
        controlSubject.createSubject("Java of programming", "Learning the java of programming", 6, "12.02.2018", "01.04.2018");

        controlSubject.addTaskOfCourse(1,"Task1", "Task2", "Task3");
        controlSubject.addStudentOfCourse(1, 2);
        controlSubject.addStudentOfCourse(1, 3);
        controlSubject.addStudentOfCourse(1, 4);

        controlSubject.printFullInfoOfCourse(1);
        controlSubject.printFullInfoOfCourse(2);

    }
}

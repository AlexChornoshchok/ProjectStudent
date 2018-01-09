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

//        ControlPerson.printTrainerList();
//        ControlPerson.printStudentList();

        ControlCourse controlCourse = new ControlCourse();
        controlCourse.createCourse("Basics of programming", "Learning the basics of programming", 1, "01.02.208", "01.03.2018");
        controlCourse.changedaysOfTheWeeks(1, DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
        controlCourse.createCourse("Java of programming", "Learning the java of programming", 6, "12.02.208", "01.04.2018");
        controlCourse.changedaysOfTheWeeks(2, DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
//        controlCourse.printCourseList();
        controlCourse.createCourse("Java of programming", "Learning the java of programming", 6, "12.02.208", "01.04.2018");

        controlCourse.printFullCourse(1);

        controlCourse.addStudentOfCourse(1, 2);
        controlCourse.printFullCourse(1);
        controlCourse.addStudentOfCourse(1, 5);
        controlCourse.addStudentOfCourse(1, 4);
        controlCourse.printFullCourse(1);

    }
}

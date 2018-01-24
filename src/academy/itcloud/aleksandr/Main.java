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

//        ControlPerson.printAllTrainer();
//        ControlPerson.printAllStudent();
//        ControlPerson.printInfoTrainer(1);
//        ControlPerson.printInfoStudent(2);

        ControlCourse controlCourse = new ControlCourse();
        controlCourse.createSubject("Basics of programming",
                "Learning the basics of programming",
                1, "01.02.2018", "01.03.2018",
                 DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
        controlCourse.createSubject("Java of programming",
                "Learning the java of programming",
                6, "12.02.2018",
                "01.04.2018",
                 DaysOfTheWeek.MONDAY, DaysOfTheWeek.THURSDAY, DaysOfTheWeek.FRIDAY);
//        controlCourse.printCourseList();
//        controlCourse.createSubject("Java of programming", "Learning the java of programming", 6, "12.02.2018", "01.04.2018");

        controlCourse.addTaskOfCourse(1,"Task1", "Task2", "Task3");
        controlCourse.addStudentOfCourse(2, 2);
        controlCourse.addStudentOfCourse(1, 3);
        controlCourse.addStudentOfCourse(1, 4);
//        controlCourse.printInfoOfCourse(1);
//        controlCourse.printStudentsFromTheCourse(1);
//        controlCourse.printInfoOfCourse(2);
//        controlCourse.printStudentsFromTheCourse(2);
        controlCourse.removeStudentFromACourse(2,2);
//        controlCourse.transferOfTheStudent(2,1, 2);

//        controlCourse.printInfoOfCourse(1);
//        controlCourse.printStudentsFromTheCourse(1);
//        controlCourse.printInfoOfCourse(2);
//        controlCourse.printStudentsFromTheCourse(2);
        controlCourse.addStudentOfCourse(2, 2);
        controlCourse.printFullInfoOfCourse(2);

        controlCourse.printFullInfoOfCourse(1);

    }
}

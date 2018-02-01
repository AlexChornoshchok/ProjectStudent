package academy.itcloud.aleksandr.cli;

import academy.itcloud.aleksandr.model.Status;

import java.time.DayOfWeek;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

public class Console {

    private final String CHECK_NAME = "^[A-Z]?[a-z]";
    private final String CHECK_AGE = "\\d\\d";
    private boolean inputError;
    private Pattern pattern;
    private Matcher matcher;

    private CourseMap courseMap = new CourseMap();
    private Scanner console = new Scanner(System.in);

    public void start() {
        System.out.println("Select the number of the command: \n" +
                "TRAINER:\t" +
                "1. Create trainer; 2. Show list of Trainers; 3. Show full info of trainer;  \n" +
                "STUDENT:\t" +
                "4. Create student; 5. Show list of students; 6. Show full info of student; \n" +
                "COURSE: \t" +
                "7. Create course; 8. Show list of course; 9. Show full info of course; 10. Create task; \n" +
                "COURSE MANAGEMENT:\t" +
                "11. Add student of course; 12. Show students from the course ; 13. Moving a student between courses;  \n" +
                "JOURNAL:\t" +
                "14. Show journal of course; 15. Save journal in file; \n" +
                "00. Exit");
        String choice = console.nextLine();

        switch (choice) {
            case "1":
                createPerson(Status.TRAINER);
                break;
            case "2":
                printAllPerson(Status.TRAINER);
                break;
            case "3":
                printInfoPerson(Status.TRAINER);
                break;
            case "4":
                createPerson(Status.STUDENT);
                break;
            case "5":
                printInfoPerson(Status.STUDENT);
                break;
            case "6":
                printAllPerson(Status.STUDENT);
                break;
            case "7":
                createCourse();
                break;
            case "8":
                printCourseList();
                break;
            case "9":
                printFullInfoOfCourse();
                break;
            case "10":
                createTask();
                break;
            case "11":
                addStudentOfCourse();
                break;
            case "12":
                printStudentsFromTheCourse();
                break;
            case "13":
                transferOfTheStudent();
                break;
            case "14":
                printJournalOfCourse();
                break;
            case "15":
                saveJournalInFile();
                break;
            case "00":
                exitConsole();
                break;
//            default:
//                continueYesNo();
        }
    }


    private void createPerson(Status status) {
        System.out.print("Create " + (status == Status.STUDENT ? "student." : "trainer."));
        System.out.print("Enter first name\t");
        String firstName = console.next();
        System.out.print("Enter last name\t");
        String lastName = console.next();
        System.out.print("Enter last age\t");
        String age = console.next();
        if (Status.STUDENT == status) {
            PersonMap.addStudent(firstName, lastName, valueOf(age));
        } else if (Status.TRAINER == status) {
            PersonMap.addTrainer(firstName, lastName, valueOf(age));
        }
        start();
    }

    private void createCourse() {
        System.out.println("Create course.");
        System.out.print("Enter course name ");
        String courseName = console.nextLine();
        System.out.print("Enter description course ");
        String courseDescription = console.nextLine();
        System.out.print("Enter ID trainer's ");
        String ID_Trainer = console.nextLine();
        System.out.print("Enter date start course. Template (1900-01-01) ");
        String dateStart = console.nextLine();
        System.out.print("Enter date completion course. Template (1900-01-01) ");
        String dateEnd = console.nextLine();
        DayOfWeek[] daysOfWeeks = {DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY};
        courseMap.createCourse(courseName, courseDescription, valueOf(ID_Trainer), dateStart, dateEnd, daysOfWeeks);
        start();
    }

    private void createTask() {
        System.out.println("Create task.");
        System.out.print("Enter ID course\t");
        String ID = console.nextLine();
        System.out.println("Enter task\t");
        String tasks = console.nextLine();
        courseMap.addTaskOfCourse(valueOf(ID), tasks);
        start();
    }

    public void addStudentOfCourse() {
        System.out.println("Add student of course.");
        System.out.print("Enter ID course\t");
        String ID_Course = console.nextLine();
        System.out.println("Enter ID student\t");
        String ID_Student = console.nextLine();
        courseMap.addStudentOfCourse(valueOf(ID_Course), valueOf(ID_Student));
        start();
    }

    public void transferOfTheStudent() {
        System.out.println("Moving a student between courses.");
        System.out.print("Enter ID student");
        String ID_Student = console.nextLine();
        System.out.print("The ID of the course with which the student moves\t");
        String ID_CourseFrom = console.nextLine();
        System.out.print("The ID of the course to which the student moves\t");
        String ID_CourseTo = console.nextLine();
        courseMap.transferOfTheStudent(valueOf(ID_Student), valueOf(ID_CourseFrom), valueOf(ID_CourseTo));
        start();
    }

    private void printAllPerson(Status status) {
        PersonMap.printPerson(status);
        start();
    }

    private void printCourseList() {
        courseMap.printCourseList();
        start();
    }

    private void printFullInfoOfCourse() {
        System.out.print("Enter ID course\t");
        int ID = console.nextInt();
        courseMap.printFullInfoOfCourse(ID);
        start();
    }

    public void printInfoPerson(Status status) {
        System.out.printf("Enter ID%s%t", status);
        int ID = console.nextInt();
        PersonMap.printInfoPerson(ID);
        start();
    }

    public void printJournalOfCourse() {
        System.out.println("Enter ID of course\t");
        int ID = console.nextInt();
        courseMap.printJournalOfCourse(ID);
        start();
    }

    public void printStudentsFromTheCourse() {
        System.out.println("Enter ID of course\t");
        int ID = console.nextInt();
        courseMap.printStudentsFromTheCourse(ID);
        start();
    }

    public void saveJournalInFile() {
        System.out.println("Enter ID of course\t");
        int ID = console.nextInt();
        courseMap.saveJournalInFile(valueOf(ID));
        start();
    }

    private void exitConsole() {
        console.close();
    }
}

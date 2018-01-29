package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.DaysOfTheWeek;
import academy.itcloud.aleksandr.storige.Status;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.valueOf;

public class ControlConsole {

    private final String CHECK_NAME = "^[A-Z]?[a-z]";
    private final String CHECK_AGE = "\\d\\d";
    private boolean inputError;
    private Pattern pattern;
    private Matcher matcher;

    private ControlCourse controlCourse = new ControlCourse();
    private Scanner console = new Scanner(System.in);

    public void start() {
        System.out.println("Select the numbe of the command: \n" +
                "1. create trainer; 2. create student; 3. create course; 4. create task; \n" +
                "5. add student of course; 6. moving a student between courses; \n" +
                "7. print Trainer; 8. print student 9. Print full info of student; 10. Print full info of trainer  \n" +
                "11. print course list; 12. print full info of course \n" +
                "13. print journal of course; 14. print students from the course;  15. save journal in file; \n" +
                "00. Exit");
        String choice = console.nextLine();

        switch (choice) {
            case "1":
                createPerson(Status.TRAINER);
                break;
            case "2":
                createPerson(Status.STUDENT);
                break;
            case "3":
                createCourse();
                break;
            case "4":
                createTask();
                break;
            case "5":
                addStudentOfCourse();
                break;
            case "6":
                transferOfTheStudent();
                break;
            case "7":
                printAllPerson(Status.TRAINER);
                break;
            case "8":
                printAllPerson(Status.STUDENT);
                break;
            case "9":
                printInfoPerson();
                break;
            case "10":
                printInfoPerson();
                break;
            case "11":
                printCourseList();
                break;
            case "12":
                printFullInfoOfCourse();
                break;
            case "13":
                printJournalOfCourse();
                break;
            case "14":
                printStudentsFromTheCourse();
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
        inputError = false;
        System.out.println(inputError);
        System.out.println("Enter firstname, lastname and sge a " + (status == Status.STUDENT ? "student" : "trainer"));
        String firstName = console.next();
        if (!verification(CHECK_NAME, firstName)) {
            inputError = true;
        }
        System.out.println(inputError);
        String lastName = console.next();
//        if (!verification(CHECK_NAME, lastName)) {
//            inputError = true;
//        }
        String age = console.next();
//        if (!verification(CHECK_AGE, age)) {
//            inputError = true;
//        }
        if (inputError) {
            System.err.println("Not all the data have been entered or they are incorrect");
        } else {
            if (Status.STUDENT == status) {
                ControlPerson.addStudent(firstName, lastName, valueOf(age));
            } else if (Status.TRAINER == status){
                ControlPerson.addTrainer(firstName, lastName, valueOf(age));
            }
        }
       start();
    }

    private void createCourse(){
        System.out.println("Enter course name, Description, ID trainer's, date start and completion course, days of classes" );
        String courseName = console.nextLine();
        String courseDescription = console.nextLine();
        String ID_Trainer = console.nextLine();
        String dateStart = console.nextLine();
        String dateEnd = console.nextLine();
        DaysOfTheWeek[] daysOfTheWeeks = new DaysOfTheWeek[5];
        controlCourse.createCourse(courseName, courseDescription, valueOf(ID_Trainer), dateStart, dateEnd, daysOfTheWeeks);
        start();
    }

    private void createTask(){
        System.out.println("Enter ID course and task list");
        String ID = console.nextLine();
        String tasks = console.nextLine();
        controlCourse.addTaskOfCourse(valueOf(ID), tasks);
        start();
    }

    public void addStudentOfCourse(){
        System.out.println("Enter ID course and ID student");
        String ID_Course = console.nextLine();
        String ID_Student = console.nextLine();
        controlCourse.addStudentOfCourse(valueOf(ID_Course), valueOf(ID_Student));
        start();
    }

    public void transferOfTheStudent(){
        System.out.println("Enter ID student and ID from which course to which");
        String ID_Student = console.nextLine();
        String ID_CourseFrom = console.nextLine();
        String ID_CourseTo = console.nextLine();
        controlCourse.transferOfTheStudent(valueOf(ID_Student), valueOf(ID_CourseFrom), valueOf(ID_CourseTo));
        start();
    }

    private void printAllPerson(Status status){
        ControlPerson.printPerson(status);
        start();
    }

    private void printCourseList(){
        controlCourse.printCourseList();
        start();
    }

    private void printFullInfoOfCourse(){
        System.out.println("Enter ID course");
        int ID = console.nextInt();
        controlCourse.printFullInfoOfCourse(ID);
        start();
    }

    public void printInfoPerson(){
        System.out.println("Enter ID");
        int ID = console.nextInt();
        ControlPerson.printInfoPerson(ID);
        start();
    }

    public void printJournalOfCourse(){
        System.out.println("Enter ID of course");
        int ID = console.nextInt();
        controlCourse.printJournalOfCourse(ID);
        start();
    }

    public void printStudentsFromTheCourse(){
        System.out.println("Enter ID of course");
        int ID = console.nextInt();
        controlCourse.printStudentsFromTheCourse(ID);
        start();
    }

    public void saveJournalInFile(){
        System.out.println("Enter ID of course");
        int ID = console.nextInt();
        controlCourse.saveJournalInFile(valueOf(ID));
        start();
    }
    /// ******   special methods  *************
    private boolean verification(String ptrn, String cnsl) {
        pattern = Pattern.compile(ptrn);
        matcher = pattern.matcher(cnsl);
        return matcher.matches();
    }

    private void exitConsole() {
        console.close();
    }
}

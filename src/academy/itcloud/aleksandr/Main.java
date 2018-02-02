package academy.itcloud.aleksandr;


import academy.itcloud.aleksandr.jdbc.dao.h2.*;

public class Main {

    public static void main(String... args) {


///  ****CONSOLE

//    Console console = new Console();
//    console.start();

//        StudentH2 studentDAO = new StudentH2();
//        studentDAO.selectStudentHisCourse(1);
//        CourseH2 courseDAO = new CourseH2();
//        courseDAO.selectStudentsOnCourse(1);

        JournalH2 journalH2 = new JournalH2();
        journalH2.selectJournalOfTheCourse(1);

    }


}

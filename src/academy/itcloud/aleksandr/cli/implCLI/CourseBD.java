package academy.itcloud.aleksandr.cli.implCLI;

import academy.itcloud.aleksandr.cli.interfaceCLI.CourseCLI;
import academy.itcloud.aleksandr.jdbc.dao.CourseDAO;
import academy.itcloud.aleksandr.jdbc.dao.JournalDAO;
import academy.itcloud.aleksandr.jdbc.dao.TaskDAO;
import academy.itcloud.aleksandr.jdbc.dao.h2.CourseH2;
import academy.itcloud.aleksandr.jdbc.dao.h2.JournalH2;
import academy.itcloud.aleksandr.jdbc.dao.h2.TaskH2;

import java.time.DayOfWeek;

public class CourseBD implements CourseCLI {

    private CourseDAO course = new CourseH2();
    private JournalDAO journal = new JournalH2();
    private TaskDAO task = new TaskH2();

    @Override
    public void addCourse(String courseName, String courseDescription, int trainerId, String dateStart, String dateEnd, DayOfWeek[] daysOfWeeks) {
        course.addCourse(courseName, courseDescription, dateStart, dateEnd, "SUN, WEB, MON", trainerId);
    }

    @Override
    public void addTaskOfCourse(int courseId, String tasks) {

    }

    @Override
    public void addStudentOfCourse(int courseId, int studentId) {

    }

    @Override
    public void transferOfTheStudent(int studentId, int iDcourseFrom, int IdCourseTo) {

    }

    @Override
    public void printCourseList() {
        course.selectAllCourse();
    }

    @Override
    public void printFullInfoOfCourse(int courseId) {
        course.selectOneCourse(courseId);

    }

    @Override
    public void printJournalOfCourse(int courseId) {
        journal.selectJournalOfTheCourse(courseId);

    }

    @Override
    public void printStudentsFromTheCourse(int courseId) {
        course.selectStudentsOnCourse(courseId);
    }

    @Override
    public void saveJournalInFile(int courseId) {

    }
}

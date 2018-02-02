package academy.itcloud.aleksandr.cli.interfaceCLI;

import java.time.DayOfWeek;

public interface CourseCLI {

    void addCourse(String courseName, String courseDescription, int trainerId, String dateStart, String dateEnd, DayOfWeek[] daysOfWeeks);
    void addTaskOfCourse(int courseId, String tasks);
    void addStudentOfCourse(int courseId, int studentId);
    void transferOfTheStudent(int studentId, int iDcourseFrom, int IdCourseTo);
    void printCourseList();
    void printFullInfoOfCourse(int courseId);
    void printJournalOfCourse(int courseId);
    void printStudentsFromTheCourse(int courseId);
    void saveJournalInFile(int courseId);
}

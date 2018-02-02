package academy.itcloud.aleksandr.cli.implCLI;

import academy.itcloud.aleksandr.cli.interfaceCLI.CourseCLI;
import academy.itcloud.aleksandr.map.*;


public class CourseMapCLI implements CourseCLI {
    private CourseMap courseMap = new CourseMap();
    private PersonMap personMap = new PersonMap();

    @Override
    public void saveJournalInFile(int courseId) {
        courseMap.saveJournalInFile(courseId);
    }

    @Override
    public void printStudentsFromTheCourse(int courseId) {
        courseMap.printStudentsFromTheCourse(courseId);
    }

    @Override
    public void printJournalOfCourse(int courseId) {
        courseMap.printJournalOfCourse(courseId);
    }

    @Override
    public void printFullInfoOfCourse(int courseId) {
        courseMap.printFullInfoOfCourse(courseId);
    }

    @Override
    public void printCourseList() {
        courseMap.printCourseList();
    }

    @Override
    public void transferOfTheStudent(int studentId, int iDcourseFrom, int IdCourseTo) {

        courseMap.transferOfTheStudent(studentId, iDcourseFrom, IdCourseTo);
    }

    @Override
    public void addStudentOfCourse(int courseId, int studentId) {
        courseMap.addStudentOfCourse(courseId, studentId);
    }

    @Override
    public void addTaskOfCourse(int courseId, String tasks) {
        courseMap.addTaskOfCourse(courseId, tasks);
    }


    @Override
    public void addCourse(String courseName, String courseDescription, int trainerId, String dateStart, String dateEnd, java.time.DayOfWeek[] daysOfWeeks) {
        courseMap.addCourse(courseName, courseDescription, trainerId, dateStart, dateEnd, daysOfWeeks);
    }


}

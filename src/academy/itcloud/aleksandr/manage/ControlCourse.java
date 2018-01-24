package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;

import java.util.*;

public class ControlCourse {

    private static Map<Integer, Course> courseMap = new HashMap<>();

    public void createSubject(String courseName, String courseDescription, int ID_Trainer, String dateStart, String dateEnd, DaysOfTheWeek... daysOfTheWeeks) {
        boolean notRefuse = true;
        Subject subject;
        if (!courseMap.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = getPerson(ID_Trainer);
            if (trainer.human.getStatus() == Status.STUDENT) {
                System.out.println("A student can not be a teacher.");
                subject = createSubject(courseName, courseDescription, dateStart, dateEnd, daysOfTheWeeks);
            } else {
                subject = createSubject(courseName, courseDescription, trainer, dateStart, dateEnd, daysOfTheWeeks);
            }
            courseMap.put(subject.getID(), new Course(subject));
        }
    }

    public void printFullInfoOfCourse(int ID) {
        if (courseExists(ID)) {
            getCourse(ID).printInFullOfCourse();
        }
    }

    public void changedaysOfTheWeeks(int ID, DaysOfTheWeek... daysOfTheWeeks) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID).getSubject();
            subject.setDaysOfTheWeeks(daysOfTheWeeks);
        }
    }

    public void changeTrainer(Subject subject, int ID) {
        if (!ControlPerson.isStudent(ID)) {
            subject.setTrainer(getPerson(ID).human);
        }

    }

    public void changePeriod(int ID, String dateStart, String dateEnd) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID).getSubject();
            subject.setPeriod(dateStart, dateEnd);
        }
    }

    private Subject createSubject(String courseName, String coursDescription, Person trainer, String dateStart, String dateEnd, DaysOfTheWeek... daysOfTheWeeks) {
        Subject subject = new Subject.CourseBuilder(courseName)
                .courseDescription(coursDescription)
                .trainer(trainer.human)
                .period(dateStart, dateEnd)
                .daysOfTheWeeks(daysOfTheWeeks)
                .builder();
        return subject;
    }

    // add a course without a trainer
    private Subject createSubject(String courseName, String coursDescription, String dateStart, String dateEnd, DaysOfTheWeek... daysOfTheWeeks) {
        Subject subject = new Subject.CourseBuilder(courseName)
                .courseDescription(coursDescription)
                .period(dateStart, dateEnd)
                .daysOfTheWeeks(daysOfTheWeeks)
                .builder();
        return subject;
    }


    public static boolean courseExists(int ID) {
        if (!courseMap.containsKey(ID)) {
            System.out.println("No course with this ID " + ID);
            return false;
        }
        return true;
    }

    private Course getCourse(int ID) {
        return courseMap.get(ID);
    }

    private Person getPerson(int ID) {
        return ControlPerson.getPerson(ID);
    }

    private boolean checkName(String courseName) {
        for (Course course : courseMap.values()) {
            if (courseName.equals(course.getSubject().getCourseName())) {
                System.out.println("Subject name should be unique");
                return false;
            }
        }
        return true;
    }

    public void addTaskOfCourse(int ID, String... task) {
        if (courseExists(ID)) {
            getCourse(ID).createTask(task);
        }
    }

    public void addTaskOfCourse(int ID, String task) {
        if (courseExists(ID)) {
            getCourse(ID).createTask(task);
        }
    }

    public void addStudentOfCourse(int ID_Course, int ID_Student) {
        if (courseExists(ID_Course) && ControlPerson.isStudent(ID_Student)) {
            getCourse(ID_Course).addStudent(getPerson(ID_Student));
        }
    }

    private boolean isAStudentOnTheCourse(int ID_Course, int ID_Student) {
        if (courseExists(ID_Course) && ControlPerson.isStudent(ID_Student)) {
            return getCourse(ID_Course).isAStudentOnTheCourse(getPerson(ID_Student));
        } else {
            return false;
        }
    }

    public void removeStudentFromACourse(int ID_Course, int ID_Student) {
        if (isAStudentOnTheCourse(ID_Course, ID_Student)) {
            getCourse(ID_Course).removeStudent(getPerson(ID_Student));
        }
    }

    public void transferOfTheStudent(int ID_Student, int ID_CourseFrom, int ID_CourseTo) {
        if ((courseExists(ID_CourseFrom) && (courseExists(ID_CourseTo))) && ControlPerson.isStudent(ID_Student)) {
            if (isAStudentOnTheCourse(ID_CourseFrom, ID_Student)) {
                removeStudentFromACourse(ID_CourseFrom, ID_Student);
                addStudentOfCourse(ID_CourseTo, ID_Student);
            }
        }
    }

    public void printCourseList() {
        for (Map.Entry<Integer, Course> pair : courseMap.entrySet()) {
            System.out.println(pair.getValue().printInfoOfCourse());
        }
    }

    public void printInfoOfCourse(int ID) {
        if (courseExists(ID)) {
            System.out.println(getCourse(ID).printInfoOfCourse());
        }
    }

    public void printStudentsFromTheCourse(int ID) {
        if (courseExists(ID)) {
            getCourse(ID).printOfTheStudent();
        }
    }

/*
    public void printJournalOfCourse(int ID){
        if(courseExists(ID)){
            getCourse(ID).printJournal();
        }
    }
*/

}




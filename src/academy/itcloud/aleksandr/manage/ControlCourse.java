package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;

import java.io.IOException;
import java.util.*;

public class ControlCourse {
    private static final int NAME_OF_STUDENT_ON_THE_COURSE = 12;
    private static Map<Integer, Course> courseMap = new HashMap<>();

    public void createCourse(String courseName, String courseDescription,
                             int ID_Trainer, String dateStart, String dateEnd,
                             DaysOfTheWeek... daysOfTheWeeks) {
        boolean notRefuse = true;
        Subject subject;
        if (!courseMap.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = getPerson(ID_Trainer);
            if (!ControlPerson.personExists(ID_Trainer) || trainer.getStatus() == Status.STUDENT) {
                //               System.out.println("A student can not be a teacher.");
                subject = createSubject(courseName, courseDescription, dateStart, dateEnd, daysOfTheWeeks);
            } else {
                subject = createSubject(courseName, courseDescription, trainer, dateStart, dateEnd, daysOfTheWeeks);
            }
            Course course = new Course(subject);
            courseMap.put(subject.getID(), course);
            if (ControlPerson.personExists(ID_Trainer)) {
                if(trainer.getStatus() == Status.TRAINER){
                    ControlPerson.addCourseToPerson(ID_Trainer, course);
                }
            }
        }
    }

    private Subject createSubject(String courseName, String coursDescription,
                                  Person trainer, String dateStart, String dateEnd,
                                  DaysOfTheWeek... daysOfTheWeeks) {
        Subject subject = new Subject.CourseBuilder(courseName)
                .courseDescription(coursDescription)
                .trainer(trainer.human)
                .period(dateStart, dateEnd)
                .daysOfTheWeeks(daysOfTheWeeks)
                .builder();
        return subject;
    }

    // add a course without a trainer
    private Subject createSubject(String courseName, String coursDescription,
                                  String dateStart, String dateEnd,
                                  DaysOfTheWeek... daysOfTheWeeks) {
        Subject subject = new Subject.CourseBuilder(courseName)
                .courseDescription(coursDescription)
                .period(dateStart, dateEnd)
                .daysOfTheWeeks(daysOfTheWeeks)
                .builder();
        return subject;
    }

    public void changeDaysOfTheWeeks(int ID, DaysOfTheWeek... daysOfTheWeeks) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID).getSubject();
            subject.setDaysOfTheWeeks(daysOfTheWeeks);
        }
    }

/*
    public void changeTrainer(Subject subject, int ID) {
        if (ControlPerson.getStatus(ID) == Status.TRAINER) {
            subject.setTrainer(getPerson(ID).human);
        }
    }
*/

    public void changePeriod(int ID, String dateStart, String dateEnd) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID).getSubject();
            subject.setPeriod(dateStart, dateEnd);
        }
    }


    public static boolean courseExists(int ID) {
        if (!courseMap.containsKey(ID)) {
            System.out.println("No course with this ID " + ID);
            return false;
        }
        return true;
    }

    private static Course getCourse(int ID) {
        return courseMap.get(ID);
    }

    private Person getPerson(int ID) {
        return ControlPerson.getPerson(ID);
    }

    private boolean checkName(String courseName) {
        for (Course course : courseMap.values()) {
            if (courseName.equals(course.getSubject().getCourseName())) {
                System.out.println("Course name should be unique");
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

    public void addTrainerOfCourse(int ID_Course, int ID_Trainer) {
        if (courseExists(ID_Course) && ControlPerson.personExists(ID_Trainer)
                && ControlPerson.getStatus(ID_Trainer) == Status.TRAINER) {
            ControlPerson.addCourseToPerson(ID_Trainer, getCourse(ID_Course));
        }
    }

    public void addStudentOfCourse(int ID_Course, int ID_Student) {
        if (courseExists(ID_Course) && ControlPerson.personExists(ID_Student)
                && ControlPerson.getStatus(ID_Student) == Status.STUDENT) {
            Course course = getCourse(ID_Course);
            if (course.getJournal().size() < NAME_OF_STUDENT_ON_THE_COURSE) {
                course.addStudentOfCourse(getPerson(ID_Student));
                ControlPerson.addCourseToPerson(ID_Student, course);
            } else {
                System.out.println("Course " + ID_Course + " cannot have more than 12 students");
            }
        }
    }

    private boolean isAStudentOnTheCourse(int ID_Course, int ID_Student) {
        if (courseExists(ID_Course) && ControlPerson.getStatus(ID_Student) == Status.STUDENT) {
            return getCourse(ID_Course).isAStudentOnTheCourse(getPerson(ID_Student));
        } else {
            return false;
        }
    }

    public void removeStudentFromACourse(int ID_Course, int ID_Student) {
        if (isAStudentOnTheCourse(ID_Course, ID_Student)) {
            getCourse(ID_Course).removeStudent(getPerson(ID_Student));
            ControlPerson.removeCourseToPerson(ID_Student, getCourse(ID_Course));
        }
    }

    public void transferOfTheStudent(int ID_Student, int ID_CourseFrom, int ID_CourseTo) {
        if ((courseExists(ID_CourseFrom) && (courseExists(ID_CourseTo))) && ControlPerson.getStatus(ID_Student) == Status.STUDENT) {
            if (isAStudentOnTheCourse(ID_CourseFrom, ID_Student)) {
                this.removeStudentFromACourse(ID_CourseFrom, ID_Student);
                this.addStudentOfCourse(ID_CourseTo, ID_Student);
            }
        }
    }

    public void printFullInfoOfCourse(int ID) {
        if (courseExists(ID)) {
            getCourse(ID).printInFullOfCourse();
        }
    }

    public void printCourseList() {
        for (Map.Entry<Integer, Course> pair : courseMap.entrySet()) {
            System.out.println(pair.getValue().printNameOfCourse());
        }
    }

    public void printNameOfCourse(int ID) {
        if (courseExists(ID)) {
            System.out.println(getCourse(ID).printNameOfCourse());
        }
    }

    public void printStudentsFromTheCourse(int ID) {
        if (courseExists(ID)) {
            getCourse(ID).printOfTheStudent();
        }
    }

    public void printJournalOfCourse(int ID) {
        if (courseExists(ID)) {
            getCourse(ID).printJournal();
        }
    }

    public void saveJournalInFile(int ID) {
        try {
            ControlFile.writeFile(getCourse(ID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




package academy.itcloud.aleksandr.map;

import academy.itcloud.aleksandr.cli.File;
import academy.itcloud.aleksandr.model.*;

import java.time.DayOfWeek;
import java.io.IOException;
import java.util.*;

public class CourseMap {
    private static final int QUANTITY_OF_STUDENTS_ON_THE_COURSE = 12;
    private static Map<Integer, Course> courseMap = new HashMap<>();

    public void addCourse(String courseName, String courseDescription, int trainerId, String dateStart, String dateEnd, DayOfWeek... dayOfWeek) {
        boolean notRefuse = true;
        Course course;
        if (!courseMap.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = getPerson(trainerId);
            if (!PersonMap.personExists(trainerId) || trainer.getStatus() == Status.STUDENT) {
                course = addCourse(courseName, courseDescription, dateStart, dateEnd, dayOfWeek );
            } else {
                course = addCourse(courseName, courseDescription, trainer, dateStart, dateEnd, dayOfWeek);
            }
            courseMap.put(course.getID(), course);
            if (PersonMap.personExists(trainerId)) {
                if (trainer.getStatus() == Status.TRAINER) {
                    PersonMap.addCourseToPerson(trainerId, course);
                }
            }
        }
    }

    private Course addCourse(String courseName, String courseDescription, Person trainer,
                             String dateStart, String dateEnd, DayOfWeek... daysOfWeek) {
        Course course = new Course.CourseBuilder(courseName)
                .courseDescription(courseDescription)
                .trainer(trainer)
                .period(dateStart, dateEnd)
                .daysOfWeek(daysOfWeek)
                .builder();
        return course;
    }

    // addStudent a course without a trainer
    private Course addCourse(String courseName, String courseDescription, String dateStart, String dateEnd, DayOfWeek... daysOfWeek) {
        Course course = new Course.CourseBuilder(courseName)
                .courseDescription(courseDescription)
                .period(dateStart, dateEnd)
                .daysOfWeek(daysOfWeek)
                .builder();
        return course;
    }

    public void changePeriod(int ID, String dateStart, String dateEnd) {
        if (courseExists(ID)) {
            getCourse(ID).setPeriod(dateStart, dateEnd);
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
        return PersonMap.getPerson(ID);
    }

    private boolean checkName(String courseName) {
        for (Course course : courseMap.values()) {
            if (courseName.equals(course.getName())) {
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

    public void addTrainerOfCourse(int courseId, int trainerId) {
        if (courseExists(courseId) && PersonMap.personExists(trainerId)
                && PersonMap.getStatus(trainerId) == Status.TRAINER) {
            PersonMap.addCourseToPerson(trainerId, getCourse(courseId));
        }
    }

    public void addStudentOfCourse(int courseId, int studentId) {
        if (courseExists(courseId) && PersonMap.personExists(studentId)
                && PersonMap.getStatus(studentId) == Status.STUDENT) {
            Course course = getCourse(courseId);
            if (course.getJournal().size() < QUANTITY_OF_STUDENTS_ON_THE_COURSE) {
                course.addStudentOfCourse(getPerson(studentId));
                PersonMap.addCourseToPerson(studentId, course);
            } else {
                System.out.println("Course " + courseId + " cannot have more than 12 students");
            }
        }
    }

    private boolean isAStudentOnTheCourse(int courseId, int studentId) {
        if (courseExists(courseId) && PersonMap.getStatus(studentId) == Status.STUDENT) {
            return getCourse(courseId).isAStudentOnTheCourse(getPerson(studentId));
        } else {
            return false;
        }
    }

    public void removeStudentFromACourse(int courseId, int StudentId) {
        if (isAStudentOnTheCourse(courseId, StudentId)) {
            getCourse(courseId).removeStudent(getPerson(StudentId));
            PersonMap.removeCourseToPerson(StudentId, getCourse(courseId));
        }
    }

    public void transferOfTheStudent(int studentId, int courseFromId, int courseToId) {
        if ((courseExists(courseFromId) && (courseExists(courseToId))) && PersonMap.getStatus(studentId) == Status.STUDENT) {
            if (isAStudentOnTheCourse(courseFromId, studentId)) {
                this.removeStudentFromACourse(courseFromId, studentId);
                this.addStudentOfCourse(courseToId, studentId);
            }
        }
    }

    public void printFullInfoOfCourse(int ID) {
        if (courseExists(ID)) {
            System.out.println(getCourse(ID));
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
            File.writeFile(getCourse(ID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




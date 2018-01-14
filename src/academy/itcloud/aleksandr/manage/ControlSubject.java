package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;

import java.util.*;

public class ControlSubject {

    //    private static List<Subject> subjectList = new ArrayList<>();
    private static Map<Integer, Course> courseMap = new HashMap<>();

    public void createSubject(String courseName, String courseDescription, int ID_Trainer, String dateStart, String dateEnd) {
        boolean notRefuse = true;
        Subject subject;
        if (!courseMap.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = ControlPerson.getPerson(ID_Trainer);
            if (trainer.getStatus() == Status.STUDENT) {
                System.out.println("A student can not be a teacher.");
                subject = createSubject(courseName, courseDescription, dateStart, dateEnd);
            } else {
                subject = createSubject(courseName, courseDescription, trainer, dateStart, dateEnd);
            }
//            subjectList.add(course);
            courseMap.put(subject.getID(), new Course(subject));
        }
    }

    public void printCourseList() {
/*
        Iterator<Subject> itrCourseList = subjectList.iterator();
        while (itrCourseList.hasNext()) {
            System.out.println(itrCourseList.next().printInfoOfCourse());
        }
*/
        for (Map.Entry<Integer, Course> pair : courseMap.entrySet()) {
            System.out.println(pair.getValue().printInfoOfCourse());
        }
    }

    public void printInfoOfCourse(int ID){
        getCourse(ID).printInfoOfCourse();
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
        if (ControlPerson.personExists(ID)) {
            Person trainer = ControlPerson.getPerson(ID);
            if (isTrainer(trainer.getHumen())) {
                subject.setTrainer(trainer.getHumen());
            }
        }
    }

    public void changePeriod(int ID, String dateStart, String dateEnd) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID).getSubject();
            subject.setPeriod(dateStart, dateEnd);
        }
    }

    private Subject createSubject(String courseName, String coursDescription, Person trainer, String dateStart, String dateEnd) {
        Subject subject = new Subject.CourseBuilder(courseName).courseDescription(coursDescription).trainer(trainer.getHumen()).period(dateStart, dateEnd).builder();
        return subject;
    }

    // add a course without a trainer
    private Subject createSubject(String courseName, String coursDescription, String dateStart, String dateEnd) {
        Subject subject = new Subject.CourseBuilder(courseName).courseDescription(coursDescription).period(dateStart, dateEnd).builder();
        return subject;
    }


    private boolean isTrainer(Human human) {
        if (human.getStatus() == Status.STUDENT) {
            System.out.println("A student can not be a teacher.");
            return false;
        }
        return true;
    }

    public static boolean courseExists(int ID) {
        if (!courseMap.containsKey(ID)) {
            System.out.println("No course with this ID " + ID);
            return false;
        }
        return true;
    }

    private Course getCourse(int ID) {
//        return subjectList.get(ID - 1);
        return courseMap.get(ID);
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

    public void addTaskOfCourse(int ID, String... task){
        getCourse(ID).createTask(task);
    }

    public void addTaskOfCourse(int ID, String task){
        getCourse(ID).createTask(task);
    }

    public void addStudentOfCourse(int ID_Course, int ID_Student){
        getCourse(ID_Course).addStudent(ControlPerson.getPerson(ID_Student));
    }
}


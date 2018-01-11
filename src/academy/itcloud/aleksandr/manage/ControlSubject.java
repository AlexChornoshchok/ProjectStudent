package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;

import java.util.*;

public class ControlSubject {

    private static List<Subject> subjectList = new ArrayList<>();
    private static Map<Integer, Person> subjectMap = new HashMap<>();

    public void createCourse(String courseName, String courseDescription, int ID_Trainer, String dateStart, String dateEnd) {
        boolean notRefuse = true;
        Subject subject;
        if (!subjectList.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = ControlPerson.getPerson(ID_Trainer);
            if (trainer.getStatus() == Status.STUDENT) {
                System.out.println("A student can not be a teacher.");
                subject = addCourse(courseName, courseDescription, dateStart, dateEnd);
            } else {
                subject = addCourse(courseName, courseDescription, trainer, dateStart, dateEnd);
            }
            subjectList.add(subject);
        }
    }

    public void printCourseList() {
        Iterator<Subject> itrCourseList = subjectList.iterator();
        while (itrCourseList.hasNext()) {
            System.out.println(itrCourseList.next().printInfoCourse());
        }
    }

    public void printFullCourse(int ID) {
        if (courseExists(ID)) {
            System.out.println(getCourse(ID));
        }
    }

    public void changedaysOfTheWeeks(int ID, DaysOfTheWeek... daysOfTheWeeks) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID);
            subject.setDaysOfTheWeeks(daysOfTheWeeks);
        }
    }

    public void changeTrainer(Subject subject, int ID) {
        if (ControlPerson.personExists(ID)) {
            Person trainer = ControlPerson.getPerson(ID);
            if (isTrainer(trainer)) {
                subject.setTrainer(trainer);
            }
        }
    }

    public void changePeriod(int ID, String dateStart, String dateEnd) {
        if (courseExists(ID)) {
            Subject subject = getCourse(ID);
            subject.setPeriod(dateStart, dateEnd);
        }
    }

    private Subject addCourse(String courseName, String coursDescription, Person trainer, String dateStart, String dateEnd) {
        Subject subject = new Subject.CourseBuilder(courseName).courseDescription(coursDescription).trainer(trainer).period(dateStart, dateEnd).builder();
        return subject;
    }

    // add a course without a trainer
    private Subject addCourse(String courseName, String coursDescription, String dateStart, String dateEnd) {
        Subject subject = new Subject.CourseBuilder(courseName).courseDescription(coursDescription).period(dateStart, dateEnd).builder();
        return subject;
    }


    private boolean isTrainer(Person person) {
        if (person.getStatus() == Status.STUDENT) {
            System.out.println("A student can not be a teacher.");
            return false;
        }
        return true;
    }

    public static boolean courseExists(int ID) {
        if ((ID - 1) > subjectList.size()) {
            System.out.println("No course with this ID " + ID);
            return false;
        }
        return true;
    }

    private Subject getCourse(int ID) {
        return subjectList.get(ID - 1);
    }

    private boolean checkName(String courseName) {
        Iterator<Subject> itrCourseList = subjectList.iterator();
        while (itrCourseList.hasNext()) {
            if (courseName.equals(itrCourseList.next().getCourseName())) {
                System.out.println("Subject name should be unique");
                return false;
            }
        }
        return true;
    }
}


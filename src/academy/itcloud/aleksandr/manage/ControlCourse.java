package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;

import java.util.Iterator;

import static academy.itcloud.aleksandr.staticVariables.CourseList.courseList;

public class ControlCourse {

    public void createCourse(String courseName, String courseDescription, int ID_Trainer, String dateBegin, String dateEnd) {
        boolean notRefuse = true;
        Course course;
        if (!courseList.isEmpty()) {
            notRefuse = checkName(courseName);
        }
        if (notRefuse) {
            Person trainer = ControlPerson.getPerson(ID_Trainer);
            if (trainer.getStatus() == Status.STUDENT) {
                System.out.println("A student can not be a teacher.");
                course = addCourse(courseName, courseDescription, dateBegin, dateEnd);
            } else {
                course = addCourse(courseName, courseDescription, trainer, dateBegin, dateEnd);
            }
            courseList.add(course);
        }
    }

    public void printCourseList() {
        Iterator<Course> itrCourseList = courseList.iterator();
        while (itrCourseList.hasNext()) {
            System.out.println(itrCourseList.next().printInfoCourse());
        }
    }

    public void printFullCourse(int ID) {
        if (courseExists(ID)) {
            System.out.println(getCourse(ID));
        }
    }

    public void addStudentOfCourse(int ID_Course, int ID_Student) {
        if (ControlPerson.personExists(ID_Student)) {
            int[] studentList = getCourse(ID_Course).getStudentsList();
            if (studentList[11] == 0) {
                for (int i = 0; i < studentList.length; i++) {
                    if (studentList[i] == 0) {
                        studentList[i] = ID_Student;
                        break;
                    }
                }
            }
        }
    }


    public void removeStudentOfCourse(int ID_Course, int ID_Student) {
        if (courseExists(ID_Course)) {
            Course course = getCourse(ID_Course);
            int[] studentList = course.getStudentsList();
            for (int i = 0; i < studentList.length; i++) {
                if (studentList[i] == ID_Student) {
                }
            }

        }
    }


    public void changedaysOfTheWeeks(int ID, DaysOfTheWeek... daysOfTheWeeks) {
        if (courseExists(ID)) {
            Course course = getCourse(ID);
            course.setDaysOfTheWeeks(daysOfTheWeeks);
        }
    }

    public void changeTrainer(Course course, int ID) {
        if (ControlPerson.personExists(ID)) {
            Person trainer = ControlPerson.getPerson(ID);
            if (isTrainer(trainer)) {
                course.setTrainer(trainer);
            }
        }
    }

    public void changePeriod(Course course, String dateBegin, String dateEnd) {
        course.setPeriod(dateBegin, dateEnd);
    }

    // add a course with a trainer
    private Course addCourse(String courseName, String coursDescription, Person trainer, String dateBegin, String dateEnd) {
        Course course = new Course.CourseBuilder(courseName).courseDescription(coursDescription).trainer(trainer).period(dateBegin, dateEnd).builder();
        return course;
    }

    // add a course without a trainer
    private Course addCourse(String courseName, String coursDescription, String dateBegin, String dateEnd) {
        Course course = new Course.CourseBuilder(courseName).courseDescription(coursDescription).period(dateBegin, dateEnd).builder();
        return course;
    }


    private boolean isTrainer(Person person) {
        if (person.getStatus() == Status.STUDENT) {
            System.out.println("A student can not be a teacher.");
            return false;
        }
        return true;
    }

    public static boolean courseExists(int ID) {
        if ((ID - 1) > courseList.size()) {
            System.out.println("No course with this ID " + ID);
            return false;
        }
        return true;
    }

    private Course getCourse(int ID) {
        return courseList.get(ID - 1);
    }

    private boolean checkName(String courseName) {
        Iterator<Course> itrCourseList = courseList.iterator();
        while (itrCourseList.hasNext()) {
            if (courseName.equals(itrCourseList.next().getCourseName())) {
                System.out.println("Course name should be unique");
                return false;
            }
        }
        return true;
    }
}


package academy.itcloud.aleksandr.model;

import java.time.DayOfWeek;
import java.util.*;

public class Course {
    private static int counterID = 1;

    public static class CourseBuilder {
        private final String name;
        private String description;
        private Person trainer;
        private String dateStart;
        private String dateEnd;
        private DayOfWeek[] daysOfWeek;

        public CourseBuilder(String name) {
            this.name = name;
        }

        public CourseBuilder courseDescription(String courseDescription) {
            this.description = courseDescription;
            return this;
        }

        public CourseBuilder trainer(Person trainer) {
            this.trainer = trainer;
            return this;
        }

        public CourseBuilder period(String dateStart, String dateEnd) {
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
            return this;
        }

        public CourseBuilder daysOfWeek(DayOfWeek... daysOfWeek) {
            this.daysOfWeek = daysOfWeek;
            return this;
        }

        public Course builder() {
            Course course = new Course(this);
            return course;
        }
    }


    // ********************************
    private final String name;
    private final int ID;
    private String description;
    private Person trainer;
    private String dateStart;
    private String dateEnd;
    private DayOfWeek[] daysOfWeek = new DayOfWeek[5];
    private List<String> taskList = new ArrayList<>();
    private Map<Person, Map<String, Integer>> journal = new HashMap<>();

    public Course(CourseBuilder courseBuilder) {
        ID = counterID++;
        this.name = courseBuilder.name;
        this.description = courseBuilder.description;
        this.trainer = courseBuilder.trainer;
        this.dateStart = courseBuilder.dateStart;
        this.dateEnd = courseBuilder.dateEnd;
        this.daysOfWeek = courseBuilder.daysOfWeek;
    }

    public int getID() {
        return getID();
    }

    public String getName() {
        return name;
    }

    public Map<Person, Map<String, Integer>> getJournal() {
        return journal;
    }

    public void createTask(String nameTask) {
        taskList.add(nameTask);
    }

    public void createTask(String... nameTask) {
        for (String element : nameTask) {
            taskList.add(element);
        }
    }

    public void addStudentOfCourse(Person person) {
        HashMap<String, Integer> task = new HashMap<>();
        for (String kay : taskList) {
            task.put(kay, (int) (Math.random() * 10));
        }
        journal.put(person, task);
    }

    public boolean isAStudentOnTheCourse(Person person) {
        return journal.containsKey(person);
    }

    public void removeStudent(Person person) {
        journal.remove(person);
    }

    public void printJournal() {
        System.out.println("Journal of the course " + ID + ": " + name);
        for (Person person : journal.keySet()) {
            System.out.println(person.printPerson() + ": ");
            Map<String, Integer> taskStudent = journal.get(person);
            for (String kay : taskStudent.keySet()) {
                System.out.println(kay + " - " + taskStudent.get(kay));
            }
        }
    }

    public String printNameOfCourse() {
        return "Course " + ID + ": " + name;
    }

    public void printOfTheStudent() {
        System.out.println("Student list of the " + this.printNameOfCourse());
        for (Person person : journal.keySet()) {
            System.out.println(person.printPerson());
        }
    }

    public void setPeriod(String dateStart, String dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }


    @Override
    public String toString() {
        return "Course: ID " + ID + '\n'
                + "Course name: " + name + '\n'
                + "Course description: " + description + '\n'
                + "Trainer: " + trainer + '\n'
                + "Start day: " + dateStart + '\n'
                + "End day: " + dateEnd + '\n'
                + "Days of the weeks: " + Arrays.toString(daysOfWeek) + '\n'
                ;
    }
}

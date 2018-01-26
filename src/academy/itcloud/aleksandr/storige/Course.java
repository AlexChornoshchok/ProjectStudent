package academy.itcloud.aleksandr.storige;

import academy.itcloud.aleksandr.model.*;

import java.util.*;

public class Course {
    private Subject subject;
    private List<String> taskList = new ArrayList<>();
    private Map<Person, Map<String, Integer>> journal = new HashMap<>();


    public Course(Subject subject) {
        this.subject = subject;
    }

    public int getID() {
        return subject.getID();
    }

    public Subject getSubject() {
        return subject;
    }

    public String getCourseName(){
        return subject.getCourseName();
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

    public boolean isAStudentOnTheCourse(Person person){
        return journal.containsKey(person);
    }

    public void removeStudent(Person person){
        journal.remove(person);
    }

    public void printJournal() {
        System.out.println("Journal of the course " + subject.getID() + ": " + subject.getCourseName());
        for (Person person : journal.keySet()) {
            System.out.println(person.human.printPerson() + ": ");
            Map<String, Integer> taskStudent = journal.get(person);
            for (String kay : taskStudent.keySet()) {
                System.out.println(kay + " - " + taskStudent.get(kay));
            }
        }
    }

    public String printNameOfCourse() {
        return "Course " + subject.getID() + ": " + subject.getCourseName();
    }

    public void printInFullOfCourse() {
        System.out.print("Full uifo of the ");
        System.out.println(subject);
        printJournal();
    }

    public void printOfTheStudent(){
        System.out.println("Student list of the " + this.printNameOfCourse());
        for (Person person : journal.keySet()) {
            System.out.println(person.human.printPerson());
        }
    }


}

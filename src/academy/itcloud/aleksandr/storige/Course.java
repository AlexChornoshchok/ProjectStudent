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

    public String printInfoOfCourse() {
        return "" + subject.getID() + ": " + subject.getCourseName();
    }

    public void printInFullOfCourse() {
        System.out.println(subject);
        printJournal();
    }

    public void createTask(String nameTask) {
        taskList.add(nameTask);
    }

    public void createTask(String... nameTask) {
        for (String element : nameTask) {
            taskList.add(element);
        }
    }

    public void addStudent(Person person) {
        HashMap<String, Integer> task1 = new HashMap<>();
        for (String kay : taskList) {
            task1.put(kay, (int) (Math.random() * 10));
        }
        journal.put(person, task1);
    }

    private void printJournal() {
        System.out.println("Journal: course " + subject.getID());
        for (Person person : journal.keySet()) {
            System.out.println(person.printPerson() + ": ");
            Map<String, Integer> taskStudent = journal.get(person);
            for (String kay : taskStudent.keySet()) {
                System.out.println(kay + " - " + taskStudent.get(kay));
            }
        }
    }

/*
    public void putAnEstimate(Person person, String taskName, int score) {
        journal.get(person).replace(taskName, score);
    }
*/
}

package academy.itcloud.aleksandr.cli;

import academy.itcloud.aleksandr.model.*;

import java.util.*;

public class PersonMap {

    private static Map<Integer, Person> personMap = new HashMap<>();

    public static void addStudent(String firstName, String lastName, int age) {
        if (!nameExists(firstName + " " + lastName)) {
            addPerson(firstName, lastName, age, Status.STUDENT);
        }
    }

    public static void addTrainer(String firstName, String lastName, int age) {
        if (!nameExists(firstName + " " + lastName)) {
            addPerson(firstName, lastName, age, Status.TRAINER);
        }
    }

    private static void addPerson(String firstName, String lastName, int age, Status status) {
        Person person = new Person.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(status).build();
        personMap.put(person.getID(), person);
    }

    public static boolean personExists(int ID) {
        if (personMap.get(ID) == null) {
            System.out.println("No person with this ID " + ID);
            return false;
        }
        return true;
    }

    public static Status getStatus(int ID) {
        return personMap.get(ID).getStatus();
    }

    public static Person getPerson(int ID) {
        return personMap.get(ID);
    }

//    public static void printAllStudent() {
//        printPerson(Status.STUDENT);
//    }

//    public static void printAllTrainer() {
//        printPerson(Status.TRAINER);
//    }

    public static void printPerson(Status status) {
        System.out.println(status == Status.STUDENT ? "List all student." : "List all trainer.");
        for (Map.Entry<Integer, Person> pair : personMap.entrySet()) {
            if (pair.getValue().getStatus() == status) {
                System.out.println(pair.getValue().printPerson());
            }
        }
    }

    public static void printInfoPerson(int ID) {
        if (personExists(ID)) {
            personMap.get(ID).printInfoOfThePerson();
        }
    }

    public static void addCourseToPerson(int ID_Person, Course course) {
        if (personExists(ID_Person)) {
            getPerson(ID_Person).addCourse(course);
        }
    }

    public static void removeCourseToPerson(int ID_Person, Course course) {
        if (personExists(ID_Person)) {
            getPerson(ID_Person).removeCourse(course);
        }
    }

    private static boolean nameExists(String studentName) {
        if (!personMap.isEmpty()) {
            for (Person person : personMap.values()) {
                if (studentName.equals(person.getName())) {
                    System.out.println("Student name should be unique");
                    return true;
                }
            }
        }
        return false;
    }
}

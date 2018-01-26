package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;

import java.util.*;

public class ControlPerson {

    private static Map<Integer, Person> personMap = new HashMap<>();

    public static void addStugent(String firstName, String lastName, int age) {
        if (!nameExists(firstName + " " + lastName)) {
            Human student = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).build();
            personMap.put(student.getID(), new Person(student, Status.STUDENT));
        }
    }

    public static void addTrener(String firstName, String lastName, int age) {
        if (!nameExists(firstName + " " + lastName)) {
            Human trainer = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).build();
            personMap.put(trainer.getID(), new Person(trainer, Status.TRAINER));
        }
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

    public static void printAllStudent() {
        printPerson( 'S');
    }

    public static void printAllTrainer() {
        printPerson('T');
    }

    private static void printPerson( char c) {
        System.out.println(c == 'S' ? "List all student." : "List all trainer.");
        for (Map.Entry<Integer, Person> pair : personMap.entrySet()) {
            if (c == 'S' & pair.getValue().getStatus() == Status.STUDENT) {
                System.out.println(pair.getValue().human.printPerson());
            }
            if (c == 'T' & pair.getValue().getStatus() == Status.TRAINER) {
                System.out.println(pair.getValue().human.printPerson());
            }
        }
    }

    public static void printInfoTrainer(int ID) {
        if (personExists(ID) && getStatus(ID) == Status.TRAINER) {
            personMap.get(ID).printInfoOfThePerson();
        }
    }

    public static void printInfoPerson(int ID) {
            personMap.get(ID).printInfoOfThePerson();
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
                if (studentName.equals(person.human.getName())) {
                    System.out.println("Student name should be unique");
                    return true;
                }
            }
        }
        return false;
    }
}

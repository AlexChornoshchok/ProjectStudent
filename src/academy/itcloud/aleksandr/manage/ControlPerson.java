package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;

import java.util.*;

public class ControlPerson {

    private static Map<Integer, Person> personMap = new HashMap<>();

    public static void addStugent(String firstName, String lastName, int age) {
        Human student = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.STUDENT).build();
        personMap.put(student.getID(), new Person(student));
    }

    public static void addTrener(String firstName, String lastName, int age) {
        Human trainer = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.TRAINER).build();
        personMap.put(trainer.getID(), new Person(trainer));
    }

    public static boolean personExists(int ID) {
        if (personMap.get(ID) == null) {
            System.out.println("No person with this ID " + ID);
            return false;
        }
        return true;
    }

    public static boolean isStudent (int ID){
        if (personMap.get(ID) == null) {
            System.out.println("No person with this ID " + ID);
            return false;
        }
        if (personMap.get(ID).human.getStatus() != Status.STUDENT){
            return false;
        }
        return true;
    }

    public static Person getPerson(int ID) {
        return personMap.get(ID);
    }

    public static void printAllStudent() {
        printPerson(personMap, 'S');
    }

    public static void printAllTrainer() {
        printPerson(personMap, 'T');
    }

    private static void printPerson(Map<Integer, Person> personMap, char c) {
        System.out.println(c == 'S' ? "List all student." : "List all trainer.");
        for (Map.Entry<Integer, Person> pair : personMap.entrySet()) {
            if (c == 'S' & pair.getValue().human.getStatus() == Status.STUDENT) {
                System.out.println(pair.getValue().human.printPerson());
            }
            if (c == 'T' & pair.getValue().human.getStatus() == Status.TRAINER) {
                System.out.println(pair.getValue().human.printPerson());
            }
            System.out.println(pair.getValue().human.printPerson());
        }
    }

    public static void printInfoTrainer(int ID){
        System.out.println(personMap.get(ID).human);
    }

    public static void printInfoStudent(int ID){
        System.out.println(personMap.get(ID).human);
    }

}

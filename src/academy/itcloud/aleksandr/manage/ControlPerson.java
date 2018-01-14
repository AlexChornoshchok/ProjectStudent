package academy.itcloud.aleksandr.manage;

import academy.itcloud.aleksandr.model.*;
import academy.itcloud.aleksandr.storige.*;


import java.util.*;

public class ControlPerson {

    private static List<Person> humanList = new ArrayList<>();
    private static Map<Integer, Person> personMap = new HashMap<>();

    public static void addStugent(String firstName, String lastName, int age) {
        Human student = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.STUDENT).build();
        humanList.add(new Person(student));
        personMap.put(student.getID(), new Person(student));
    }

    public static void addTrener(String firstName, String lastName, int age) {
        Human trainer = new Human.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.TRAINER).build();
        humanList.add(new Person(trainer));
        personMap.put(trainer.getID(), new Person(trainer));
    }

    public static boolean personExists(int ID) {
//        if ((ID - 1) > humanList.size()) {
        if (personMap.get(ID) == null) {
            System.out.println("No person with this ID " + ID);
            return false;
        }
        return true;
    }

    public static Person getPerson(int ID) {
        return personMap.get(ID);
//       return humanList.get(ID - 1);
    }

    public static void printStudent() {
        printMap(personMap, 'S');
//        printList('S');
    }

    public static void printTrainer() {
        printMap(personMap, 'T');
//        printList('T');
    }

    private static void printMap(Map<Integer, Person> personMap, char c) {
        System.out.println(c == 'S' ? "List all student." : "List all trainer.");
        for (Map.Entry<Integer, Person> pair : personMap.entrySet()) {
            if (c == 'S' & pair.getValue().getStatus() == Status.STUDENT) {
                System.out.println(pair.getValue().printPerson());
            }
            if (c == 'T' & pair.getValue().getStatus() == Status.TRAINER) {
                System.out.println(pair.getValue().printPerson());
            }
        }
    }

    public static void printList(char c) {
        System.out.println(c == 'S' ? "List all student." : "List all trainer.");
        Person element;
        Iterator<Person> itrPersonList = humanList.iterator();
        while (itrPersonList.hasNext()) {
            element = itrPersonList.next();
            if (c == 'S' & element.getStatus() == Status.STUDENT) {
                System.out.print(element.printPerson());
            }
            if (c == 'T' & element.getStatus() == Status.TRAINER) {
                System.out.print(element.printPerson());
            }
        }
    }

}

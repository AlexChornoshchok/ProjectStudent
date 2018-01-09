package academy.itcloud.aleksandr.manage;

import static academy.itcloud.aleksandr.staticVariables.PersonList.personList;
import academy.itcloud.aleksandr.model.*;

import java.util.Iterator;

public class ControlPerson {

    public static void addStugent(String firstName, String lastName, int age){
        Person student = new Person.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.STUDENT).build();
        personList.add(student);
    }

    public static void addTrener(String firstName, String lastName, int age){
        Person trainer = new Person.PersonBuilder(firstName.trim(), lastName.trim()).age(age).status(Status.TRAINER).build();
        personList.add(trainer);
    }

    public static boolean personExists(int ID) {
        if ((ID - 1) > personList.size()) {
            System.out.println("No person with this ID " + ID);
            return false;
        }
        return true;
    }

    public static boolean personExists(Person person) {
        if (0 > personList.indexOf(person)) {
            System.out.println("No person " + person);
            return false;
        }
        return true;
    }

    public static Person getPerson (int ID){
        return personList.get(ID - 1);
    }

    public static void printStudentList(){
        System.out.println("List all trainer.");
        Person element;
        Iterator<Person> itrPersonList = personList.iterator();
        while (itrPersonList.hasNext()){
            element = itrPersonList.next();
            if(element.getStatus() == Status.TRAINER) continue;
            System.out.print(element.printPerson());
        }
    }

    public static void printTrainerList(){
        System.out.println("List all student.");
        Person element;
        Iterator<Person> itrPersonList = personList.iterator();
        while (itrPersonList.hasNext()){
            element = itrPersonList.next();
            if(element.getStatus() == Status.STUDENT) continue;
            System.out.print(element.printPerson());
        }
    }
}

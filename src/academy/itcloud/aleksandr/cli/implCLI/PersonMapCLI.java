package academy.itcloud.aleksandr.cli.implCLI;

import academy.itcloud.aleksandr.cli.interfaceCLI.PersonCLI;
import academy.itcloud.aleksandr.map.PersonMap;
import academy.itcloud.aleksandr.model.Status;

import static java.lang.Integer.valueOf;

public class PersonMapCLI implements PersonCLI {
    @Override
    public void addStudent(String firstName, String lastName, int age) {
        PersonMap.addStudent(firstName, lastName, valueOf(age));
    }

    @Override
    public void addTrainer(String firstName, String lastName, int age) {
        PersonMap.addTrainer(firstName, lastName, valueOf(age));
    }

    @Override
    public void printPerson(Status status) {
        PersonMap.printPerson(status);
    }

    @Override
    public void printInfoPerson(int ID) {
        PersonMap.printInfoPerson(ID);
    }
}

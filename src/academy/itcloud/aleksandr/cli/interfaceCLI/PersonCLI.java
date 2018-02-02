package academy.itcloud.aleksandr.cli.interfaceCLI;

import academy.itcloud.aleksandr.map.PersonMap;
import academy.itcloud.aleksandr.model.Status;

public interface PersonCLI {
    void addStudent(String firstName, String lastName, int age);
    void addTrainer(String firstName, String lastName, int age);
    void printPerson(Status status);
    void printInfoPerson(int ID);
}

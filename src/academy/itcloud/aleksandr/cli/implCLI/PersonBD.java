package academy.itcloud.aleksandr.cli.implCLI;

import academy.itcloud.aleksandr.cli.interfaceCLI.PersonCLI;
import academy.itcloud.aleksandr.jdbc.dao.StudentDAO;
import academy.itcloud.aleksandr.jdbc.dao.TrainerDAO;
import academy.itcloud.aleksandr.jdbc.dao.h2.StudentH2;
import academy.itcloud.aleksandr.jdbc.dao.h2.TrainerH2;
import academy.itcloud.aleksandr.model.Status;


public class PersonBD implements PersonCLI{
    StudentDAO student = new StudentH2();
    TrainerDAO trainer = new TrainerH2();

    @Override
    public void addStudent(String firstName, String lastName, int age) {

    }

    @Override
    public void addTrainer(String firstName, String lastName, int age) {

    }

    @Override
    public void printPerson(Status status) {

    }

    @Override
    public void printInfoPerson(int ID) {

    }
}

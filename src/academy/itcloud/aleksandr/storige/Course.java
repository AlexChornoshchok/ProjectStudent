package academy.itcloud.aleksandr.storige;

import academy.itcloud.aleksandr.model.*;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private Subject subject;
    private Journal journal;
    private List<Person>  listStudent = new ArrayList<>();


    public Course(Subject subject) {
        this.subject = subject;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }
}

package academy.itcloud.aleksandr.cli;

import academy.itcloud.aleksandr.model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class File {
    public static final String NAME_FILE = "d:\\ITCloud\\AlexChernochshok\\journal.txt";

    public static void writeFile(Course course) throws IOException {

        FileWriter fw = new FileWriter(NAME_FILE, true);
        fw.write("Journal of the course " + course.getID() + ": " + course.getName() + " ");
        fw.append('\n');
        for (Person person : course.getJournal().keySet()) {
            fw.write(person.printPerson() + ": ");
            Map<String, Integer> taskStudent = course.getJournal().get(person);
            for (String kay : taskStudent.keySet()) {
                fw.write(kay + " - " + taskStudent.get(kay) + " ");
            }
        }
        fw.flush();
        fw.close();
    }

    public static void readFile() {

    }
}

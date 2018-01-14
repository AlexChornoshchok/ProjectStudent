package academy.itcloud.aleksandr.storige;

import academy.itcloud.aleksandr.model.*;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private Human human;
    private Map<Integer, Course>  courseList = new HashMap<>();

    public Person(Human human) {
        this.human = human;
    }

    public void addCourse(Course course){
        courseList.put(course.getID(), course);
    }

    public Status getStatus(){
        return human.getStatus();
    }

    public String printPerson(){
        return human.printPerson();
    }

    public Human getHumen(){
        return this.human;
    }
}

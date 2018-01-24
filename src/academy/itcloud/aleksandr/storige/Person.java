package academy.itcloud.aleksandr.storige;

import academy.itcloud.aleksandr.model.*;

import java.util.HashMap;
import java.util.Map;

public class Person {
    public Human human;
    private Map<Integer, Course>  courseList = new HashMap<>();

    public Person(Human human) {
        this.human = human;
    }

    public void addCourse(Course course){
        courseList.put(course.getID(), course);
    }

}

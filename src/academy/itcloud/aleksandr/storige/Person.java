package academy.itcloud.aleksandr.storige;

import academy.itcloud.aleksandr.model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    public Human human;
    private Status status;
    private Map<Integer, Course> courseList = new HashMap<>();


    public Person(Human human) {
        this.human = human;
    }

    public Person(Human human, Status status) {
        this.human = human;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void addCourse(Course course){
        courseList.put(course.getID(), course);
    }

    public void removeCourse(Course course){
        courseList.remove(course.getID());
    }

    public void printInfoOfThePerson(){
        System.out.println(human.printPerson());
        if (!courseList.isEmpty()) {
//            System.out.println("Courses on which the student is studying.");
            for (int id : courseList.keySet()) {
                System.out.println(courseList.get(id).printNameOfCourse());
            }
        }
    }

}

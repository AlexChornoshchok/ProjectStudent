package academy.itcloud.aleksandr.model;

import java.util.HashMap;
import java.util.Map;

public class Person {

    private static int counterID =1;

    public static class PersonBuilder{
        private final String firstName;
        private final String lastName;
        private int age;
        private Status status;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder status(Status status){
            this.status = status;
            return this;
        }

        public Person build(){
            Person person = new Person(this);
            return person;
        }
    }

/// **************************************************
    private final String firstName;
    private final String lastName;
    private int age;
    private final int ID;
    private Status status;
    private Map<Integer, Course> courseList = new HashMap<>();


    public Person(PersonBuilder builder) {
        ID = counterID++;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.status = builder.status;
    }


    public Status getStatus() {
        return status;
    }

    public void addCourse(Course course){
        courseList.put(course.getID(), course);
    }

    public void removeCourse(Course course){
        courseList.remove(course.getID());
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String printPerson(){
        return " ID: " + ID + " " + firstName + " " + lastName + " Age: " + age;
    }

    public int getID(){
        return ID;
    }

    public void printInfoOfThePerson(){
        System.out.println(status + getName());
        if (!courseList.isEmpty()) {
            for (int id : courseList.keySet()) {
                System.out.println(courseList.get(id).printNameOfCourse());
            }
        }
    }

}

package academy.itcloud.aleksandr.model;

public class Person {

    private static int NUMBE=1;

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

/// **********************************************************
    private final String firstName;
    private final String lastName;
    private int age;
    private Status status;
    private int ID;

    private Person(PersonBuilder builder) {
        ID = NUMBE++;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.status = builder.status;
        this.age = builder.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public Status getStatus() {
        return status;
    }

    public String printPerson(){
        return "" + status + " ID: " + ID + " " + firstName + " " + lastName + " Age: " + age;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "" + status + " ID: " + ID + "\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Age: " + age + "\n";
    }
}

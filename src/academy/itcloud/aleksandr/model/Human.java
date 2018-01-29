package academy.itcloud.aleksandr.model;

public class Human {

    private static int NUMBE=1;

    public static class PersonBuilder{
        private final String firstName;
        private final String lastName;
        private int age;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Human build(){
            Human human = new Human(this);
            return human;
        }
    }

/// **********************************************************
    private final String firstName;
    private final String lastName;
    private int age;
//    private Status status;
    private int ID;

    private Human(PersonBuilder builder) {
        ID = NUMBE++;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
//        this.status = builder.status;
        this.age = builder.age;
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

    @Override
    public String toString() {
        return  " ID: " + ID + "\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Age: " + age + "\n";
    }
}

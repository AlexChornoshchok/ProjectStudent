package academy.itcloud.aleksandr.model;

import java.util.Arrays;

import static academy.itcloud.aleksandr.staticVariables.PersonList.personList;

public class Course {

    private static int Number = 1;

    public static class CourseBuilder {
        private final String courseName;
        private String courseDescription;
        private Person trainer;
        private String dateBegin;
        private String dateEnd;
//        private int[] studentsList = new int[12];
        private DaysOfTheWeek[] daysOfTheWeeks;
        private Journal journal;

        public CourseBuilder(String courseName) {
            this.courseName = courseName;
        }

        public CourseBuilder courseDescription(String coursDescription){
            this.courseDescription = coursDescription;
            return this;
        }

        public CourseBuilder trainer (Person trainer){
            this.trainer = trainer;
            return this;
        }

        public CourseBuilder period (String dateBegin, String dateEnd){
            this.dateBegin = dateBegin;
            this.dateEnd = dateEnd;
            return this;
        }


        public CourseBuilder daysOfTheWeeks (DaysOfTheWeek[] daysOfTheWeeks){
            this.daysOfTheWeeks = daysOfTheWeeks;
            return this;
        }

        public Course builder (){
            Course course = new Course(this);
            return course;
        }
    }

    private final String courseName;
    private int ID;
    private String courseDescription;
    private Person trainer;
    private String dateBegin;
    private String dateEnd;
    private int[] studentsList = new int[12];
    private DaysOfTheWeek[] daysOfTheWeeks =new  DaysOfTheWeek[5];
    private Journal journal;

    public Course(CourseBuilder courseBuilder) {
        ID = Number++;
        this.courseName = courseBuilder.courseName;
        this.courseDescription = courseBuilder.courseDescription;
        this.trainer = courseBuilder.trainer;
        this.daysOfTheWeeks = courseBuilder.daysOfTheWeeks;
    }

    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

    public void setPeriod(String dateBegin, String dateEnd){
        this.dateBegin = dateBegin;
        this.dateEnd = dateEnd;
    }

    public void setDaysOfTheWeeks(DaysOfTheWeek... daysOfTheWeeks) {
        this.daysOfTheWeeks = daysOfTheWeeks;
    }

    public int[] getStudentsList(){
        return this.studentsList;
    }

    private String getTrainer(){
        return this.trainer == null ? " no trainer": this.trainer.getName();
    }

    public int getID() {
        return ID;
    }

    public String getCourseName() {
        return courseName;
    }

    private String printSdudentList(){
        String result = "Student list:\n";
        if(this.studentsList[0] == 0){
            result+=" no student.";
        }else{
            for (int i = 0; i < this.studentsList.length; i++) {
                if(this.studentsList[i] == 0)break;
                Person person = personList.get(studentsList[i] - 1);
                result += person.printPerson();
            }
        }
        return result;
    }

    public String printInfoCourse(){
        return "" + ID + ": " + this.courseName;
    }

    @Override
    public String toString() {
        return "Course: ID " + ID + '\n'
                + "Course name: " + courseName + '\n'
                + "Cours description: " + courseDescription + '\n'
                + "Trainer: " +getTrainer() + '\n'
                + "Days of the weeks: " + Arrays.toString(daysOfTheWeeks)+ '\n'
                + printSdudentList() + '\n'
                ;
    }
}

package academy.itcloud.aleksandr.model;

import java.util.Arrays;

public class Subject {

    private static int number = 1;

    public static class CourseBuilder {
        private final String courseName;
        private String courseDescription;
        private Human trainer;
        private String dateStart;
        private String dateEnd;
        private DaysOfTheWeek[] daysOfTheWeeks;

        public CourseBuilder(String courseName) {
            this.courseName = courseName;
        }

        public CourseBuilder courseDescription(String coursDescription) {
            this.courseDescription = coursDescription;
            return this;
        }

        public CourseBuilder trainer(Human trainer) {
            this.trainer = trainer;
            return this;
        }

        public CourseBuilder period(String dateStart, String dateEnd) {
            this.dateStart = dateStart;
            this.dateEnd = dateEnd;
            return this;
        }

        public CourseBuilder daysOfTheWeeks(DaysOfTheWeek[] daysOfTheWeeks) {
            this.daysOfTheWeeks = daysOfTheWeeks;
            return this;
        }

        public Subject builder() {
            Subject subject = new Subject(this);
            return subject;
        }
    }

    private final String courseName;
    private int ID;
    private String courseDescription;
    private Human trainer;
    private String dateStart;
    private String dateEnd;
    private DaysOfTheWeek[] daysOfTheWeeks = new DaysOfTheWeek[5];

    public Subject(CourseBuilder courseBuilder) {
        ID = number++;
        this.courseName = courseBuilder.courseName;
        this.courseDescription = courseBuilder.courseDescription;
        this.trainer = courseBuilder.trainer;
        this.dateStart = courseBuilder.dateStart;
        this.dateEnd = courseBuilder.dateEnd;
        this.daysOfTheWeeks = courseBuilder.daysOfTheWeeks;
    }

    public void setTrainer(Human trainer) {
        this.trainer = trainer;
    }

    public void setPeriod(String dateStart, String dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public void setDaysOfTheWeeks(DaysOfTheWeek... daysOfTheWeeks) {
        this.daysOfTheWeeks = daysOfTheWeeks;
    }

    private String getTrainer() {
        return this.trainer == null ? " no trainer" : this.trainer.getName();
    }

    public int getID() {
        return ID;
    }

    public String getCourseName() {
        return courseName;
    }

    public String printInfoCourse() {
        return "" + ID + ": " + this.courseName;
    }

    @Override
    public String toString() {
        return "Course: ID " + ID + '\n'
                + "Course name: " + courseName + '\n'
                + "Course description: " + courseDescription + '\n'
                + "Trainer: " + getTrainer() + '\n'
                + "Start day: " + dateStart + '\n'
                + "End day: " + dateEnd + '\n'
                + "Days of the weeks: " + Arrays.toString(daysOfTheWeeks) + '\n'
                ;
    }
}

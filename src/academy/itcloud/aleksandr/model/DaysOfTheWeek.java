package academy.itcloud.aleksandr.model;

public enum DaysOfTheWeek {
    MONDAY("MON"), TUESDAY("TUE"), WEDNESDAY("WED"), THURSDAY("THU"), FRIDAY("FRI"), SATURDAY("SAY"), SUNDAY("SUN");

    private String name;

    DaysOfTheWeek(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

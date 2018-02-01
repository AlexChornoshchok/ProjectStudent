package academy.itcloud.aleksandr.model;

public enum Status {
    STUDENT("Student"), TRAINER("Trainer");

    private String name;

    Status(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

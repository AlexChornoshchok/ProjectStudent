package academy.itcloud.aleksandr.jdbc.dao;

public interface CourseDAO {
    void selectAllCourse();
    void selectOneCourse(int ID);
    void selectStudentsOnCourse(int ID);
    boolean addCourse(String name, String description, String data_start, String data_end, String daysOfWeek, int ID);
    boolean update(int ID);
    boolean remove(int ID);

}

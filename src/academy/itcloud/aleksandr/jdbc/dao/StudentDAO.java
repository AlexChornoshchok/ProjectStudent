package academy.itcloud.aleksandr.jdbc.dao;

public interface StudentDAO {

    void selectAllStudent();
    void selectStudentHisCourse(int ID);
    void selectOneStudent(int ID);
    boolean addStudent(String firstName, String lastName, int age);
    boolean update(int ID);
    boolean remove(int ID);
}

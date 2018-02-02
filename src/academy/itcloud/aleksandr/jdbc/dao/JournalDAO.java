package academy.itcloud.aleksandr.jdbc.dao;

public interface JournalDAO {
    void selectJournalOfTheCourse(int ID);
    boolean addJournal(int coursId, int studentId, int taskId);
    boolean update(int ID);
    boolean remove(int ID);
}

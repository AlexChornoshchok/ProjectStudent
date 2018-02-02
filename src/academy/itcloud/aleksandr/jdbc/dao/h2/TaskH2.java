package academy.itcloud.aleksandr.jdbc.dao.h2;

import academy.itcloud.aleksandr.jdbc.GetConnection;
import academy.itcloud.aleksandr.jdbc.dao.*;


public class TaskH2 extends GetConnection implements TaskDAO{
    @Override
    public void addTaskOfCourse() {
        throw new UnsupportedOperationException();
    }
}

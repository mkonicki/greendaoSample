package konicki.mateusz.greendaosample.entites;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by Mateusz on 13.02.2017.
 */
@Entity
public class Task {
    @Id(autoincrement = true)
    private Long id;

    private Long toDoId;

    @ToOne(joinProperty = "toDoId")
    private ToDo toDo;

    private String taskDescription;
}

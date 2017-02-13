package konicki.mateusz.greendaosample.entites;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.util.Calendar;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by Mateusz on 13.02.2017.
 */
@Entity
public class ToDoUser {
    @Id(autoincrement = true)
    private Long id;

    private Date assignmentDate;

    private Long userId;

    private Long toDoId;

    private boolean isDone;


    @Generated(hash = 908319097)
    public ToDoUser(Long id, Date assignmentDate, Long userId, Long toDoId,
            boolean isDone) {
        this.id = id;
        this.assignmentDate = assignmentDate;
        this.userId = userId;
        this.toDoId = toDoId;
        this.isDone = isDone;
    }

    @Keep
    public ToDoUser() {
        assignmentDate = Calendar.getInstance().getTime();
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAssignmentDate() {
        return this.assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate) {
        this.assignmentDate = assignmentDate;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getToDoId() {
        return this.toDoId;
    }

    public void setToDoId(Long toDoId) {
        this.toDoId = toDoId;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }


}

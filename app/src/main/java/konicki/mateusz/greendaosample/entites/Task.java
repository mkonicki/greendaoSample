package konicki.mateusz.greendaosample.entites;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

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

    private int timeRequiredToPerform;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1469429066)
    private transient TaskDao myDao;

    @Generated(hash = 2091761366)
    public Task(Long id, Long toDoId, String taskDescription,
            int timeRequiredToPerform) {
        this.id = id;
        this.toDoId = toDoId;
        this.taskDescription = taskDescription;
        this.timeRequiredToPerform = timeRequiredToPerform;
    }

    @Generated(hash = 733837707)
    public Task() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getToDoId() {
        return this.toDoId;
    }

    public void setToDoId(Long toDoId) {
        this.toDoId = toDoId;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTimeRequiredToPerform() {
        return this.timeRequiredToPerform;
    }

    public void setTimeRequiredToPerform(int timeRequiredToPerform) {
        this.timeRequiredToPerform = timeRequiredToPerform;
    }

    @Generated(hash = 260954488)
    private transient Long toDo__resolvedKey;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1875790115)
    public ToDo getToDo() {
        Long __key = this.toDoId;
        if (toDo__resolvedKey == null || !toDo__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ToDoDao targetDao = daoSession.getToDoDao();
            ToDo toDoNew = targetDao.load(__key);
            synchronized (this) {
                toDo = toDoNew;
                toDo__resolvedKey = __key;
            }
        }
        return toDo;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 671486003)
    public void setToDo(ToDo toDo) {
        synchronized (this) {
            this.toDo = toDo;
            toDoId = toDo == null ? null : toDo.getId();
            toDo__resolvedKey = toDoId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1442741304)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getTaskDao() : null;
    }

   
}

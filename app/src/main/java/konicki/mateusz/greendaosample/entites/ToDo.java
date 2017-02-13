package konicki.mateusz.greendaosample.entites;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Unique;


/**
 * Created by Mateusz on 11.02.2017.
 */

@Entity
public class ToDo {
    @Id(autoincrement = true)
    private Long id;

    @Unique
    private String toDo;

    @Convert(converter = ToDoTypePropertyConverter.class, columnType = Integer.class)
    private ToDoType type;

    @ToMany
    @JoinEntity(
            entity = ToDoUser.class,
            sourceProperty = "toDoId",
            targetProperty = "userId"
    )
    private List<User> assignedToDo;

    @ToMany(referencedJoinProperty = "toDoId")
    private List<Task> toDos;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 301018984)
    private transient ToDoDao myDao;

    @Generated(hash = 588869791)
    public ToDo(Long id, String toDo, ToDoType type) {
        this.id = id;
        this.toDo = toDo;
        this.type = type;
    }

    public ToDo(String toDo, ToDoType type) {
        this.toDo = toDo;
        this.type = type;
    }

    @Generated(hash = 1151496819)
    public ToDo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToDo() {
        return this.toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public ToDoType getType() {
        return this.type;
    }

    public void setType(ToDoType type) {
        this.type = type;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1654368227)
    public List<User> getAssignedToDo() {
        if (assignedToDo == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            List<User> assignedToDoNew = targetDao._queryToDo_AssignedToDo(id);
            synchronized (this) {
                if (assignedToDo == null) {
                    assignedToDo = assignedToDoNew;
                }
            }
        }
        return assignedToDo;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1065232738)
    public synchronized void resetAssignedToDo() {
        assignedToDo = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1409608842)
    public List<Task> getToDos() {
        if (toDos == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TaskDao targetDao = daoSession.getTaskDao();
            List<Task> toDosNew = targetDao._queryToDo_ToDos(id);
            synchronized (this) {
                if (toDos == null) {
                    toDos = toDosNew;
                }
            }
        }
        return toDos;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1033056323)
    public synchronized void resetToDos() {
        toDos = null;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDo toDo1 = (ToDo) o;

        if (toDo != null ? !toDo.equals(toDo1.toDo) : toDo1.toDo != null) return false;
        return type == toDo1.type;

    }

    @Override
    public int hashCode() {
        int result = toDo != null ? toDo.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1882739160)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getToDoDao() : null;
    }
}

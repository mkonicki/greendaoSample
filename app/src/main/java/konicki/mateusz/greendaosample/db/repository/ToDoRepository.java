package konicki.mateusz.greendaosample.db.repository;

import android.content.Context;

import java.util.List;

import konicki.mateusz.greendaosample.entites.ToDo;
import konicki.mateusz.greendaosample.entites.ToDoDao;
import konicki.mateusz.greendaosample.entites.ToDoType;

/**
 * Created by Mateusz on 13.02.2017.
 */

public class ToDoRepository extends BaseRepository<ToDo, ToDoDao> {

    public ToDoRepository(Context context) {
        super(context);
    }

    @Override
    protected ToDoDao getDao() {
        return idbHelper.getSession().getToDoDao();
    }

    /**
     * Get all To Do with specified Type
     * @param type ToDo type
     * @return entities with specified type
     */
    public List<ToDo> getToDoWithType(ToDoType type){
        return getDao().queryBuilder()
                .where(ToDoDao.Properties.Type.eq(type.getId()))
                .list();
    }
}

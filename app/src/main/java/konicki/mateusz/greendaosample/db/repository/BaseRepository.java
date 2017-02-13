package konicki.mateusz.greendaosample.db.repository;

import android.content.Context;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

import konicki.mateusz.greendaosample.db.dbhelper.DBHelper;
import konicki.mateusz.greendaosample.db.dbhelper.IDBHelper;

/**
 * Created by Mateusz on 13.02.2017.
 */

public abstract class BaseRepository<Entity, DAO extends AbstractDao<Entity, Long>> implements IBaseRepository<Entity, DAO> {

    protected IDBHelper idbHelper;

    private BaseRepository(IDBHelper idbHelper) {
        this.idbHelper = idbHelper;
    }

    public BaseRepository(Context context) {
        this(new DBHelper(context));
    }

    protected abstract DAO getDao();

    /**
     * Insert new entity
     *
     * @param entity new Entity which should be inserted in database
     * @return inserted entity id
     */
    @Override
    public Long create(Entity entity) {
        return getDao().insert(entity);
    }

    /**
     * Insert list of entities
     *
     * @param entity entities to insert
     */
    @Override
    public void create(List<Entity> entity) {
        getDao().insertInTx(entity);
    }

    /**
     * Insert new entity
     *
     * @param entity new Entity, or existed entity which should be inserted in database
     * @return inserted entity id
     */
    @Override
    public Long createOrUpdate(Entity entity) {
        return getDao().insertOrReplace(entity);
    }

    /**
     * Read all entities
     *
     * @return entities
     */
    @Override
    public List<Entity> read() {
        return getDao().loadAll();
    }

    /**
     * Read entity by id
     *
     * @param id entity id
     * @return entity
     */
    @Override
    public Entity readById(Long id) {
        return getDao().load(id);
    }

    /**
     * Insert new entity
     *
     * @param entity new Entity which should be inserted in database
     * @return inserted entity id
     */
    @Override
    public void update(Entity entity) {
        getDao().update(entity);
    }

    /**
     * Delete current entity
     *
     * @param entity
     */
    @Override
    public void delete(Entity entity) {
        getDao().delete(entity);
    }

    /**
     * Delete current entity by id
     *
     * @param id entity id
     */
    @Override
    public void deleteById(Long id) {
        getDao().deleteByKey(id);
    }

}

package konicki.mateusz.greendaosample.db.repository;

import org.greenrobot.greendao.AbstractDao;

import java.util.List;

/**
 * Created by Mateusz on 13.02.2017.
 */
public interface IBaseRepository<Entity, DAO extends AbstractDao<Entity, Long>> {


    Long create(Entity entity);

    void create(List<Entity> entity);

    Long createOrUpdate(Entity entity);

    List<Entity> read();

    Entity readById(Long id);

    void update(Entity entity);

    void delete(Entity entity);

    void deleteById(Long id);
}

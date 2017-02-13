package konicki.mateusz.greendaosample.db.dbhelper;

import konicki.mateusz.greendaosample.entites.DaoSession;

/**
 * Created by Mateusz on 11.02.2017.
 */
public interface IDBHelper {
    DaoSession getSession();
}

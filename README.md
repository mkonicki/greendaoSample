# GreenDao Sample App #
Sample application to present greendao library - [GreenDao](http://greenrobot.org/greendao/)

In this repository is presneted how to model database, create releation, prepare and run queries and present how to use GreenDao with Repository Pattern in Sample App

## Database model ##
Database used in application was presented on diagram
[DatabaseModel](https://creately.com/diagram/iz4lat5e2/BsoKAwKoZzlD4iK4yR9pw431oQ%3D)

Database consists 4 entities
- [Task](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/Task.java)
- [Todo](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/ToDo.java)
- [User](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/User.java)
- [ToDoUser](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/ToDoUser.java)

In entity Task is used Enum type [TaskType](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/ToDoType.java) which can be used in entity by using type converter [TaskTypeConverter](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/entites/ToDoTypePropertyConverter.java)


## Sample database operations in Repository Pattern ##
Basic CRUD operations are presented in [Base Repository Class] (https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/db/repository/BaseRepository.java)
All operations are tested in [Base Repository test](https://github.com/mkonicki/greendaoSample/blob/master/app/src/test/java/konicki/mateusz/greendaosample/BaseRepositoryTest.java)

Operations on ToDo entity are presented in [ToDoRepository](https://github.com/mkonicki/greendaoSample/blob/master/app/src/main/java/konicki/mateusz/greendaosample/db/repository/ToDoRepository.java)
and tested in [ToDoTest](https://github.com/mkonicki/greendaoSample/blob/master/app/src/test/java/konicki/mateusz/greendaosample/ToDoRepositoryTest.java)

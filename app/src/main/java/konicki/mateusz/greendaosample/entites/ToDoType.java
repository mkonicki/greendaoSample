package konicki.mateusz.greendaosample.entites;

/**
 * Created by Mateusz on 13.02.2017.
 */

public enum ToDoType {
    WORK(1),
    HOBBY(2),
    DOMESTICITY(3);


    private int id;

    ToDoType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static ToDoType of(Integer databaseValue) {
        for (ToDoType type : ToDoType.values()) {
            if (type.getId() != databaseValue) {
                continue;
            }
            return type;
        }
        return null;
    }
}

package konicki.mateusz.greendaosample.entites;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by Mateusz on 13.02.2017.
 */

public class ToDoTypePropertyConverter implements PropertyConverter<ToDoType, Integer> {
    @Override
    public ToDoType convertToEntityProperty(Integer databaseValue) {
        return ToDoType.of(databaseValue);
    }
    @Override
    public Integer convertToDatabaseValue(ToDoType entityProperty) {
        return entityProperty.getId();
    }
}
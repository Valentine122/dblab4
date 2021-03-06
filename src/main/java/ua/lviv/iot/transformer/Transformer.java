package ua.lviv.iot.transformer;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transformer<T> {

    private Class<T> myClass;

    public Transformer(Class<T> myClass) {
        this.myClass = myClass;
    }

    public Object transformToEntity(ResultSet rs) throws SQLException {
        Object entity = null;
        try {
            entity = myClass.getConstructor().newInstance();
            if (myClass.isAnnotationPresent(Table.class)) {
                for (Field field : myClass.getDeclaredFields()) {
                    if (field.isAnnotationPresent(Column.class)) {
                        field.setAccessible(true);
                        Column column = field.getAnnotation(Column.class);
                        String name = column.name();
                        @SuppressWarnings("rawtypes")
                        Class fieldType = field.getType();
                        if (fieldType == Integer.class) {
                            field.set(entity, rs.getInt(name));
                        } else if (fieldType == String.class) {
                            field.set(entity, rs.getString(name));
                        } else if (fieldType == Date.class) {
                            field.set(entity, rs.getDate(name));
                        } else if (fieldType == Float.class) {
                            field.set(entity, rs.getFloat(name));
                        }
                    }
                }
            }
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return entity;
    }
}

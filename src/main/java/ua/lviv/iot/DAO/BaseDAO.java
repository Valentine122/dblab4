package ua.lviv.iot.DAO;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;
import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.transformer.Transformer;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public abstract class BaseDAO<T, ID> implements BaseDAOTemplate<T, ID> {

    private final Class<T> currentClass;
    private static final String findAllTemplates = "SELECT * FROM tableName";
    private static final String findTemplate = findAllTemplates + " WHERE idName = ?";
    private static final String createTemplate = "INSERT tableName valuesOrder VALUES valuesPlaceholder";
    private static final String updateTemplate = "UPDATE tableName SET valuesToUpdate WHERE idName = idValue";
    private static final String deleteTemplate = "DELETE FROM tableName WHERE idName = ?";

    private String getAll;
    private String getBy;
    private String createBy;
    private String updateBy;
    private String deleteBy;

    public BaseDAO(Class<T> currentClass) {
        this.currentClass = currentClass;
        try {
            this.getAll = this.setQuery(findAllTemplates);
            this.getBy = this.setQuery(findTemplate);
            this.createBy = this.setQuery(createTemplate);
            this.updateBy = this.setQuery(updateTemplate);
            this.deleteBy = this.setQuery(deleteTemplate);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public List<T> getAll() throws SQLException {
        List<T> entities = new LinkedList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(getAll)) {
                while (resultSet.next()) {
                    entities.add((T) new Transformer<T>((Class<T>) currentClass).transformToEntity(resultSet));
                }
            }
        }
        return entities;
    }

    @SuppressWarnings({ "unchecked" })
    @Override
    public T getBy(ID id) throws SQLException {
        T entity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(getBy)) {
            statement.setString(1, String.valueOf(id));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    entity = (T) new Transformer<T>((Class<T>) currentClass).transformToEntity(resultSet);
                }
            }
        }
        return entity;
    }

    @Override
    public int delete(ID id) throws SQLException {
        int result = 0;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(deleteBy)) {
            statement.setString(1, String.valueOf(id));
            result = statement.executeUpdate();
        }
        return result;
    }

    @Override
    public int update(T entity) throws SQLException {
        int result = 0;
        String currentUpdate = null;
        Connection connection = ConnectionManager.getConnection();
        try {
            currentUpdate = setUpdateQuery(entity);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement = connection.prepareStatement(currentUpdate)) {
            result = statement.executeUpdate();
        }
        return result;
    }

    @Override
    public int create(T entity) throws SQLException {
        int result = 0;
        String currentCreate = null;
        Connection connection = ConnectionManager.getConnection();
        try {
            currentCreate = setCreateQuery(entity);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
        try (PreparedStatement statement = connection.prepareStatement(currentCreate)) {
            result = statement.executeUpdate();
        }
        return result;
    }

    private String setQuery(String template)
            throws IllegalArgumentException, IllegalAccessException {
        Field[] fields = currentClass.getDeclaredFields();
        String tableName = currentClass.getAnnotation(Table.class).name();
        String query = template.replace("tableName", tableName);
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                String idName = field.getAnnotation(Column.class).name();
                return query.replace("idName", idName);
            }
        }
        return query;
    }

    private String setCreateQuery(T entity)
            throws IllegalArgumentException, IllegalAccessException {
        StringBuffer valuesOrder = new StringBuffer().append('(');
        StringBuffer valuesPlaceholder = new StringBuffer().append('(');
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                continue;
            }
            valuesOrder.append(field.getAnnotation(Column.class).name()).append(", ");
            valuesPlaceholder.append("'").append(String.valueOf(field.get(entity)))
                    .append("', ");
        }
        valuesOrder.replace(valuesOrder.length() - 2, valuesOrder.length(), ")");
        valuesPlaceholder.replace(valuesPlaceholder.length() - 2, valuesPlaceholder.length(), ")");
        return createBy.replace("valuesOrder", valuesOrder).replace("valuesPlaceholder",
                valuesPlaceholder);
    }

    private String setUpdateQuery(T entity)
            throws IllegalArgumentException, IllegalAccessException {
        StringBuffer valuesToUpdate = new StringBuffer();
        String currentUpdate = null;
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                currentUpdate = updateBy.replace("idValue", String.valueOf(field.get(entity)));
                continue;
            }
            valuesToUpdate.append(field.getAnnotation(Column.class).name()).append("='")
                    .append(String.valueOf(field.get(entity))).append("', ");
        }
        valuesToUpdate.replace(valuesToUpdate.length() - 2, valuesToUpdate.length(), "");
        return currentUpdate.replace("valuesToUpdate", valuesToUpdate);
    }

}

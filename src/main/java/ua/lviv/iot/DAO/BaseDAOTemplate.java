package ua.lviv.iot.DAO;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAOTemplate<T, ID> {

    int create(T entity) throws SQLException;

    List<T> getAll() throws SQLException;

    T getBy(ID id) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(ID id) throws SQLException;

}

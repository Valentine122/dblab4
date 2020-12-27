package ua.lviv.iot.service;

import ua.lviv.iot.DAO.BaseDAOTemplate;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseService<T, ID, DAO> implements ServiceTemplate<T, ID> {

    private BaseDAOTemplate<T, ID> dataaccess;

    @SuppressWarnings({ "unchecked", "deprecation" })
    public BaseService(Class<DAO> currentClass) {
        try {
            dataaccess = (BaseDAOTemplate<T, ID>) currentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() throws SQLException {
        return dataaccess.getAll();
    }

    @Override
    public T findBy(ID id) throws SQLException {
        return dataaccess.getBy(id);
    }

    @Override
    public int delete(ID id) throws SQLException {
        return dataaccess.delete(id);
    }

    @Override
    public int update(T entity) throws SQLException {
        return dataaccess.update(entity);
    }

    @Override
    public int create(T entity) throws SQLException {
        return dataaccess.create(entity);
    }

}

package ua.lviv.iot.controller;


import ua.lviv.iot.persistant.ConnectionManager;
import ua.lviv.iot.service.BaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
public abstract class BaseController<T, ID, SERVICE> implements ControllerTemplate<T, ID>{

    BaseService service;

    public BaseController(Class<SERVICE> currentClass) {
        try {
            service = (BaseService) currentClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> findAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<T> entities = service.findAll();
        connection.close();
        return entities;
    }

    @Override
    public T findBy(ID id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        T entity = (T) service.findBy(id);
        connection.close();
        return entity;
    }

    @Override
    public int delete(ID id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int result = service.delete(id);
        connection.close();
        return result;
    }

    @Override
    public int update(T entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int result = service.update(entity);
        connection.close();
        return result;
    }

    @Override
    public int create(T entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        int result = service.create(entity);
        connection.close();
        return result;
    }

}

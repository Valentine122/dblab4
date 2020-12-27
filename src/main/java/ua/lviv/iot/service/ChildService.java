package ua.lviv.iot.service;

import ua.lviv.iot.DAO.ChildDAO;
import ua.lviv.iot.model.entity.Child;

public class ChildService extends BaseService<Child, Integer, ChildDAO>{
    public ChildService() {
        super(ChildDAO.class);
    }
}

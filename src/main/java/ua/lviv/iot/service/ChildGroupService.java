package ua.lviv.iot.service;

import ua.lviv.iot.DAO.ChildGroupDAO;
import ua.lviv.iot.model.entity.ChildGroup;

public class ChildGroupService extends BaseService<ChildGroup, Integer, ChildGroupDAO>{
    public ChildGroupService() {
        super(ChildGroupDAO.class);
    }
}

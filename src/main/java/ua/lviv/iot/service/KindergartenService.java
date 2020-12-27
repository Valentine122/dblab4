package ua.lviv.iot.service;

import ua.lviv.iot.DAO.KindergartenDAO;
import ua.lviv.iot.model.entity.Kindergarten;

public class KindergartenService extends BaseService<Kindergarten, Integer, KindergartenDAO>{
    public KindergartenService() {
        super(KindergartenDAO.class);
    }
}

package ua.lviv.iot.DAO;

import ua.lviv.iot.model.entity.Kindergarten;

public class KindergartenDAO extends BaseDAO<Kindergarten, Integer> {
    public KindergartenDAO() {
        super(Kindergarten.class);
    }
}

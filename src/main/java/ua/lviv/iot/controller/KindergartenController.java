package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Kindergarten;
import ua.lviv.iot.service.KindergartenService;

public class KindergartenController extends BaseController<Kindergarten, Integer, KindergartenService>{
    public KindergartenController() {
        super(KindergartenService.class);
    }
}

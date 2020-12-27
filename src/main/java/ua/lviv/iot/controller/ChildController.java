package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Child;
import ua.lviv.iot.service.ChildService;

public class ChildController extends BaseController<Child, Integer, ChildService> {
    public ChildController() {
        super(ChildService.class);
    }
}

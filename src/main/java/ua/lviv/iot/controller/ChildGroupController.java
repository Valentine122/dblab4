package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.ChildGroup;
import ua.lviv.iot.service.ChildGroupService;

public class ChildGroupController extends BaseController<ChildGroup, Integer, ChildGroupService>{
    public ChildGroupController() {
        super(ChildGroupService.class);
    }
}

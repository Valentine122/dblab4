package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Worker;
import ua.lviv.iot.service.WorkerService;

public class WorkerController extends BaseController<Worker, Integer, WorkerService> {
    public WorkerController() {
        super(WorkerService.class);
    }
}

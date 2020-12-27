package ua.lviv.iot.service;

import ua.lviv.iot.DAO.WorkerDAO;
import ua.lviv.iot.model.entity.Worker;

public class WorkerService extends BaseService<Worker, Integer, WorkerDAO> {
    public WorkerService() {
        super(WorkerDAO.class);
    }
}

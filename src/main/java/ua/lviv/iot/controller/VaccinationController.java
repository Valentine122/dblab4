package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Vaccination;
import ua.lviv.iot.service.VaccinationService;

public class VaccinationController extends BaseController<Vaccination, Integer, VaccinationService> {
    public VaccinationController() {
        super(VaccinationService.class);
    }
}

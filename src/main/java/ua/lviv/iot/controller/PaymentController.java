package ua.lviv.iot.controller;

import ua.lviv.iot.model.entity.Payment;
import ua.lviv.iot.service.PaymentService;

public class PaymentController extends BaseController<Payment, Integer, PaymentService>{
    public PaymentController() {
        super(PaymentService.class);
    }
}

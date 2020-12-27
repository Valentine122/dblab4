package ua.lviv.iot.service;

import ua.lviv.iot.DAO.PaymentDAO;
import ua.lviv.iot.model.entity.Payment;

public class PaymentService extends BaseService<Payment, Integer, PaymentDAO> {
    public PaymentService() {
        super(PaymentDAO.class);
    }
}

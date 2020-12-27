package ua.lviv.iot.DAO;

import ua.lviv.iot.model.entity.Payment;

public class PaymentDAO extends BaseDAO<Payment, Integer> {
    public PaymentDAO() {
        super(Payment.class);
    }
}

package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "payment")
public class Payment {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "worker_id")
    private Integer workerId;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "amount_of_remuneration")
    private Integer amountOfRemuneration;
    @Column(name = "date_of_pay")
    private Date dateOfPay;

    public Payment() {}

    public Payment(Integer workerId, Integer salary, Integer amountOfRemuneration, Date dateOfPay) {
        this(-1, workerId, salary, amountOfRemuneration, dateOfPay);
    }

    public Payment(Integer id, Integer workerId, Integer salary, Integer amountOfRemuneration, Date dateOfPay) {
        this.id = id;
        this.workerId = workerId;
        this.salary = salary;
        this.amountOfRemuneration = amountOfRemuneration;
        this.dateOfPay = dateOfPay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAmountOfRemuneration() {
        return amountOfRemuneration;
    }

    public void setAmountOfRemuneration(Integer amountOfRemuneration) {
        this.amountOfRemuneration = amountOfRemuneration;
    }

    public Date getDateOfPay() {
        return dateOfPay;
    }

    public void setDateOfPay(Date dateOfPay) {
        this.dateOfPay = dateOfPay;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", workerId=" + workerId +
                ", salary=" + salary +
                ", amountOfRemuneration=" + amountOfRemuneration +
                ", dateOfPay=" + dateOfPay;
    }
}

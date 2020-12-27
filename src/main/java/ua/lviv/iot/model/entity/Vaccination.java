package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "vaccination")
public class Vaccination {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "child_id")
    private Integer childId;
    @Column(name = "name")
    private String name;
    @Column(name = "date_of_vaccination")
    private Date dateOfVaccination;

    public Vaccination() {}

    public Vaccination(Integer childId, String name, Date dateOfVaccination) {
        this(-1, childId, name, dateOfVaccination);
    }

    public Vaccination(Integer id, Integer childId, String name, Date dateOfVaccination) {
        this.id = id;
        this.childId = childId;
        this.name = name;
        this.dateOfVaccination = dateOfVaccination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfVaccination() {
        return dateOfVaccination;
    }

    public void setDateOfVaccination(Date dateOfVaccination) {
        this.dateOfVaccination = dateOfVaccination;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", technicId=" + childId +
                ", name='" + name + '\'' +
                ", dateOfVaccination=" + dateOfVaccination;
    }
}

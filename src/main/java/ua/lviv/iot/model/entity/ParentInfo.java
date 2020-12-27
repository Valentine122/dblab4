package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "parent_info")
public class ParentInfo {
    @PrimaryKey
    @Column(name = "child_id")
    private Integer childId;
    @Column(name = "father_surname")
    private String fatherSurname;
    @Column(name = "mother_phone_number", length = 20)
    private String motherPhoneNumber;

    public ParentInfo() {}

    public ParentInfo(String fatherSurname,  String motherPhoneNumber) {
        this(-1, fatherSurname, motherPhoneNumber);
    }

    public ParentInfo(Integer childId, String fatherSurname, String motherPhoneNumber) {
        this.childId = childId;
        this.fatherSurname = fatherSurname;
        this.motherPhoneNumber = motherPhoneNumber;
    }

    public Integer getChildId() {
        return childId;
    }

    public void setChildId(Integer childId) {
        this.childId = childId;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherPhoneNumber() {
        return motherPhoneNumber;
    }

    public void setMotherPhoneNumber(String motherPhoneNumber) {
        this.motherPhoneNumber = motherPhoneNumber;
    }

    @Override
    public String toString() {
        return "\n" +
                "childId=" + childId +
                ", technic_name='" + fatherSurname + '\'' +
                ", infoPhoneNumber='" + motherPhoneNumber + '\'';
    }
}

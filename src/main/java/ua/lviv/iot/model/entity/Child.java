package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

import java.sql.Date;

@Table(name = "child")
public class Child {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", length = 500)
    private String name;
    @Column(name = "date_of_entry")
    private Date dateOfEntry;
    @Column(name = "child_group_id")
    private Integer childGroupId;
    @Column(name = "child_group_kindergarten_id")
    private Integer childGroupKindergartenId;
    @Column(name = "status", length = 20)
    private String status;

    public Child() {}

    public Child(String name, Date dateOfEntry, Integer childGroupId, Integer childGroupKindergartenId, String status) {
        this(-1, name,  dateOfEntry, childGroupId, childGroupKindergartenId, status);
    }

    public Child(Integer id, String name,  Date dateOfEntry, Integer childGroupId, Integer childGroupKindergartenId, String status) {
        this.id = id;
        this.name = name;
        this.dateOfEntry = dateOfEntry;
        this.childGroupId = childGroupId;
        this.childGroupKindergartenId = childGroupKindergartenId;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Integer getChildGroupId() {
        return childGroupId;
    }

    public void setChildGroupId(Integer childGroupId) {
        this.childGroupId = childGroupId;
    }

    public Integer getChildGroupKindergartenId() {
        return childGroupKindergartenId;
    }

    public void setChildGroupKindergartenId(Integer childGroupKindergartenId) {
        this.childGroupKindergartenId = childGroupKindergartenId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfEntry=" + dateOfEntry +
                ", TechnicStatusId=" + childGroupId +
                ", TechnicStatusBoschId=" + childGroupKindergartenId +
                ", status='" + status + '\'';
    }
}

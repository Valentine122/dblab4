package ua.lviv.iot.model.entity;

import ua.lviv.iot.model.annotation.Column;
import ua.lviv.iot.model.annotation.PrimaryKey;
import ua.lviv.iot.model.annotation.Table;

@Table(name = "child_group")
public class ChildGroup {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "kindergarten_id")
    private Integer kindergartenId;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "count_of_children")
    private Integer countOfChildren;

    public ChildGroup() {}

    public ChildGroup(Integer kindergartenId, String name, Integer countOfChildren) {
        this(-1, kindergartenId, name, countOfChildren);
    }

    public ChildGroup(Integer id, Integer kindergartenId, String name, Integer countOfChildren) {
        this.id = id;
        this.kindergartenId = kindergartenId;
        this.name = name;
        this.countOfChildren = countOfChildren;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKindergartenId() {
        return kindergartenId;
    }

    public void setKindergartenId(Integer kindergartenId) {
        this.kindergartenId = kindergartenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountOfChildren() {
        return countOfChildren;
    }

    public void setCountOfChildren(Integer countOfChildren) {
        this.countOfChildren = countOfChildren;
    }

    @Override
    public String toString() {
        return "\n" +
                "id=" + id +
                ", boschId=" + kindergartenId +
                ", name='" + name + '\'' +
                ", countOfTechnics=" + countOfChildren;
    }
}

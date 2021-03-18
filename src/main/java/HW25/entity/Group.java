package HW25.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "student_group")
@Getter
@Setter
@ToString
public class Group {

    @Id
    @Column(name = "group_ID")
    private int group_ID;

    @Column(name = "student_group")
    private String student_group;

    public int getGroup_ID() {
        return group_ID;
    }

    public void setGroup_ID(int group_ID) {
        this.group_ID = group_ID;
    }

    public String getStudent_group() {
        return student_group;
    }

    public void setStudent_group(String student_group) {
        this.student_group = student_group;
    }
}
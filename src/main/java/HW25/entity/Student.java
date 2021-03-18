package HW25.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "new_student")
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class Student {

    @Id
    @Column(name = "student_ID")
    private int student_ID;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "admisson_year")
    private int admisson_year;

    @Column(name = "group_ID")
    private int group_ID ;


    public void setStudentFullName(String fullname) {
        this.fullname = fullname;
    }

    public int getStudent_ID() {
        return student_ID;
    }

    public void setStudent_ID(int student_ID) {
        this.student_ID = student_ID;
    }

    public int getAdmisson_year() {
        return admisson_year;
    }

    public void setAdmisson_year(int admisson_year) {
        this.admisson_year = admisson_year;
    }

    public int getGroup_ID() {
        return group_ID;
    }

    public void setGroup_ID(int group_ID) {
        this.group_ID = group_ID;
    }
}
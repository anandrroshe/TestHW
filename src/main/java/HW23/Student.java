package HW23;

public class Student {

        private int student_id;
        private String fullname;
        private int admisson_year;
        private int group_id;

    public Student(int student_ID,String fullname, int admisson_year, int group_ID){

        this.student_id = student_ID;
        this.fullname = fullname;
        this.admisson_year = admisson_year;
        this.group_id = group_ID;
    }

    public int getAdmisson_year() {
        return admisson_year;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public String getFullname() {
        return fullname;
    }
}

package HW23;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException{
        QueryManager queryManager = new QueryManager();
    Student student = new Student(4,"Ann Frank", 2020, 202001);
    System.out.println("===================================");
    queryManager.showAllStudents();
    System.out.println("===================================");
    queryManager.addStudent(student);
    System.out.println("===================================");
    queryManager.filterByStID(4);
    System.out.println("===================================");
    queryManager.filterByFullName("Fedyr Fedorov");
    System.out.println("===================================");
    queryManager.filterByAdmissionYear(2019);
    System.out.println("===================================");
    queryManager.filterByGroupID(202001);
    System.out.println("===================================");
    queryManager.deleteStudent(4);
    System.out.println("===================================");
    queryManager.showAllStudents();
    System.out.println("===================================");

    }

}

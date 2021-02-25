package HW23;

import java.sql.*;


public class QueryManager {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static  String url = "jdbc:mysql://localhost:3306/student?";
    private static  String user = "root";
    private static  String password = "00000000";


    public QueryManager() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();

    }catch (SQLException e){
        System.out.println(e);
        }
    }
    public void showAllStudents()throws SQLException{
        String query = "SELECT *FROM new_student";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?", "root", "1312hjkhjk");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String data = "";
                for (int i = 1; i < 5 ; i++) {
                    data += resultSet.getString(i) + " | ";
                }
                System.out.println(data);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public void filterByStID(int studentID) throws SQLException {
        String query = "SELECT *FROM new_student WHERE student_ID=" + studentID;
    ResultSet resultSet = statement.executeQuery(query);
    while (resultSet.next()) {
        String data = "";
        for (int i = 1; i < 5; i++) {
            data += resultSet.getString(i) + " | ";
        }
        System.out.println(data);
        }
    }
    public void filterByFullName(String name) throws SQLException {
        String query = "SELECT *FROM new_student WHERE fullname LIKE '" + name + "%' ";
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String data = "";
            for (int i = 1; i < 5; i++) {
                data += resultSet.getString(i) + " | ";
            }
            System.out.println(data);
        }
    }
    public void filterByAdmissionYear(int year) throws SQLException {
        String query = "SELECT *FROM new_student WHERE admisson_year=" + year;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String data = "";
            for (int i = 1; i < 5; i++) {
                data += resultSet.getString(i) + " | ";
            }
            System.out.println(data);
        }
    }
    public void filterByGroupID(int groupID) throws SQLException {
        String query = "SELECT *FROM new_student WHERE group_ID=" + groupID;
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String data = "";
            for (int i = 1; i < 5; i++) {
                data += resultSet.getString(i) + " | ";
            }
            System.out.println(data);
        }
    }
public static void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO new_student(student_ID, fullname, admisson_year, group_ID)"
                +"VALUES(?, ?, ?, ?)";
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }catch (ClassNotFoundException e){
        e.printStackTrace();
    }
    try {
        connection = DriverManager.getConnection(url,user,password);
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,student.getStudent_id());
        preparedStatement.setString(2,student.getFullname());
        preparedStatement.setInt(3,student.getAdmisson_year());
        preparedStatement.setInt(4,student.getGroup_id());
        System.out.println("Rows impacted: " + preparedStatement.executeUpdate());
        connection.close();

    }catch (SQLException e){
        System.out.println(e);
    }
}
public static void deleteStudent(int studentID) throws SQLException {
        String query = "DELETE FROM new_student WHERE student_ID="+studentID;
        connection = DriverManager.getConnection(url,user,password);
        preparedStatement = connection.prepareStatement(query);
        System.out.println("Rows impacted: " + preparedStatement.executeUpdate());
        connection.close();

}

}

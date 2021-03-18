package HW25;


import HW25.entity.Group;
import HW25.entity.Student;
import org.hibernate.Session;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static Session session;

    public static void main(String[] args) {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        System.out.println("Show all students");
        System.out.println(QManager.getStudent(session));
        System.out.println("------------------------------------------");
        QManager.addStudent(session, stScanner());
        System.out.println("------------------------------------------");
        System.out.println( QManager.getStudent(session, 2));
        System.out.println("------------------------------------------");
        System.out.println(QManager.getStudent(session,"Fedyr Fedorov"));
        System.out.println("------------------------------------------");


    }

    private static Student stScanner(){
        Student student = new Student();
        System.out.println("Create new student in Data Base.\nEnter your full name: ");
        Scanner scanner = new Scanner(System.in);
        String fullname = scanner.next();
        student.setStudentFullName(fullname);
        List<Group> groupList = session.createQuery("FROM Group").list();
            for (int i = 0; i < groupList.size(); i++) {
                System.out.println(groupList.get(i));
            }
            System.out.println("Enter group ID: ");
            Scanner scGroup = new Scanner(System.in);
            String group = scGroup.next();
            switch (group){
                case "201803":
                    student.setGroup_ID(201803);
                    break;
                case "201902":
                    student.setGroup_ID(201902);
                    break;
                case "202001":
                    student.setGroup_ID(202001);
                    break;
                default:
                    System.err.println("Error: wrong group.");
                    scGroup.next();
            }
            while (true){
                System.out.println("Enter admission year: ");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()){
                    int year = sc.nextInt();
                    student.setAdmisson_year(year);
                    break;
                }else {
                    System.err.println("Error: wrong year.");
                    sc.next();
                }
            }
        List <Student> idSt = session.createQuery("FROM Student").list();
        for (Student st :idSt) {
            System.out.println("Enter student ID: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            if (id != st.getStudent_ID()){
                student.setStudent_ID(id);
                break;
            }else {
                System.err.println("Error: wrong ID.");
            }
        }return student;
        }
}


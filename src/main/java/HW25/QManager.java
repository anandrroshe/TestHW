package HW25;

import HW25.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class QManager {

    public static void addStudent(Session session, Student student) {
        session.save(student);
        session.getTransaction().commit();
    }

    public static List<Student> getStudent(Session session) {
        return session.createQuery("FROM Student").list();
    }

    public static Student getStudent(Session session, int id) {
        return (Student) session.createQuery("FROM Student as s where s.student_ID = " + id).uniqueResult();
    }

    public static Student getStudent(Session session, String fullName) {
        return (Student) session.createQuery("FROM Student as s where s.fullname = '" + fullName + "'").uniqueResult();
    }


}

package demo.hibernate;


import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();

        try {

           int studentId=4;

            //now get a new session and start transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id:PK
            System.out.println("Getting student with id: "+studentId);

            Student myStudent=session.get(Student.class,studentId);

            System.out.println("Updating student...");
            myStudent.setFirstName("ankit");

            //commit the transaction
            session.getTransaction().commit();

            //Updating email id
            session=factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Updating email id for some students");
            session.createQuery("update Student set email='foo@gmail.com' where id=4").executeUpdate();

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}

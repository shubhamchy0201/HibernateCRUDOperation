package demo.hibernate;


import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();

        try {
            //Use the session object to save java object

            //Creating student object
            Student tempStudent=new Student("karan","kohli","karan@google.com");

            //Start a transaction
            session.beginTransaction();

            //save the student object
            session.save(tempStudent);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}

package demo.hibernate;

import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();

        try {
            //Use the session object to save java object

            //Creating 3  student object
            System.out.println("Create 3 student object");
            Student tempStudent1=new Student("aman","kumar","aman@gmail.com");
            Student tempStudent2=new Student("sohan","kumar","sohan@gmail.com");
            Student tempStudent3=new Student("sumit","kr","sumit@gmail.com");

            //Start a transaction
            session.beginTransaction();

            //save the students object
            session.save(tempStudent1);
            session.save(tempStudent2 );
            session.save(tempStudent3);

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }
    }
}

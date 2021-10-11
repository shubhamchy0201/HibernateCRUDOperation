package demo.hibernate;


import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        //Create session factory
        SessionFactory factory= new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //Create session
        Session session=factory.getCurrentSession();

        try {

            //Start a transaction
            session.beginTransaction();
            //query students
            List<Student> theStudents=session.createQuery("from Student").list();

            //display the students
            System.out.println("Displaying all students");
            displatStudents(theStudents);

            //Query students :last name=kumar
           theStudents=session.createQuery("from Student s where s.lastName='kumar'").list();
            System.out.println("Display students whose last name is kumar: ");
           displatStudents(theStudents);

           //Display student whose last name=kumar OR firstname=shubham
            theStudents=session.createQuery("from Student s where s.lastName='kumar'" +
                    " OR s.firstName='shubham'").list();
            System.out.println("DIsplay Students whose first name is shubham and last name is kumar");
            displatStudents(theStudents);

            //Display students whose email id is like @google.com
            System.out.println("DIsplay Students whose email is like @google.com");
            theStudents=session.createQuery("from Student s where s.email LIKE '%@google.com'" ).list();
            displatStudents(theStudents);
            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }

    private static void displatStudents(List<Student> theStudents) {
        for(Student tempStudent: theStudents)
        {
            System.out.println(tempStudent);
        }
    }
}

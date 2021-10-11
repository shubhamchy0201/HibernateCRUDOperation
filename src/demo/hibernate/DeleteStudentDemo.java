package demo.hibernate;


import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {
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

            System.out.println("Deleting student whose id=4");
            session.delete(myStudent);


            //Another way of deleting data

            System.out.println("Deleting data from students table");
            session.createQuery("delete from Student where id=2").executeUpdate();

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}

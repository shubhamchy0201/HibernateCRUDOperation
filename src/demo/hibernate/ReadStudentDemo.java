package demo.hibernate;


import hibernatedemo.mapping.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {
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
            System.out.println("Creating student object: ");
            Student tempStudent=new Student("Daffy","duck","daffy@gmail.com");

            //Start a transaction
            session.beginTransaction();

            //save the student object
            System.out.println("Saving the object");
            System.out.println(tempStudent);
            session.save(tempStudent);

            //Commit transaction
            session.getTransaction().commit();

            //find out the students id
            System.out.println("Saved student Generated id: "+tempStudent.getId());
            //now get a new session and start transaction
            session=factory.getCurrentSession();
            session.beginTransaction();

            //Retrieve student based on the id:PK
            System.out.println("Getting student with id: "+tempStudent.getId());

            Student myStudent=session.get(Student.class,tempStudent.getId());

            System.out.println("GET complete "+myStudent);

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done");

        }
        finally {
            factory.close();
        }

    }
}

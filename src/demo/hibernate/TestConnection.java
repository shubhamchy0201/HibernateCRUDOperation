package demo.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSl=false";
        String user="hibernatedemo";
        String pass="Choudhary@123";
        try
        {
            System.out.println("Connecting to database : "+jdbcUrl);
            Connection conn= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection is successful");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

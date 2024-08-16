package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class Insert {

    public static void main(String[] argv) throws Exception {
        String driver = "com.mysql.jdbc.Driver";

        Class.forName(driver);// A call to forName("X") causes the class named X to be initialized.
            
        //DriverManager.getConnection returns a connection to the URL
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "admin");
        // "jdbc:mysql://localhost:3306/student", "root", "admin" : student signifies the database which we are going to use
        // "root" is the admin user id for database
        // "admin" is the password set for the user admin at the time of installation of MySql
        
        
        System.out.println("Connection String is: "+ con.toString());        
        

        String name = "\"Anish\"";
        String roll = "\"05\"";
        String query = "INSERT into student VALUES(" + roll + "," + name + ");";
        // here the "student" is actually a table created inside the database with the same name student
        System.out.println("Query is :" + query);
        
        Statement st = con.createStatement(); // Creates a Statement object for sending SQL statements to the database.
        
        int val = st.executeUpdate(query);// Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE statement
                                         //or any SQL statement that returns nothing, such as an SQL DDL statement.
                                          

        System.out.println("1 row affected");
        con.close();
    }
}

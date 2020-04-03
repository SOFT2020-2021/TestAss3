package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO implements Contact {
    
    Connection connection;

    public void connect (String connectionString) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/bank","bankuser","secret");

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }

    public void open(){

    }

    public void close(){

    }

    public Connection getConnection(){ return connection; }

}

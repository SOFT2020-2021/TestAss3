package dataLayer.performers;


import dataLayer.DAO;
import dataLayer.entitites.Account;

import java.sql.Statement;
import java.sql.SQLException;

public class AccountPerformer {

    public Account getOne() {
        return null;
    }

    public boolean deleteOne() {
        return false;
    }

    public boolean persist() {
        try {
            Statement statement = new DAO().connection.createStatement();
        } catch (SQLException e ){
            System.out.println("Du er dårlig");
        }
        return false;
    }

    public boolean update() {
        return false;
    }
}

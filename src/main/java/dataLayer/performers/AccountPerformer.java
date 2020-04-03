package dataLayer.performers;

import dataLayer.DAO;
import dataLayer.entitites.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountPerformer {

    public Account get(int id) {
        Account acc = null;
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("SELECT * FROM accounts WHERE id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                acc = new Account(null, null, rs.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return acc;
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("DELETE FROM accounts WHERE id=?;");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void persist(int balance, int cpr, int cvr) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("INSERT INTO accounts(balance, customerCpr, bankCvr) VALUES(?,?,?);");
            ps.setInt(1, balance);
            ps.setInt(2, cpr);
            ps.setInt(3, cvr);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, int balance, int cpr, int cvr) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("UPDATE accounts SET balance=?, cpr=?, cvr=? WHERE id=?;");
            ps.setInt(1, balance);
            ps.setInt(2, cpr);
            ps.setInt(3, cvr);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package dataLayer.performers;

import dataLayer.entitites.User;
import dataLayer.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPerformer {

    public User get(int cpr) {
        User user = null;
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("SELECT * FROM users WHERE cpr = ?;");
            ps.setInt(1, cpr);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                user = new User(Integer.parseInt(rs.getString(1)), rs.getString(2));
            }
            rs.close();
            ps.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    public void delete(int cpr) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("DELETE FROM users WHERE cpr = ?;");
            ps.setInt(1, cpr);
            ps.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void persist(int cpr, String name) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("INSERT INTO users(cpr,name) VALUES(?, ?);");
            ps.setInt(1, cpr);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void update(int oldCpr, int cpr, String name) {
        try {
            PreparedStatement ps = DAO.connection.prepareStatement("UPDATE users SET cpr=?, name=? WHERE cpr=?");
            ps.setInt(1, cpr);
            ps.setString(2, name);
            ps.setInt(3, oldCpr);
            ps.executeUpdate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

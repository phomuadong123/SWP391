/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class UserDAO extends DBContext {

    public boolean checkEmailExits(String email) {
        try {
            String sql = "SELECT * FROM [User] u WHERE u.email=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (!rs.next()) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
     public User getUserById(int id) {
        User u = new User();

        try {
            String sql = "SELECT * FROM [User] u WHERE u.id=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setFullName(rs.getString("fullName"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setRole(rs.getString("role"));
                u.setMail(rs.getString("mail"));
                u.setCartId(rs.getInt("cartId"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    public void changePassword(String mail, String password) {
        try {
            String sql = "UPDATE [User] SET password = ? WHERE email = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, password);
            stm.setString(2, mail);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

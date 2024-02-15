/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Account;
import Models.Feature;
import Models.Role;
import Models.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AD
 */
public class UserDAO extends MyDAO {

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
            stm.setNString(1, password);
            stm.setNString(2, mail);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public User getAccount(String email, String password) {
        User x = null;
        xSql = "SELECT [id]\n"
                + "      ,[fullName]\n"
                + "      ,[email]\n"
                + "      ,[password]\n"
                + "      ,[phone]\n"
                + "      ,[status]\n"
                + "      ,[role]\n"
                + "      ,[wishlist_id]\n"
                + "      ,[cart_id]\n"
                + "  FROM [SWP391_Gr1].[dbo].[User]\n"
                + "  WHERE email=? AND password=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();

            if (rs.next()) {
                x = new User();
                x.setId(rs.getInt("id"));
                x.setFullName(rs.getString("fullName"));
                x.setMail(rs.getString("email"));
                x.setPassword(rs.getString("password"));
                x.setPhone(rs.getString("phone"));
                x.setRole(rs.getString("role"));
                x.setCartId(rs.getInt("cart_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }
     
     public ArrayList<Role> getRolesAndFeatures(String username, String url) {
        ArrayList<Role> roles = new ArrayList<>();
        try {
            String sql = "SELECT a.email,r.role_id,r.role_name,f.fid,f.url  FROM \n"
                    + "[User] a INNER JOIN [Role_Account] ra \n"
                    + "ON a.id = ra.uid\n"
                    + "INNER JOIN [Role] r\n"
                    + "ON ra.rid = r.role_id\n"
                    + "INNER JOIN Role_Feature rf\n"
                    + "ON rf.rid= r.role_id\n"
                    + "INNER JOIN Feature f\n"
                    + "ON f.fid = rf.fid\n"
                    + "WHERE\n"
                    + "a.email = ? AND f.url = ?";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, url);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Role r = new Role();
                r.setId(rs.getInt("rid"));
                r.setName(rs.getString("rname"));

                Feature f = new Feature();
                f.setId(rs.getInt("fid"));
                f.setUrl(rs.getString("url"));

                r.getFeatures().add(f);
                roles.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return roles;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Account;
import java.sql.ResultSet;

/**
 *
 * @author taisk
 */
public class WishListDao extends MyDAO {

    public int createWishList(Account acc) {
        Account x = null;
        xSql = "INSERT INTO [dbo].[WishList] ([user_id]) OUTPUT Inserted.* VALUES (?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, acc.getId());
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

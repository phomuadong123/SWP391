package DataAccess;

import Models.Account;
import java.sql.ResultSet;

/**
 * Data Access Object for handling Account-related operations.
 */
public class AccountDAO extends MyDAO {

    /**
     * Retrieves an Account from the database based on the provided email and
     * password.
     *
     * @param email The email of the account.
     * @param password The password of the account.
     * @return An Account object if found, or null otherwise.
     */
    public Account getAccount(String email, String password) {
        Account x = null;
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
                x = new Account();
                x.setId(rs.getInt("id"));
                x.setFullname(rs.getString("fullName"));
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

    public boolean checkAccountExist(String email) {

        xSql = "SELECT * FROM [User] WHERE email=?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (!rs.next()) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Account signUp(Account acc) {
        xSql = "INSERT INTO [dbo].[User] ([fullName], [email], [password], [phone]) OUTPUT Inserted.* VALUES (?, ?, ?, ?);";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, acc.getFullname());
            ps.setString(2, acc.getMail());
            ps.setString(3, acc.getPassword());
            ps.setString(4, acc.getPhone());

            ResultSet result = ps.executeQuery();

            if (result.next()) {
                acc.setId(result.getInt("id"));
            } else {
                // Xử lý trường hợp không có bản ghi nào được chèn
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    public void updateAccount(int idW, int idC, int idAcount) {
        xSql = "UPDATE [dbo].[User]\n"
                + "   SET [wishlist_id] = ?\n"
                + "      ,[cart_id] = ?\n"
                + " WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, idW);
            ps.setInt(2, idC);
            ps.setInt(3, idAcount);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

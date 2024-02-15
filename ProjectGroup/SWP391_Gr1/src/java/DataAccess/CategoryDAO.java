/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class CategoryDAO extends DBContext {

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> category = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [Category]\n"
                    + "  where parent_id is null ";
            stm = connection.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setCategoryName(rs.getString("name"));
                category.add(c);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return category;
    }

    public ArrayList<Category> getBrandNameAndNumber() {
        ArrayList<Category> category = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT COUNT(x.id) as 'brandNumber', \n"
                    + "c.name as 'brandName'\n"
                    + "FROM (SELECT c.id,p.name,p.price,p.description\n"
                    + "FROM Category c join Product p\n"
                    + "on c.id=p.category_id\n"
                    + "group by c.parent_id,p.id,c.id,c.name,p.category_id,\n"
                    + "p.name,p.description,p.price,p.quantity,p.gender) x \n"
                    + "join Category c \n"
                    + "on x.id=c.id\n"
                    + "group by x.id,c.id,c.name";
            stm = connection.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setCategoryName(rs.getString("brandName"));
                c.setBrandNumber(rs.getInt("brandNumber"));
                category.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return category;
    }

    public ArrayList<Category> getSubcategory(int cid) {
        
        ArrayList<Category> category = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[parent_id]\n"
                    + "  FROM [Category]\n"
                    + "  where parent_id = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            rs = stm.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setCategoryName(rs.getString("name"));
                c.setParentId(rs.getInt("parent_id"));
                category.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return category;
    }

}

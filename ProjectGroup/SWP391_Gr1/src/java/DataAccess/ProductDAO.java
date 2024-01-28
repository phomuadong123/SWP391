/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Images;
import Models.Product;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> product = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top(3) p.id, p.name,p.description,p.price,i.url,\n"
                    + "                    i.id as 'imageId'\n"
                    + "                     FROM [Product] p join Image i \n"
                    + "                     on p.id=i.product_id\n"
                    + "					 where price > 100";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                p.setTitle(rs.getString("title"));
                Images i = new Images();
                i.setId(rs.getInt("imageId"));
                i.setUrl(rs.getString("url"));
                p.setImages(i);
                product.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return product;
    }

    public ArrayList<Product> getRecomendProduct() {
        ArrayList<Product> product = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT top(3) p.id, p.name,p.description,p.price,i.url,\n"
                    + "                    i.id as 'imageId'\n"
                    + "                     FROM [Product] p join Image i \n"
                    + "                     on p.id=i.product_id\n"
                    + "					 where price > 100 ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                Images i = new Images();
                i.setId(rs.getInt("imageId"));
                i.setUrl(rs.getString("url"));
                p.setImages(i);
                product.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return product;
    }

    public ArrayList<Product> pagingProduct(int index) {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "SELECT p.id, p.name,p.description,p.price,i.url,\n"
                + "i.id as 'imageId'\n"
                + "  FROM [JollyShoppingOnline].[dbo].[Product] p join Image i \n"
                + "  ON p.id=i.product_id\n"
                + "order by p.id\n"
                + "offset ? row fetch next 6 rows only";

        try {
            PreparedStatement st = connection.prepareCall(sql);

            st.setInt(1, (index - 1) * 6);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setProductName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getFloat("price"));
                Images i = new Images();
                i.setId(rs.getInt("imageId"));
                i.setUrl(rs.getString("url"));
                p.setImages(i);
                list.add(p);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getTotalProduct() {
        String sql = "  select count(*) from [Product]";

        try {
            PreparedStatement st = connection.prepareCall(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return 0;
    }
}

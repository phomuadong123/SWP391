/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Blog;
import Models.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class BlogDAO extends DBContext {

    public ArrayList<Blog> getAllBlog(int index) {
        ArrayList<Blog> blog = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[title]\n"
                    + "      ,[shortContent]\n"
                    + "      ,[content]\n"
                    + "      ,[publishedDate]\n"
                    + "      ,[image]\n"
                    + "      ,[user_id]\n"
                    + "      ,[author]\n"
                    + "  FROM [JollyShoppingOnline].[dbo].[Blog]\n"
                    + "  order by publishedDate\n"
                    + "	offset ? row fetch next 3 rows only";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, (index - 1) * 3);
            rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setShortContent(rs.getString("shortContent"));
                b.setPublishedDate(rs.getDate("publishedDate"));
                b.setImage(rs.getString("image"));
                b.setPublishedTime(rs.getTime("publishedDate"));
                b.setAuthor(rs.getString("author"));
                blog.add(b);

            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return blog;
    }
    
    public Blog getBlogById(String id) {
        
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT  [id]\n"
                    + "      ,[title]\n"
                    + "      ,[shortContent]\n"
                    + "      ,[content]\n"
                    + "      ,[publishedDate]\n"
                    + "      ,[image]\n"
                    + "      ,[user_id]\n"
                    + "      ,[author]\n"
                    + "  FROM [JollyShoppingOnline].[dbo].[Blog]\n"
                    + "where id=?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                Blog b = new Blog();
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setShortContent(rs.getString("shortContent"));
                b.setPublishedDate(rs.getDate("publishedDate"));
                b.setImage(rs.getString("image"));
                b.setPublishedTime(rs.getTime("publishedDate"));
                b.setAuthor(rs.getString("author"));
                
                return b;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return null;
    }
    
    public int getTotalBlog() {
        String sql = "  select count(*) from [Blog]";

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

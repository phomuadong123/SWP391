/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Slider;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class SliderDAO extends DBContext {

    public ArrayList<Slider> getAllSlider() {
        ArrayList<Slider> slider = new ArrayList<>();
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT  [sid]\n"
                    + "      ,[image]\n"
                    + "  FROM [JollyShoppingOnline].[dbo].[Slider]";
            stm = connection.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                Slider s = new Slider();
                s.setSid(rs.getInt("sid"));
                s.setImage(rs.getString("image"));
                
                slider.add(s);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return slider;
    }
}

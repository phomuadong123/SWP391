/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess;

import Models.Order;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author datnt
 */
public class OrderDAO extends MyDAO {

    public List<Order> getOrderHistory(int userId, int offset) {
        // get list item in cart.
        List<Order> OrderList = new ArrayList<Order>();
        String sql = "Select id, customerName, phone, address, total, date, status, user_id "
                + "from dbo.[Order] where user_id = ? order by date desc offset ? row fetch next 4 rows only";
        try {
            ps = connection.prepareCall(sql);
            ps.setInt(1, userId);            
            ps.setInt(2, (offset - 1) * 4);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setUserId(rs.getInt("user_id"));
                order.setOrderId(rs.getInt("id"));
                order.setDate(rs.getDate("date"));
                order.setCustomerName(rs.getString("customerName"));
                order.setAddress(rs.getString("address"));
                order.setTotal(rs.getDouble("total"));
                order.setStatus(rs.getString("status"));
                OrderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OrderList;
    }
    
    public int getOrderHistoryCount(int userId) {
        int count = 0;
        String sql = "Select count(*) from dbo.[Order] where user_id = ?";
        try {
            ps = connection.prepareCall(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}

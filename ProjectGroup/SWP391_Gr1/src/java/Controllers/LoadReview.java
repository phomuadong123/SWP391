/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DataAccess.ProductDAO;
import Models.Rating;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tuant
 */
public class LoadReview extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductDAO pdao = new ProductDAO();
        String id = request.getParameter("id");
        String amount = request.getParameter("amount");
        int amoun = Integer.parseInt(amount);
        ArrayList<Rating> r = pdao.getNext3RatingByProductID(amoun,id);
        PrintWriter out = response.getWriter();
        
            
        
        for (Rating o : r) {
            for (int i = 0; i < (o.getQuantity()); i++) {  
                out.println("<i id=\"stars\" class=\"fa fa-star\"></i>");
            }
            out.println("<div class=\" product\" style=\"border-bottom-color:grey \">\n" +
"                                                <ul>\n" +
"                                                    <li><a href=\"\"><i class=\"fa fa-user\"></i>"+o.getUser().getFullName()+"</a></li>\n" +
"                                                    <li><a href=\"\"><i class=\"fa fa-clock-o\"></i>"+o.getUser().getMail()+"</a></li>\n" +
"                                                    <li><a href=\"\"><i class=\"fa fa-calendar-o\"></i>"+o.getDate()+"</a></li>\n" +
"                                                </ul>\n" +
"                                                <input type=\"hidden\" id=\"numberInput\" value=\"1\">\n" +
"                                                <h4 style=\"padding-bottom: 20px; border-bottom: 1px solid #c9302c\">"+o.getContent()+"</h4>\n" +
"                                            </div>");
            
            
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

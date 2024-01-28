/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DataAccess.CategoryDAO;
import DataAccess.ProductDAO;
import DataAccess.SliderDAO;
import Models.Category;
import Models.Product;
import Models.Slider;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author tuant
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        ProductDAO productDAO = new ProductDAO();
        SliderDAO sliderDAO = new SliderDAO();

        ArrayList<Slider> sliders = sliderDAO.getAllSlider();
        ArrayList<Category> categorys = categoryDAO.getAllCategory();
        
        for (Category category : categorys) {
            ArrayList<Category> test = categoryDAO.getSubcategory(category.getId());
            category.setSubCategory(test);
        }
            
        ArrayList<Product> products = productDAO.getRecomendProduct();
        ArrayList<Category> brand = categoryDAO.getBrandNameAndNumber();

        //pagingnation
        int count = productDAO.getTotalProduct();
        int endPage = count / 6;
        if (count % 6 != 0) {
            endPage++;
        }
        request.setAttribute("endpage", endPage);
        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index;
        try {

            index = Integer.parseInt(indexPage);
            ArrayList<Product> list = productDAO.pagingProduct(index);
            request.setAttribute("tagindex", index);
            request.setAttribute("product", list);

        } catch (Exception e) {
            System.out.println(e);
        }
        
        


        request.setAttribute("products", products);
        request.setAttribute("slider", sliders);
        request.setAttribute("category", categorys);
        request.setAttribute("brand", brand);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.Authentication;


import DataAccess.AccountDAO;
import Models.Account;
import Models.Role;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author sonnt
 */
public abstract class BasedAuthorizationController extends BasedRequiredAuthenticationController {

    private boolean isAuthorized(Account LoggedUser, HttpServletRequest request) {
        String username = LoggedUser.getMail();
        String url = request.getServletPath();
        AccountDAO db = new AccountDAO();
        LoggedUser.setRoles(db.getRolesAndFeatures(username, url));
        return 1 <= LoggedUser.getRoles().size();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response, Account LoggedUser) throws ServletException, IOException {
        if (isAuthorized(LoggedUser, request)) {
            doPost(request, response, LoggedUser, LoggedUser.getRoles());
        } else {
            response.getWriter().println("access denied!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response, Account LoggedUser) throws ServletException, IOException {
        if (isAuthorized(LoggedUser, request)) {
            doGet(request, response, LoggedUser, LoggedUser.getRoles());
        } else {
            response.getWriter().println("access denied!");
        }
    }

    protected abstract void doPost(HttpServletRequest request, HttpServletResponse response, Account LoggedUser, ArrayList<Role> roles) throws ServletException, IOException;

    protected abstract void doGet(HttpServletRequest request, HttpServletResponse response, Account LoggedUser, ArrayList<Role> roles) throws ServletException, IOException;

}

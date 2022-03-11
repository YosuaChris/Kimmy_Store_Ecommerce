/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import connection.DbCon;
import dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Michell
 */
@WebServlet("/RegistrasiServlet")
public class RegistrasiServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            User user1 = new User();
            
            String name = request.getParameter("registrasi-name");
            String email = request.getParameter("registrasi-email");
            String password = request.getParameter("registrasi-password");
            
            user1.setName(name);
            user1.setEmail(email);
            user1.setPassword(password);
            
            UserDao udao = new UserDao(DbCon.getConnection());
            udao.userRegistrasi(user1);
            
            response.sendRedirect("login.jsp");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}

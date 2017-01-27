/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.wat.cinema.user.User;
import pl.edu.wat.cinema.util.HibernateUtil;

/**
 *
 * @author Kamil
 */
public class LoginServlet extends HttpServlet {

    //String error="User or password incorrect";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where login= '" + login + "'");
        User user = (User) query.uniqueResult();
        session.getTransaction().commit();
        System.out.println("HAHAHAHAAHHAAH  " + query.uniqueResult());

        if (!(query.uniqueResult() == null) && user.getLogin().equals(login) && user.getPassword().equals(password) && !(user.getPassword() == null) && !(user.getLogin() == null)) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("");
            System.out.println("Login successful");
        } else {
            //request.setAttribute("errorMessage",error);
            response.setContentType("text/html");
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Bledny login lub haslo.');");
            out.println("window.location.href='login.xhtml';");
            out.println("</script>");
            //response.sendRedirect("login.xhtml");
            System.out.println("Login failure");
        }
        session.close();

    }

}

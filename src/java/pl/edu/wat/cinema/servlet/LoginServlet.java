/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.servlet;

import java.io.IOException;
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from User where login= '" + login + "'");
        User user = (User) query.uniqueResult();
            session.getTransaction().commit();
        session.close();

        if (user.getLogin()!=null && user.getPassword()!=null && user.getLogin().equals(login) && user.getPassword().equals(password)) {
            request.getSession().setAttribute("user",user);
            response.sendRedirect("index.xhtml");
            System.out.println("Login successful");
        } else {
            response.sendRedirect("login.html");
            System.out.println("Login failure");
        }

    }

}

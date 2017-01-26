/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.servlet;

import com.sun.org.apache.bcel.internal.classfile.Attribute;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;

/**
 *
 * @author Kamil
 */
//@WebServlet(name = "LogoutServlet", urlPatterns = {"/LogoutServlet"})
public class LogoutServlet extends HttpServlet {

    HttpSession session;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        User user=session.
//         session.removeAttribute("user",user);
//        session.invalidate();                               
        session = request.getSession();
        
        if (session != null) {
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("");
        }
        
    }

}

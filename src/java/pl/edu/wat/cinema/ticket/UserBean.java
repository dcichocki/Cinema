/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.ticket;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.wat.cinema.seance.Seance;
import static pl.edu.wat.cinema.seance.SeanceController.current;
import pl.edu.wat.cinema.servlet.LoginServlet;
import static pl.edu.wat.cinema.servlet.LoginServlet.loginUser;
import pl.edu.wat.cinema.util.HibernateUtil;

/**
 *
 * @author Damian
 */
@Named(value = "UserBean")
@SessionScoped
public class UserBean implements Serializable {

    HttpSession session2;
    DataModel userT = null;
    Session session;
    public static Ticket current;
    List<Ticket> list;

    public UserBean() {
    }
    public void clear(){
    userT=null;
    }
    public DataModel getUserTicket() {
        
        if (userT != null) {
        } else {
            userT = new ListDataModel(getUserTicketList());
        }
        return userT;
    }
    //wyszukiwanie biltów usera
    public List getUserTicketList() {
        //list.clear();
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Ticket ticket where ticket.user.user_id = '" + LoginServlet.userSession.getUser_id() + "'");
        list = (List<Ticket>) q.list();
        //userT = new ListDataModel(list);

        return list;

    }
    
        public String deleteTicket(int t) {
            Ticket ticketD = new Ticket();
ticketD.setTicket_id(t);
 session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
 session.delete(ticketD);
 tx.commit();
// session.close();
            System.out.println(t);
          userT=null;
       
        return "user";
        }
}

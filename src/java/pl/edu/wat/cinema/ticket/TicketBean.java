/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.ticket;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.wat.cinema.seance.SeanceController;
import static pl.edu.wat.cinema.servlet.LoginServlet.loginUser;
import pl.edu.wat.cinema.user.User;
import pl.edu.wat.cinema.util.HibernateUtil;

/**
 *
 * @author Damian
 */
@Named(value = "ticketBean")
@SessionScoped
public class TicketBean implements Serializable {

    private List<Ticket> ticket = new ArrayList<>();

    Session session;
    HttpSession session2;

    public TicketBean() {

    }

    public String getCinemaName(int seance_id) {
        return "Multikino";
    }

    public void readDatabase(int seance_id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        System.out.println("dsadsad");
        Query q = session.createQuery("from Ticket as ticket where ticket.seance_id = '" + seance_id + "' ");
        ticket = (List<Ticket>) q.list();
    }

    public boolean isSeatReserved(int x, int y, int seance_id, int room) {
        if (ticket.isEmpty()) {
            readDatabase(seance_id);
        }
        int k = 0;
        for (int i = 0; i < ticket.size(); i++) {
            if ((ticket.get(i).getSites_x() == x) && (ticket.get(i).getSites_y() == y) && (ticket.get(i).getSeance_id()==seance_id) ) {
                k = 1;
            }
        }
        return (k == 1);

    }

    public void reserveSeat(int x, int y, int seance_id, int film_id, int room_id) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Ticket tickete = new Ticket(seance_id, film_id, room_id, x, y);

        System.out.println("Rezerwuje: " + x + " " + y);
        session.beginTransaction();
        //User user = (User)session2.getAttribute("user");

        session.save(tickete);
        Query q = session.createSQLQuery("insert into kino." + loginUser + " (ticket_id, title, sites_x, sites_y, date, hour, room) values ('" + tickete.getTicket_id() + "', '" + SeanceController.current.getTitle() + "', '" + x + "', '" + y + "', '" + SeanceController.current.getDate() + "', '" + SeanceController.current.getHour() + "', '" + room_id + "')");
        q.executeUpdate();
        session.getTransaction().commit();
        ticket.clear();

    }

}

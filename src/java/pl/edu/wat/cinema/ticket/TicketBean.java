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
import pl.edu.wat.cinema.seance.Seance;
import static pl.edu.wat.cinema.servlet.LoginServlet.userSession;
import pl.edu.wat.cinema.util.HibernateUtil;

/**
 *
 * @author Damian
 */
@Named(value = "ticketBean")
@SessionScoped
public class TicketBean implements Serializable {

    private List<Ticket> ticket = new ArrayList<>();
    int readData = 0; //zmienna pomocnicza w przybaku braku piletów
    Session session;
    HttpSession session2;

    public TicketBean() {

    }
    //pobieranie z bazy danych biletów
    public void readDatabase(int seance_id) {
        readData = 1;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        org.hibernate.Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Ticket as ticket where ticket.seance.seance_id = '" + seance_id + "' ");
        ticket = (List<Ticket>) q.list();
    }
    //sprawdzanie czy dane miejsce jest zarezerwowane
    public boolean isSeatReserved(int x, int y, Seance seance1) {
        if (ticket.isEmpty() && (readData == 0)) {
            readDatabase(seance1.getSeance_id());
        }
        int k = 0;
        for (int i = 0; i < ticket.size(); i++) {
            if ((ticket.get(i).getSites_x() == x) && (ticket.get(i).getSites_y() == y)) {
                k = 1;
            }
        }
        return (k == 1);

    }
    //rezerwacja miejsca
    public void reserveSeat(int x, int y, Seance seances) {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Ticket tickete = new Ticket(x, y, userSession, seances);

        System.out.println("Rezerwuje: " + x + " " + y);
        session.beginTransaction();
        //User user = (User)session2.getAttribute("user");

        session.save(tickete);
        session.getTransaction().commit();
       // session.close();
        readData = 0;
        ticket.clear();

    }

}

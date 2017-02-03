/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.seance;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pl.edu.wat.cinema.util.HibernateUtil;

/**
 *
 * @author Damian
 */
public class SeanceHelper {

    Session session;

    public SeanceHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public List getSeanceList(int startID, int endID) {
        List<Seance> seanceList = null;
        System.out.println("startID" + startID);
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Seance as seance where seance.seance_id between '" + startID + "' and '" + endID + "'");
            seanceList = (List<Seance>) q.list();
        } catch (Exception e) {
        }
        return seanceList;

    }

    public Seance getSeanceByID(int seance_id) {

        Seance seance = null;

        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Seance as seance where seance.seance_id=" + seance_id);
            seance = (Seance) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return seance;
    }

}

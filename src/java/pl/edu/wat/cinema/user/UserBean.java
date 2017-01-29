/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.user;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import static pl.edu.wat.cinema.servlet.LoginServlet.loginUser;

/**
 *
 * @author Damian
 */
@Named(value = "userBean")
@Dependent
public class UserBean {
    
      HttpSession session2;
    DataModel userT;
    Session session;
    int startId = 0;
    int endId= 10;

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
     public DataModel getUsetTicket() {
        if (userT != null) {
        } else {
            userT = new ListDataModel(getUserTicket());
        }
        return userT;
    }
    
        public List getUserTicket() {
        List<UserTicket> ticketList = null;
        try {
            org.hibernate.Transaction tx = session.beginTransaction();
            // Query q = session.createSQLQuery("select * from '" + loginUser
           //     + " from UserTicket as '" + loginUser + "' where '"+ loginUser +"'.login_id between '" + 1 +"' and '" + 10 + "'");
         //  q.executeUpdate();
           // Query q = session.createQuery("from UserTicket as '" + loginUser + "' where '"+ loginUser +"'.login_id between '" + 1 +"' and '" + 10 + "'");
          //  ticketList = (List<UserTicket>) q.list();
        } catch (Exception e) {
        }
        return ticketList;

    }
}

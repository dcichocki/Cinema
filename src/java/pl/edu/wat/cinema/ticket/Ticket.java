/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.ticket;

import pl.edu.wat.cinema.seance.Seance;
import pl.edu.wat.cinema.user.User;

/**
 *
 * @author Damian
 */
public class Ticket {

    private int ticket_id;
    private int sites_x;
    private int sites_y;
    private User user;
    private Seance seance;

    public Ticket() {
    }

    public Ticket(int sites_x, int sites_y, User user, Seance seance) {
        this.seance = seance;
        this.sites_x = sites_x;
        this.sites_y = sites_y;
        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getSites_x() {
        return sites_x;
    }

    public void setSites_x(int sites_x) {
        this.sites_x = sites_x;
    }

    public int getSites_y() {
        return sites_y;
    }

    public void setSites_y(int sites_y) {
        this.sites_y = sites_y;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

}

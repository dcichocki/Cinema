/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.ticket;

/**
 *
 * @author Damian
 */
public class Ticket {

    private int ticket_id;
    private int seance_id;
    private int film_id;
    private int room_id;
    private int sites_x;
    private int sites_y;

    public Ticket(int seance_id, int film_id, int room_id, int sites_x, int sites_y) {
        this.seance_id = seance_id;
        this.film_id = film_id;
        this.room_id = room_id;
        this.sites_x = sites_x;
        this.sites_y = sites_y;

    }
    public Ticket(){
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

    public int getSeance_id() {
        return seance_id;
    }

    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

}

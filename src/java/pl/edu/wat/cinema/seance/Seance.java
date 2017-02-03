/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.seance;

import java.io.Serializable;
import java.util.Set;
import pl.edu.wat.cinema.film.Film;
import pl.edu.wat.cinema.ticket.Ticket;

/**
 *
 * @author Damian
 */
public class Seance implements Serializable {

    private int seance_id;
    private String date;
    private String roomNumber;
    private String hour;
    private Film film;
    private Set<Ticket> ticket;

    public Seance() {
    }

    public Seance(String roomNumber, String date, String hour, Film film) {
        this.film = film;
        this.date = date;
        this.roomNumber = roomNumber;
        this.hour = hour;
    }

    public Set<Ticket> getTicket() {
        return ticket;
    }

    public void setTicket(Set<Ticket> ticket) {
        this.ticket = ticket;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getSeance_id() {
        return seance_id;
    }

    public void setSeance_id(int seance_id) {
        this.seance_id = seance_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}

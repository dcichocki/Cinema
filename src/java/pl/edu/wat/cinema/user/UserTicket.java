/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.user;

/**
 *
 * @author Damian
 */
public class UserTicket {

    private int login_id;
    private int ticket_id;
    private String title;
    private int sites_x;
    private int sites_y;
    private String date;
    private String hour;
    private int room;

    public UserTicket(int ticket_id, String title, int sites_x, int sites_y, String date, String hour, int room) {
        this.ticket_id = ticket_id;
        this.title = title;
        this.sites_x = sites_x;
        this.sites_y = sites_y;
        this.date = date;
        this.hour = hour;
        this.room = room;
    }

    public int getLogin_id() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id = login_id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
    

}

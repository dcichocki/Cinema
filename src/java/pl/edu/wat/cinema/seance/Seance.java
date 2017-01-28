/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.seance;


/**
 *
 * @author Damian
 */
public class Seance {

    int seance_id;
    String date;
    String roomNumber;
    String title;
    String description;
    String hour;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public Seance() {
    }

    public Seance(String roomNumber, String date, String title, String description, String hour) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.roomNumber = roomNumber;
        this.hour = hour;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title1) {
        this.title = title1;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description1) {
        this.description = description1;
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

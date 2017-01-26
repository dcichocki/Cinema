/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.room;

/**
 *
 * @author Damian
 */
public class Room {
    int room_id;
    int freeSpace;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    String name;
public Room(){}
    public Room(int room_id, int freeSpace, String name) {
        this.room_id = room_id;
        this.freeSpace = freeSpace;
        this.name = name;
    }

    public void setId(int room_id) {
        this.room_id = room_id;
    }

    public void setFreeSpace(int freeSpace) {
        this.freeSpace = freeSpace;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

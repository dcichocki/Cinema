/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.seance;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Named;
import pl.edu.wat.cinema.film.Film;

/**
 *
 * @author Damian
 */
@ManagedBean
@SessionScoped
public class SeanceController {

    int startId = 1;
    int endId = 10;
    DataModel seanceList;
    SeanceHelper helper;
    public static Seance current;
    private int selectedItemIndex;

    public SeanceController() {
    }

    public SeanceController(int startId, int endId) {
        helper = new SeanceHelper();
        this.startId = startId;
        this.endId = endId;
    }
        public Seance getSelected() {
        if (current == null) {
            current = new Seance();
            selectedItemIndex = -1;
        }
        return current;
    }

        public String prepareView() {
        current = (Seance) getSeanceList().getRowData();
        return "ticket";

    }
        
    public DataModel getSeanceList() {
        if (seanceList != null) {
        } else {
            seanceList = new ListDataModel(new SeanceHelper().getSeanceList(startId, endId));
        }
        return seanceList;
    }

}

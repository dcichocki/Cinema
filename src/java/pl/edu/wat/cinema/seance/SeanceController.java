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

    public SeanceController() {
    }

    public SeanceController(int startId, int endId) {
        helper = new SeanceHelper();
        this.startId = startId;
        this.endId = endId;
    }

    public DataModel getSeanceList() {
        if (seanceList != null) {
        } else {
            seanceList = new ListDataModel(new SeanceHelper().getSeanceList(startId, endId));
        }
        return seanceList;
    }

}

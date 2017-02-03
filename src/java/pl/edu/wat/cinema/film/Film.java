/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.edu.wat.cinema.film;

import java.io.Serializable;
import java.util.Set;
import pl.edu.wat.cinema.seance.Seance;

/**
 *
 * @author Damian
 */
public class Film implements Serializable {

    private Short film_id;
    private String title;
    private String description;
    private Set<Seance> seance;

    public Film() {
    }

    public Film(String title, String description) {

        this.title = title;
        this.description = description;
    }

    public Set<Seance> getSeance() {
        return seance;
    }

    public void setSeance(Set<Seance> seance) {
        this.seance = seance;
    }

    public Short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Short film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

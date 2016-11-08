package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Area extends Model {
    private int      idArea;
    private String   name;

    Area(){
        idArea = 0;
        name = "";
    }

    public Area(int idArea, String name) {
        this.idArea = idArea;
        this.name = name;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

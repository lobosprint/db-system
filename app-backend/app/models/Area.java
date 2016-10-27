package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Area extends Model {
    public int      idArea;
    public String   name;

    Area(){
        idArea = 0;
        name = "";
    }

    public Area(int idArea, String name) {
        this.idArea = idArea;
        this.name = name;
    }
}

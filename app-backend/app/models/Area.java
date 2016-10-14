package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Area extends Model {

    public String name;

    Area(){
        name = "";
    }

    public Area(String name) {
        this.name = name;
    }
}

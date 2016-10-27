package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Job extends Model {
    public int id;
    public String name;
    public String description;

    Job(){
        id          = 0;
        name        = "";
        description = "";
    }

    public Job(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}

package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Job extends Model {
    public String name;
    public String description;

    Job(){
        name        = "";
        description = "";
    }
}

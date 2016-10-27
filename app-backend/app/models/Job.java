package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Job extends Model {
    public int      idJob;
    public String   name;
    public String   description;

    Job(){
        idJob          = 0;
        name        = "";
        description = "";
    }

    public Job(int idJob, String name, String description) {
        this.idJob = idJob;
        this.name = name;
        this.description = description;
    }
}

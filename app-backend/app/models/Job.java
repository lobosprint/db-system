package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Job extends Model {
    private int      idJob;
    private String   name;
    private String   description;

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

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

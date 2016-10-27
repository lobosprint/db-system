package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Position extends Model {
    public int      idPosition;
    public Area     area;
    public Job      job;
    public Location location;

    Position(){
        idPosition = 0;
        area = new Area();
        job = new Job();
        location = new Location();
    }

    public Position(int idPosition, Area area, Job job, Location location) {
        this.idPosition = idPosition;
        this.area = area;
        this.job = job;
        this.location = location;
    }
}

package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Position extends Model {
    public Area     area;
    public Job      job;
    public Location location;

    Position(){
        area = new Area();
        job = new Job();
        location = new Location();
    }
}

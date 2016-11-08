package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Position extends Model {
    private int      idPosition;
    private Area     area;
    private Job      job;
    private Location location;

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

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
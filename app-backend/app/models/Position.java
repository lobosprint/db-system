package models;

/**
 * Created by cristian on 10-14-16.
 */
public class Position {
    public Area     area;
    public Job      job;
    public Location location;

    public Position(){
        area = new Area();
        job = new Job();
        location = new Location();
    }
}

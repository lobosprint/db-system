package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Location extends Model {
    public String office;
    public String building;
    public String longitude;
    public String latitude;

    Location() {
        office      = "";
        building    = "";
        longitude   = "";
        latitude    = "";
    }

    public Location(String office, String building, String longitude, String latitude) {
        this.office = office;
        this.building = building;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

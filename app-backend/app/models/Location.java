package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Location extends Model {
    public int      idLocation;
    public String   office;
    public String   building;
    public String   longitude;
    public String   latitude;

    Location() {
        idLocation  = 0;
        office      = "";
        building    = "";
        longitude   = "";
        latitude    = "";
    }

    public Location(int idLocation, String office, String building, String longitude, String latitude) {
        this.idLocation = idLocation;
        this.office = office;
        this.building = building;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}

package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Location extends Model {
    private int      idLocation;
    private String   office;
    private String   building;
    private String   longitude;
    private String   latitude;

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

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}

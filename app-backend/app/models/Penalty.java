package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Penalty extends Model {
    public Payment  payment;
    public String   description;

    Penalty(){
        payment     = new Payment();
        description = "";
    }

    public Penalty(String description) {
        this.description = description;
    }
}

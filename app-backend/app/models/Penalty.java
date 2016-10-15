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
    public Integer  cost;

    Penalty(){
        payment     = new Payment();
        description = "";
        cost        = 0;
    }

    public Penalty(String description, Integer cost) {
        this.description = description;
        this.cost = cost;
    }

    public Penalty(Payment payment, String description, Integer cost) {
        this.payment = payment;
        this.description = description;
        this.cost = cost;
    }
}

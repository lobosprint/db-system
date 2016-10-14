package models;

/**
 * Created by cristian on 10-14-16.
 */
public class Penalty {
    public Payment  payment;
    public String   description;

    public Penalty(){
        payment     = new Payment();
        description = "";
    }
}

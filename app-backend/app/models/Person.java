package models;

import com.avaje.ebean.Model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Person extends Model {
    public String   name;
    public String   middleName;
    public String   lastName;
    public Date     birthDate;
    public String   phone;
    public String   mail;
    public String   pass;
    public String   rumId;

    public Person(){
        name        = "";
        middleName  = "";
        lastName    = "";
        birthDate   = null;
        phone       = "";
        mail        = "";
        pass        = "";
        rumId       = "";
    }

}

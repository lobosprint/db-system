package models;

import com.avaje.ebean.Model;

import java.util.Date;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Person extends Model {
    public String   firstName;
    public String   middleName;
    public String   lastName;
    public Date     dateBirth;
    public String   phone;
    public String   mail;
    public String   pass;
    public String   rumId;


}

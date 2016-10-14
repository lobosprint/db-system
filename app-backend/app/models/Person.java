package models;

import com.avaje.ebean.Model;

import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Person extends Model {
    public String   name;
    public String   middleName;
    public String   lastName;
    public DateTime birthDate;
    public String   phone;
    public String   mail;
    public String   pass;
    public String   rumId;

    Person(){
        name        = "";
        middleName  = "";
        lastName    = "";
        birthDate   = null;
        phone       = "";
        mail        = "";
        pass        = "";
        rumId       = "";
    }

    Person(String name, String middleName, String lastName, DateTime birthDate,
                    String phone, String mail, String pass, String rumId){
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.mail = mail;
        this.pass = pass;
        this.rumId = rumId;
    }

}
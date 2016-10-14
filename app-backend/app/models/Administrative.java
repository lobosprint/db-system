package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Administrative extends Person{
    public Position position;

    Administrative(){
        position = new Position();
    }

    public Administrative(String name, String middleName, String lastName, DateTime birthDate,
                          String phone, String mail, String pass, String rumId, Position position) {
        super(name, middleName, lastName, birthDate, phone, mail, pass, rumId);
        this.position = position;
    }
}

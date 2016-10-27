package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Administrative extends Person{
    public int      idAdministrative;
    public Position position;

    Administrative(){
        idAdministrative    = 0;
        idPerson            = 0;
        position            = new Position();
    }

    public Administrative(int idAdministrative, int idPerson, String name, String middleName, String lastName, DateTime birthDate,
                          String phone, String mail, String pass, String rumId, Position position){
        super(idPerson, name, middleName, lastName, birthDate, phone, mail, pass, rumId);
        this.idAdministrative   = idAdministrative;
        this.position           = position;
    }
}

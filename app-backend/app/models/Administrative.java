package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
public class Administrative extends Person{
    private int      idAdministrative;
    private Position position;

    Administrative(){
        super();
        idAdministrative    = 0;
        position            = new Position();
    }

    public Administrative(int idPerson, int idAdministrative, String name, String middleName, String lastName, DateTime birthDate,
                          String phone, String mail, String pass, String rumId, Position position){
        super(idPerson, name, middleName, lastName, birthDate, phone, mail, pass, rumId);
        this.idAdministrative   = idAdministrative;
        this.position           = position;
    }

    public int getIdAdministrative() {
        return idAdministrative;
    }

    public void setIdAdministrative(int idAdministrative) {
        this.idAdministrative = idAdministrative;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

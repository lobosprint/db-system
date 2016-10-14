package models;

import javax.persistence.Entity;
import org.joda.time.DateTime;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Student extends Person{
    public boolean handiecap;

    Student(){
        super();
        handiecap = false;
    }

    public Student( String name, String middleName, String lastName, DateTime birthDate, String phone, String mail,
             String pass, String rumId, boolean handiecap ){

        super(name, middleName, lastName, birthDate, phone, mail, pass, rumId);
        this.handiecap = handiecap;
    }
}

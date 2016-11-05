package models;

import com.avaje.ebean.*;
import org.joda.time.DateTime;
import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

public class Student extends Person{
    public int      idStudent;
    public boolean  handiecap;

    public Student(){
        super();
        this.idStudent = 0;
        this.handiecap = false;
    }

    public Student( int idPerson, int idStudent, String name, String middleName, String lastName, DateTime birthDate, String phone, String mail,
             String pass, String rumId, boolean handiecap ){
        super(idPerson, name, middleName, lastName, birthDate, phone, mail, pass, rumId);
        this.idStudent = idStudent;
        this.handiecap = handiecap;
    }

}

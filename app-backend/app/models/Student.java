package models;

import com.avaje.ebean.*;
import org.joda.time.DateTime;
import play.mvc.Result;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by cristian on 10-14-16.
 */

public class Student extends Person{
    private int      idStudent;
    private boolean  handiecap;

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

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public boolean isHandiecap() {
        return handiecap;
    }

    public void setHandiecap(boolean handiecap) {
        this.handiecap = handiecap;
    }
}

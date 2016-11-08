package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Person extends Model{
    private int      idPerson;
    private String   name;
    private String   middleName;
    private String   lastName;
    private DateTime birthDate;
    private String   phone;
    private String   mail;
    private String   pass;
    private String   rumId;

    public Person(){
        idPerson    = 0;
        name        = "";
        middleName  = "";
        lastName    = "";
        birthDate   = null;
        phone       = "";
        mail        = "";
        pass        = "";
        rumId       = "";
    }

    public Person(int idPerson, String name, String middleName, String lastName, DateTime birthDate,
                    String phone, String mail, String pass, String rumId){
        this.idPerson = idPerson;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.mail = mail;
        this.pass = pass;
        this.rumId = rumId;
    }

    public Person(int idPerson, String name, String middleName, String lastName, DateTime birthDate,
           String phone, String mail, String rumId){
        this.idPerson = idPerson;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.mail = mail;
        this.rumId = rumId;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(DateTime birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRumId() {
        return rumId;
    }

    public void setRumId(String rumId) {
        this.rumId = rumId;
    }
}

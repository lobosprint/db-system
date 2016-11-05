package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Person extends Model{
    public int      idPerson;
    public String   name;
    public String   middleName;
    public String   lastName;
    public DateTime birthDate;
    public String   phone;
    public String   mail;
    public String   pass;
    public String   rumId;

    Person(){
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

    Person(int idPerson, String name, String middleName, String lastName, DateTime birthDate,
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

    public Person findStudentById(Integer id) {
        Transaction t = Ebean.beginTransaction();
        Person person = new Person();
        try {
            String sql = "SELECT sfirst, slast FROM student WHERE sid = :id";
            RawSql rawSql = RawSqlBuilder.parse(sql)
                    .columnMapping("sfirst", "name")
                    .columnMapping("slast", "lastName")
                    .create();
            Query<Person> query = Ebean.find(Person.class);
            query.setRawSql(rawSql)
                    .setParameter("id", id);
            person = query.findUnique();
            t.commit();
        } catch (Exception e) {
        } finally {
            t.end();
        }
        System.out.println("Informacion que retorna SName: " + person.name + "LName: " + person.lastName);
        return person;
    }
}

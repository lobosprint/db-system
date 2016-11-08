package models;

import com.avaje.ebean.*;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

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

    public Person findPersonById(Integer id) {
        Transaction t = Ebean.beginTransaction();
        Person person = new Person();
        try {
            String sql = "SELECT first_name, middle_name, last_name, date_birth, phone, email, rum_id FROM person WHERE id_person = :id";
            RawSql rawSql = RawSqlBuilder.parse(sql)
                    .columnMapping("first_name", "name")
                    .columnMapping("middle_name", "middleName")
                    .columnMapping("last_name", "lastName")
                    .columnMapping("date_birth", "birthDate")
                    .columnMapping("phone", "phone")
                    .columnMapping("email", "mail")
                    .columnMapping("rum_id", "rumId")
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
        System.out.println("Informacion que retorna first_name: " + person.name + " middle_name: " + person.middleName + " last_name: " + person.lastName);
        return person;
    }

//    public List<Person> findAllPersons() {
//        Transaction t = Ebean.beginTransaction();
//        List<Person> persons = new ArrayList<>();
//        try {
//            String sql = "SELECT first_name, middle_name, last_name, date_birth, phone, email, rum_id FROM person";
//            RawSql rawSql = RawSqlBuilder.parse(sql)
//                    .columnMapping("first_name", "name")
//                    .columnMapping("middle_name", "middleName")
//                    .columnMapping("last_name", "lastName")
//                    .columnMapping("date_birth", "birthDate")
//                    .columnMapping("phone", "phone")
//                    .columnMapping("email", "mail")
//                    .columnMapping("rum_id", "rumId")
//                    .create();
//            Query<Person> query = Ebean.find(Person.class);
//            query.setRawSql(rawSql);
//            persons = query.findList();
//            t.commit();
//        } catch (Exception e) {
//        } finally {
//            t.end();
//        }
//        for(int i = 0; i < persons.size(); i++){
//            System.out.println("Informacion que retorna first_name: " + persons.get(i).name + " middle_name: " + persons.get(i).middleName + " last_name: " + persons.get(i).lastName);
//        }
//        return persons;
//    }
}

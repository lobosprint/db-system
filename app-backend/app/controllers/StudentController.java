package controllers;

import static  play.libs.Json.toJson;

import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.Person;
import org.joda.time.DateTime;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristian on 10-14-16.
 */
public class StudentController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addStudent() {
        Student student = formFactory.form(Student.class).bindFromRequest().get();
        if(!student.mail.equals("") && !student.pass.equals("")){
            return ok(  "Added STUDENT successfully" + student.name + " " + student.middleName + " " +
                        student.lastName);
        } else{
            return internalServerError("Must provide the STUDENT mail and password like minimum");
        }
    }

    public Result getStudent(Integer id){
        Person person = new Person().findPersonById(id);
        return ok(toJson(person));
    }

    
    public Result getAllStudents(){
        Transaction t = Ebean.beginTransaction();
        List<Person> persons = new ArrayList<>();
        try {
            String sql = "SELECT id_person, first_name, middle_name, last_name, date_birth, phone, email, rum_id FROM person";
            RawSql rawSql = RawSqlBuilder.parse(sql)
                    .columnMapping("id_person", "idPerson")
                    .columnMapping("first_name", "name")
                    .columnMapping("middle_name", "middleName")
                    .columnMapping("last_name", "lastName")
                    .columnMapping("date_birth", "birthDate")
                    .columnMapping("phone", "phone")
                    .columnMapping("email", "mail")
                    .columnMapping("rum_id", "rumId")
                    .create();
            Query<Person> query = Ebean.find(Person.class);
            query.setRawSql(rawSql);
            persons = query.findList();
            t.commit();
        } catch (Exception e) {
        } finally {
            t.end();
        }
        for(int i = 0; i < persons.size(); i++){
            System.out.println("Informacion que retorna first_name: " + persons.get(i).name + " middle_name: " + persons.get(i).middleName + " last_name: " + persons.get(i).lastName);
        }
        return ok(toJson(persons));
    }

}

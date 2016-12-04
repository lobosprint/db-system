package controllers;

import static  play.libs.Json.toJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import persistence.DAOGeneric;
import persistence.DAOStudent;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cristian on 10-14-16.
 */
public class StudentController extends Controller{

    @Inject
    private FormFactory formFactory;

    private DAOStudent daoStudent = new DAOStudent();

    public Result addStudent() {
        JsonNode json = request().body().asJson();
        Boolean handiecap = json.findValue("handiecap").asBoolean();
        String first_name = json.findValue("first_name").asText();
        String middle_name = json.findValue("middle_name").asText();
        String last_name = json.findValue("last_name").asText();
        String date_birth = json.findValue("date_birth").asText().substring(0,10);
        String phone = json.findValue("phone").asText();
        String email = json.findValue("email").asText();
        String password = json.findValue("password").asText();
        String rum_id = json.findValue("rum_id").asText();
        daoStudent.addStudent(handiecap, first_name, middle_name, last_name, date_birth, phone, email, password, rum_id);
        return ok();
    }

    public Result getStudent(Integer id){
        return ok(toJson((Student) daoStudent.getObjectById(id)));
    }

    
    public Result getAllStudents(){
        return ok(toJson((List<Student>) daoStudent.getAllObjetcs()));
    }
}

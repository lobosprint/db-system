package controllers;

import static  play.libs.Json.toJson;

import com.avaje.ebean.*;
import com.google.inject.Inject;
import models.Person;
import org.joda.time.DateTime;
import persistence.DAOGeneric;
import persistence.DAOPerson;
import persistence.DAOStudent;
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

    private DAOGeneric daoStudent = new DAOStudent();

    public Result addStudent() {
        Student student = formFactory.form(Student.class).bindFromRequest().get();
        if(!student.getMail().equals("") && !student.getPass().equals("")){
            return ok(  "Added STUDENT successfully" + student.getName() + " " + student.getMiddleName() + " " +
                        student.getLastName());
        } else{
            return internalServerError("Must provide the STUDENT mail and password like minimum");
        }
    }

    public Result getStudent(Integer id){
        return ok(toJson((Student) daoStudent.getObjectById(id)));
    }

    
    public Result getAllStudents(){
        return ok(toJson((List<Student>) daoStudent.getAllObjetcs()));
    }
}

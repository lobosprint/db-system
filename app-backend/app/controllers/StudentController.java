package controllers;

import static  play.libs.Json.toJson;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Student;

import java.util.ArrayList;

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

    public Result getStudent(){
        Student student;
        student = new Student( 15, 1, "FName#123", "MName#123", "LName#123", new DateTime(),
                    "1234561", "FName123@test.com", "123451", "7891", false);
        return ok(toJson(student));
    }

    public Result getAllStudents(){
        ArrayList<Student> studentsList;
        studentsList = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            Student student;
            student = new Student((i+1), (i+1), "FName#" + (i+1), "MName#" + (i+1), "LName#" + (i+1), new DateTime(),
                    "1234561", "FName" + (i+1) + "@test.com", "123451", "7891", false);
            studentsList.add(student);
        }
        return ok(toJson(studentsList));
    }

}

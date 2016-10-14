package controllers;

import com.google.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Student;

/**
 * Created by cristian on 10-14-16.
 */
public class StudentController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addStudent() {
        Student student = formFactory.form(Student.class).bindFromRequest().get();
        if(!student.mail.equals("") && !student.pass.equals("")){
            return ok("Added STUDENT successfully" + student.name + " " + student.middleName + " " + student.lastName);
        } else{
            return internalServerError("Must provide the STUDENT mail and password like minimum");
        }
    }

}

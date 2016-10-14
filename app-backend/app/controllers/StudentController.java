package controllers;

import com.google.inject.Inject;
import models.Student;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by cristian on 10-14-16.
 */
public class StudentController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addStudent() {
        Student student = formFactory.form(Student.class).bindFromRequest().get();
        if(!student.mail.equals("") && !student.pass.equals("")){
            return ok("Sucessfull added student " + student.firstName + " " + student.middleName + " " + student.lastName);
        } else{
            return internalServerError("Must provide the mail and password like minumum");
        }
    }

}

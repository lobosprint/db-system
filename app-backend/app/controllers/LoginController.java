package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.inject.Inject;
import models.Login;
import play.api.libs.json.Json;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import views.html.*;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result index() {

        return ok(index.render("Your new application is ready."));
    }

    public Result login() {
        Login login = formFactory.form(Login.class).bindFromRequest().get();
        if(login.mail.equals("abc@abc.com") && login.pass.equals("abc")){
            return ok("Loggin succesfully, \n Mail: " + login.mail + " Password: " + login.pass);
        } else{
            return internalServerError("User don't have permission...");
        }
    }

}

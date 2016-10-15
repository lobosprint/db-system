package controllers;

import com.google.inject.Inject;
import models.Login;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    @Inject
    private FormFactory formFactory;

    public Result login() {
        Login login = formFactory.form(Login.class).bindFromRequest().get();
        if(login.mail.equals("abc@abc.com") && login.pass.equals("abc")){
            return ok("Login successfully, \n Mail: " + login.mail + " Password: " + login.pass);
        } else{
            return internalServerError("User don't have permission...");
        }
    }


}

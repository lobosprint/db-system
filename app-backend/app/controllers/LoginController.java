package controllers;

import com.google.inject.Inject;
import models.Login;
import persistence.DAOLogin;
import persistence.DAOPerson;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import static play.libs.Json.toJson;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    @Inject
    private FormFactory formFactory;

    DAOLogin daoLogin = new DAOLogin();

    public Result getLogin(String table, String mail, String password) {
        Object login = daoLogin.getLogin(table, mail, password);
        if(login.equals(null)){
            return internalServerError("User don't register yet... PLEASE CHECK");
        }else return ok(toJson(login));
    }


}

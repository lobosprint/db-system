package controllers;

import com.fasterxml.jackson.databind.JsonNode;
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

    public Result getLogin() {
        JsonNode json = request().body().asJson();
        String mail = json.findValue("mail").asText();
        String pass = json.findValue("pass").asText();
        return daoLogin.getLogin(mail, pass);
    }


}

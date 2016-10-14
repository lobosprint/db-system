package controllers;

import com.google.inject.Inject;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Turn;

/**
 * Created by cristian on 10-14-16.
 */
public class TurnController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addTurn() {
        Turn turn = formFactory.form(Turn.class).bindFromRequest().get();
        if (!turn.description.equals("1")){
            return ok("Added TURN successfully: " + turn.description);
        } else {
            return internalServerError("Must provide the TURN description like minimum");
        }
    }

}

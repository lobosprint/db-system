package controllers;

import com.google.inject.Inject;
import models.Penalty;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by cristian on 10-14-16.
 */
public class PenaltyController extends Controller{

    @Inject
    private FormFactory formFactory;

    public Result addPenalty (){
        Penalty penalty = formFactory.form(Penalty.class).bindFromRequest().get();
        if(!penalty.description.equals("1")){
            return ok("Added PENALTY successfully " + penalty.description);
        } else {
            return  internalServerError("Must provide the PENALTY description like minimum");
        }
    }

}

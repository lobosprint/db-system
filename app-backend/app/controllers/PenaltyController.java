package controllers;

import com.google.inject.Inject;
import models.Payment;
import models.Penalty;
import org.joda.time.DateTime;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;

import static play.libs.Json.toJson;

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

    public Result getPenalty(){
        Penalty penalty;
        penalty = new Penalty( "Tiempo de espera agotado", 10);
        return ok(toJson(penalty));
    }

    public Result getAllPenalties(){
        ArrayList<Penalty> penaltiesList;
        penaltiesList = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Penalty penalty;
            Payment payment;

            payment = new Payment(147850+i, new DateTime());
            penalty = new Penalty( payment, "Tiempo de espera agotado para el estudiante #" + (i+1), 10+i);

            penaltiesList.add(penalty);
        }
        return ok(toJson(penaltiesList));
    }

}
package controllers;

import com.google.inject.Inject;
import models.Payment;
import models.Penalty;
import models.Turn;
import org.joda.time.DateTime;
import persistence.DAOPenalty;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by cristian on 10-14-16.
 */
public class PenaltyController extends Controller{

    DAOPenalty daoPenalty = new DAOPenalty();

    @Inject
    private FormFactory formFactory;

    public Result addPenalty (){
        return null;
    }

    public Result getPenalty(){
        Penalty penalty;
        penalty = new Penalty();
        return ok(toJson(penalty));
    }

    public Result getAllPenalties(){
        ArrayList<Penalty> penaltiesList;
        penaltiesList = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            Penalty penalty;
            Payment payment;

            payment = new Payment((i+1), 47850+i, new DateTime());
            penalty = new Penalty((i+1), new Payment(), new Turn());

            penaltiesList.add(penalty);
        }
        return ok(toJson(penaltiesList));
    }

    public Result getPenaltiesByStudent(Integer idStudent){
        return ok(toJson((List<Penalty>) daoPenalty.getPenaltiesByStudent(idStudent)));
    }

}
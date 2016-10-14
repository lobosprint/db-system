package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import org.joda.time.DateTime;
import play.api.libs.json.Json;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import models.Turn;

import java.math.BigDecimal;
import java.util.ArrayList;

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

    public Result getAllTurns(){
        ArrayList<Turn> TurnsList;
        TurnsList = new ArrayList<>();

        for(int i = 0; i < 2; i++){
            Turn turn;
            turn = new Turn( "Bla bla bla #" + (i+1), new DateTime(), (new DateTime()).plusDays(10),
                                new BigDecimal(1000));
            TurnsList.add(turn);
        }

        JsonNode turnsListJson = Json.toJson(TurnsList);
        return ok(turnsListJson);
    }

}

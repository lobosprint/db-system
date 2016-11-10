package controllers;

import static  play.libs.Json.toJson;
import com.google.inject.Inject;
import models.*;
import persistence.*;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristian on 10-14-16.
 */
public class TurnController extends Controller{

    @Inject
    private FormFactory formFactory;

    DAOTurn daoTurn      = new DAOTurn();
    DAOArea daoArea      = new DAOArea();
    DAOAdministrative daoAdministrative = new DAOAdministrative();

    public Result addTurn() {
        Turn turn = formFactory.form(Turn.class).bindFromRequest().get();
        if (!turn.getDescription().equals("1")){
            return ok("Added TURN successfully: " + turn.getDescription());
        } else {
            return internalServerError("Must provide the TURN description like minimum");
        }
    }

    public Result getTurn(Integer id){
        return ok(toJson((Turn) daoTurn.getObjectById(id)));
    }

    public Result getAllTurns(){
        ArrayList<Turn> TurnsList;
        TurnsList = new ArrayList<>();
        return ok(toJson(TurnsList));
    }

    public Result getAllAreas(){
        return ok(toJson((List<Area>) daoArea.getAllObjetcs()));
    }

    public Result getAllJobsOfArea(Integer id){
        return ok(toJson((List<Job>) daoArea.getAllJobsOfArea(id)));
    }

    public Result getAllAdministrativesOfJob(Integer id){ return ok(toJson((List<Administrative>) daoAdministrative.getAllAdministrativesOfJob(id))); }

    public Result getAllPeopleInLineByAdmin(Integer idArea, Integer idJob, Integer idAdmin){
        return ok(toJson((List<Turn>) daoTurn.getAllPeopleInLineByAdmin(idArea, idJob, idAdmin)));
    }

    public Result getAllTurnsPendingByStudent(Integer idStudent){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByStudent(idStudent))); }

    public Result getAllTurnsPendingByAdmin(Integer idAdministrative){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByAdmin(idAdministrative))); }

    public Result getAllTurnsPendingByAdminJob(Integer idAdministrative, Integer idJob){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByAdminJob(idAdministrative, idJob))); }

}

package controllers;

import static  play.libs.Json.toJson;

import com.fasterxml.jackson.databind.JsonNode;
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

    DAOTurn daoTurn      = new DAOTurn();
    DAOArea daoArea      = new DAOArea();
    DAOAdministrative daoAdministrative = new DAOAdministrative();

    public Result addTurn() {
        JsonNode json = request().body().asJson();
        Integer id_student = json.findValue("id_student").asInt();
        Integer id_administrative = json.findValue("id_administrative").asInt();
        Integer id_position = json.findValue("id_position").asInt();
        Integer penalty_cost = json.findValue("penalty_cost").asInt();
        String description = json.findValue("description").asText();
        return daoTurn.addTurn(id_student, id_administrative, id_position, penalty_cost, description);
    }

    public Result addStartTime() {
        JsonNode json = request().body().asJson();
        Integer id_turn = json.findValue("id_turn").asInt();
        return daoTurn.addStartTime(id_turn);
    }

    public Result addFinishTime() {
        JsonNode json = request().body().asJson();
        Integer id_turn = json.findValue("id_turn").asInt();
        return daoTurn.addFinishTime(id_turn);
    }

    public Result addAttendedTurn(){
        JsonNode json = request().body().asJson();
        Integer id_turn = json.findValue("id_turn").asInt();
        return daoTurn.addAttendedTurn(id_turn);
    }

    public Result addCommentTurn(){
        JsonNode json = request().body().asJson();
        Integer id_turn = json.findValue("id_turn").asInt();
        String description = json.findValue("description").asText();
        return daoTurn.addCommentTurn(id_turn, description);
    }

    public Result updateComment(){
        JsonNode json = request().body().asJson();
        Integer id_comment = json.findValue("id_comment").asInt();
        Integer id_turn = json.findValue("id_turn").asInt();
        String description = json.findValue("description").asText();
        return daoTurn.updateComment(id_comment, id_turn, description);
    }

    public Result deleteComment(){
        JsonNode json = request().body().asJson();
        Integer id_comment = json.findValue("id_comment").asInt();
        Integer id_turn = json.findValue("id_turn").asInt();
        return daoTurn.deleteComment(id_comment, id_turn);
    }

    public Result deleteTurn(){
        JsonNode json = request().body().asJson();
        Integer id_turn = json.findValue("id_turn").asInt();
        return daoTurn.deleteTurn(id_turn);
    }

    public Result getTurn(Integer id){
        return ok(toJson((Turn) daoTurn.getObjectById(id)));
    }

    public Result getAllAreas(){ return ok(toJson((List<Area>) daoArea.getAllObjetcs()));}

    public Result getAllJobsOfArea(Integer id){
        return ok(toJson((List<Job>) daoArea.getAllJobsOfArea(id)));
    }

    public Result getAllAdministrativesOfJob(Integer idArea, Integer idJob){ return ok(toJson((List<Administrative>) daoAdministrative.getAllAdministrativesOfJob(idArea, idJob))); }

    public Result getAllPeopleInLineByAdmin(Integer idArea, Integer idJob, Integer idAdmin){
        return ok(toJson((List<Turn>) daoTurn.getAllPeopleInLineByAdmin(idArea, idJob, idAdmin)));
    }

    public Result getAllTurnsPendingByStudent(Integer idStudent){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByStudent(idStudent))); }

    public Result getAllTurnsByStudentNumber(Integer idStudent){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsByStudentNumber(idStudent))); }

    public Result getAllTurnsPendingByAdmin(Integer idAdministrative){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByAdmin(idAdministrative))); }

    public Result getAllTurnsPendingByAdminHistory(Integer idPerson){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByAdminHistory(idPerson))); }


    public Result getAllJobsofTurnsPendingByAdmin(Integer idAdministrative){ return ok(toJson((List<Job>) daoTurn.getAllJobsofTurnsPendingByAdmin(idAdministrative))); }

    public Result getAllTurnsPendingByAdminJob(Integer idAdministrative, Integer idJob){ return ok(toJson((List<Turn>) daoTurn.getAllTurnsPendingByAdminJob(idAdministrative, idJob))); }

    public Result getAllCommentsByTurn(Integer idTurn){return ok(toJson((List<Comment>) daoTurn.getAllCommentsByTurn(idTurn)));}
}

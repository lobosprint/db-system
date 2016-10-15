package controllers;

import static  play.libs.Json.toJson;
import com.google.inject.Inject;
import models.*;
import org.joda.time.DateTime;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

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

    public Result getTurn(){
        Turn    turn;
        Student turnStudent =
                            new Student(  "Peter", "Albeiro", "Ciclon-Caro", new DateTime(),
                                          "789456123", "pacc@gmail.com", "123456", "502-15-987", false);
        Area area           =
                            new Area("ICOM");
        Job job             =
                            new Job("Advisor", "I vahe to help and advise all students in your courses.");
        Location location   =
                            new Location("302", "Stefani", "18.209628" , "67.140002");

        Position position   =
                            new Position(area, job, location);

        Administrative turnAdministrative   =
                            new Administrative(  "Maria", "Antonieta", "De las Nieves", new DateTime(),
                                    "789456123", "laChilindrina@gmail.com", "123456", "304-987", position);

        Comment turnComment  =
                            new Comment("El muchacho tiene problemas con el chavo del 8");
        Penalty turnPenalty =
                            new Penalty("Es la tercera vez que solicita turno y no viene", 100  );
        turn                =
                            new Turn(   turnStudent, turnAdministrative, turnComment, turnPenalty,
                                        "Bla bla bla #123", new DateTime(), (new DateTime()).plusDays(10),
                                        100);
        return ok(toJson(turn));
    }

    public Result getAllTurns(){
        ArrayList<Turn> TurnsList;
        TurnsList = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            Turn    turn;
            Student turnStudent =
                    new Student("Peter #" + (i+1), "Albeiro #"+ (i+1), "Ciclon-Caro #"+ (i+1),
                                new DateTime(), "789456123"+ (i+1), "pacc@gmail.com"+ (i+1),
                                "123456"+ (i+1), "502-15-987"+ (i+1), false);
            Area area           =
                    new Area("ICOM #"+ (i+1));
            Job job             =
                    new Job(    "Advisor#"+ (i+1),
                                "I have to help and advise all students in your courses. #"+ (i+1));
            Location location   =
                    new Location("302-"+ (i+1), "Stefani #"+ (i+1), "18.209628" , "67.140002");

            Position position   =
                    new Position(area, job, location);

            Administrative turnAdministrative   =
                    new Administrative(  "Maria #"+ (i+1), "Antonieta #"+ (i+1), "De las Nieves #"+ (i+1),
                            new DateTime(), "789456123", "laChilindrina@gmail.com", "123456",
                            "304-987-#" + (i+1), position);

            Comment turnComment  =
                    new Comment("El muchacho tiene problemas con el chavo del 8. #"+ (i+1));
            Penalty turnPenalty =
                    new Penalty("Es la tercera vez que solicita turno y no viene. #"+ (i+1), 1000+i);
            turn                =
                    new Turn(   turnStudent, turnAdministrative, turnComment, turnPenalty,
                            "Bla bla bla #123" + (i+1), new DateTime(), (new DateTime()).plusDays(10+i),
                            1000+i);
            TurnsList.add(turn);
        }
        return ok(toJson(TurnsList));
    }

}

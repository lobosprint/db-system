package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import play.api.libs.json.JsValue;
import play.api.libs.json.Writes;
import scala.Function1;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Turn extends Model {
    public int              idTurn;
    public Student          student;
    public Administrative   administrative;

    public Penalty          penalty;
    public String           description;
    public DateTime         startTime;
    public DateTime         endTime;
    public Integer          penaltyCost;
    public ArrayList<Comment>      CommentList ;

    Turn() {
        idTurn = 0;
        student = new Student();
        administrative = new Administrative();
        CommentList = new  ArrayList<Comment>();
        penalty = new Penalty();
        description = "";
        startTime = null;
        endTime = null;
        penaltyCost = 0;

    }

    public Turn(String description, DateTime startTime, DateTime endTime, Integer penaltyCost){
        student = new Student();
        administrative = new Administrative();
        CommentList = new  ArrayList<Comment>();
        penalty = new Penalty();
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }

    public Turn(int idTurn, Student student, Administrative administrative, Comment comment, Penalty penalty, String description, DateTime startTime, DateTime endTime, Integer penaltyCost) {
        this.idTurn = idTurn;
        this.student = student;
        this.administrative = administrative;
        CommentList = new  ArrayList<Comment>();
        CommentList.add(comment);
        this.penalty = penalty;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }
}
package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import play.api.libs.json.JsValue;
import play.api.libs.json.Writes;
import scala.Function1;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Turn extends Model {

    public Student student;
    public Administrative administrative;
    public Comment comment;
    public Penalty penalty;
    public String description;
    public DateTime startTime;
    public DateTime endTime;
    public Integer penaltyCost;

    Turn() {
        student = new Student();
        administrative = new Administrative();
        comment = new Comment();
        penalty = new Penalty();
        description = "";
        startTime = null;
        endTime = null;
        penaltyCost = 0;
    }

    public Turn(String description, DateTime startTime, DateTime endTime, Integer penaltyCost){
        student = new Student();
        administrative = new Administrative();
        comment = new Comment();
        penalty = new Penalty();
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }

    public Turn(Student student, Administrative administrative, Comment comment, Penalty penalty, String description, DateTime startTime, DateTime endTime, Integer penaltyCost) {
        this.student = student;
        this.administrative = administrative;
        this.comment = comment;
        this.penalty = penalty;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }
}
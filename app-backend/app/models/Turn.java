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
    public BigDecimal penaltyCost;

    Turn() {
        student = new Student();
        administrative = new Administrative();
        comment = new Comment();
        penalty = new Penalty();
        description = "";
        startTime = null;
        endTime = null;
        penaltyCost = new BigDecimal(0);
    }

    public Turn(String description, DateTime startTime, DateTime endTime, BigDecimal penaltyCost){
        student = new Student();
        administrative = new Administrative();
        comment = new Comment();
        penalty = new Penalty();
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }

}
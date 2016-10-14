package models;

import org.joda.time.DateTime;
import play.mvc.Controller;

import java.math.BigDecimal;

/**
 * Created by cristian on 10-14-16.
 */

public class Turn extends Controller{
    public Student student;
    public Administrative administrative;
    public Comment comment;
    public Penalty penalty;
    public String description;
    public DateTime startTime;
    public DateTime endTime;
    public int penaltyCost;

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

    public Turn(String description, DateTime startTime, DateTime endTime, int penaltyCost){
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
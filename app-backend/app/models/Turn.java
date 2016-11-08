package models;

import com.avaje.ebean.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Turn extends Model {
    private int                  idTurn;
    private Student              student;
    private Administrative       administrative;
    private String               description;
    private DateTime             startTime;
    private DateTime             endTime;
    private Integer              penaltyCost;

    public Turn() {
        idTurn = 0;
        student = new Student();
        administrative = new Administrative();
        description = "";
        startTime = null;
        endTime = null;
        penaltyCost = 0;
    }

    public Turn(String description, DateTime startTime, DateTime endTime, Integer penaltyCost){
        student = new Student();
        administrative = new Administrative();
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }

    public Turn(int idTurn, Student student, Administrative administrative, String description, DateTime startTime, DateTime endTime, Integer penaltyCost) {
        this.idTurn = idTurn;
        this.student = student;
        this.administrative = administrative;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.penaltyCost = penaltyCost;
    }

    public int getIdTurn() {
        return idTurn;
    }

    public void setIdTurn(int idTurn) {
        this.idTurn = idTurn;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Administrative getAdministrative() {
        return administrative;
    }

    public void setAdministrative(Administrative administrative) {
        this.administrative = administrative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getPenaltyCost() {
        return penaltyCost;
    }

    public void setPenaltyCost(Integer penaltyCost) {
        this.penaltyCost = penaltyCost;
    }

}
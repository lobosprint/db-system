package models;

import org.joda.time.DateTime;

import java.math.BigDecimal;

/**
 * Created by cristian on 10-14-16.
 */
public class Turn {
    public Student          student;
    public Administrative   administrative;
    public Comment          comment;
    public Penalty          penalty;
    public String           description;
    public DateTime         startTime;
    public DateTime         endTime;
    public BigDecimal       penaltyCost;
}

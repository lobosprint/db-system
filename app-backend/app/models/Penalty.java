package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */
@Entity
public class Penalty extends Model {
    public int      idPenalty;
    public Payment  payment;
    public Turn     turn;

    public Penalty(){
        idPenalty   = 0;
        payment     = new Payment();
        turn        = new Turn();
    }

    public Penalty(int idPenalty, Payment payment, Turn turn) {
        this.idPenalty = idPenalty;
        this.payment = payment;
        this.turn = turn;
    }

    public Penalty(int idPenalty, Turn turn) {
        this.idPenalty = idPenalty;
        this.turn = turn;
    }
}

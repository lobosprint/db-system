package models;

import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import javax.persistence.Entity;

/**
 * Created by cristian on 10-14-16.
 */

@Entity
public class Payment extends Model {
    public int      idPayment;
    public Integer  confirmationNumber;
    public DateTime date;

    public Payment(){
        idPayment = 0;
        confirmationNumber = 0;
        date = null;
    }

    public Payment(int idPayment, Integer confirmationNumber, DateTime date) {
        this.idPayment = idPayment;
        this.confirmationNumber = confirmationNumber;
        this.date = date;
    }
}
